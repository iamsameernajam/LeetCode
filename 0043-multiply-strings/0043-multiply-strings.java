class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int m = num1.length();
        int n = num2.length();
        
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        
        for (int i = 0; i < m; i++) {
            arr1[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = num2.charAt(i) - '0';
        }
        int[] result = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = arr1[i] * arr2[j];
                int sum = mul + result[i + j + 1];
                
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;    
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < result.length && result[index] == 0) {
            index++; 
        }
        while (index < result.length) {
            sb.append(result[index++]);
        }
        
        return sb.toString();
    }
}
