class Solution {
    public String maxSumOfSquares(int num, int sum) {
       /* if(sum > num * 9){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < num;i++){
            if(sum >= 9){
                sb.append(9);
                sum -= 9;
            }
            else{
                sb.append(sum);
                sum = 0;
            }
        }
        return sb.toString();*/

        if (sum > 9L * num) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int nines = sum / 9;
        int remainder = sum % 9;
        
        for (int i = 0; i < nines; i++) {
            sb.append('9');
        }
        if (remainder > 0) {
            sb.append(remainder);
        }
        while (sb.length() < num) {
            sb.append('0');
        }
        return sb.toString();
    }
}