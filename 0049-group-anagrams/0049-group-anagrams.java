/*class Solution {
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
}*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // Convert string to char array, sort it, and make it the key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            // Group the original string under its sorted signature
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        // Return all the grouped lists from the map values
        return new ArrayList<>(map.values());
    }
}