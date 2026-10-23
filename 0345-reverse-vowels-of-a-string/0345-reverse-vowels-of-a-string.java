class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] ch = s.toCharArray();
        int left = 0;
        int right = ch.length - 1;
        String vowels = "aeiouAEIOU";

        while(left < right){
            while (left < right && vowels.indexOf(ch[left]) == -1) { //move left till it find a vowel
                left++;
            }
            while (left < right && vowels.indexOf(ch[right]) == -1) {//move right till it find a vowel 
                right--;
            }
            if (left < right) { //now swap them as the question suggest to give output in reverse order
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        return new String(ch);
    }
}