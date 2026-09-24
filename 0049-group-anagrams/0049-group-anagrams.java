class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String , List<String>> frequencystr = new HashMap<>();
        for(String str : strs){
            String frequencyString = getfrequencyString(str);
            if(frequencystr.containsKey(frequencyString)){
                frequencystr.get(frequencyString).add(str);
            }
            else{
                List<String> str1 = new ArrayList<>();
                str1.add(str);
                frequencystr.put(frequencyString , str1);
            }
        }
        return new ArrayList<>(frequencystr.values());
    }
    private String getfrequencyString(String str){
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
                count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for(int i : count){
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }    
}