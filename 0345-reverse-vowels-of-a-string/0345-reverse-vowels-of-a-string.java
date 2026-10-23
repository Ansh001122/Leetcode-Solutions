class Solution {
    /*public String reverseVowels(String s) {
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
    }*/

    public boolean isVowel(char ch) 
    {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
        ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    public String reverseVowels(String s)
    {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while(left < right)
        {
            while(left < right && !isVowel(arr[left]))
            {
                left++;
            }
            while(left < right && !isVowel(arr[right]))
            {
                right--;
            }
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return new String(arr);
    }
}