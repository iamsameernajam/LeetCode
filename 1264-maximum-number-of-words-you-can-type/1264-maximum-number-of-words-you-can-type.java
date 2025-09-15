class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String [] words=text.split(" ");
        if(brokenLetters.length()==0)return words.length;
        int count=0;
        for(String word:words){
            boolean flag=true;
            for(char chr :word.toCharArray()){
                if(brokenLetters.indexOf(chr)>=0){
                    flag=false;
                    break;
                }
            }
            if(flag)count++;
        }
        return count;
    }
}