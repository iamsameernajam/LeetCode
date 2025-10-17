public class Solution {
    // Create a map to store the results of our calculations
    private Map<Long, Integer> calculatedResults = new HashMap<>();
    // The input string
    private String inputString;
    // The maximum number of unique characters allowed
    private int maxUniqueCharacters;

    public int calculate(long currentIndex, long uniqueCharacters, boolean canChangeCharacter) {
        // Generate a unique key for our map
        long key = (currentIndex << 27) | (uniqueCharacters << 1) | (canChangeCharacter ? 1 : 0);

        // If we've already calculated this result, return it
        if (calculatedResults.containsKey(key)) {
            return calculatedResults.get(key);
        }

        // If we've reached the end of the string, return 0
        if (currentIndex == inputString.length()) {
            return 0;
        }

        // Get the index of the current character in the alphabet
        int characterIndex = inputString.charAt((int) currentIndex) - 'a';
        // Update the unique characters
        long updatedUniqueCharacters = uniqueCharacters | (1L << characterIndex);
        // Count the number of unique characters
        int uniqueCharacterCount = Long.bitCount(updatedUniqueCharacters);

        int result;
        if (uniqueCharacterCount > maxUniqueCharacters) {
            result = 1 + calculate(currentIndex + 1, 1L << characterIndex, canChangeCharacter);
        } else {
            result = calculate(currentIndex + 1, updatedUniqueCharacters, canChangeCharacter);
        }

        // If we can change the character, try changing it to all possible characters
        if (canChangeCharacter) {
            for (int newCharacterIndex = 0; newCharacterIndex < 26; ++newCharacterIndex) {
                long newSet = uniqueCharacters | (1L << newCharacterIndex);
                int newUniqueCharacterCount = Long.bitCount(newSet);

                if (newUniqueCharacterCount > maxUniqueCharacters) {
                    result = Math.max(result, 1 + calculate(currentIndex + 1, 1L << newCharacterIndex, false));
                } else {
                    result = Math.max(result, calculate(currentIndex + 1, newSet, false));
                }
            }
        }

        // Store the result in our map and return it
        calculatedResults.put(key, result);
        return result;
    }

    public int maxPartitionsAfterOperations(String s, int k) {
        // Set the input string and maximum unique characters
        inputString = s;
        maxUniqueCharacters = k;
        // Start the calculation
        return calculate(0, 0, true) + 1;
    }
}
