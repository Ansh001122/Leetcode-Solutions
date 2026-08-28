class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int left = 0;
        int maxFruits = 0;
        for (int right = 0; right < fruits.length; right++) {
            // Add fruit at right to window
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);
            // If we have more than 2 distinct fruit types, shrink from left
            while (fruitCount.size() > 2) {
                int leftFruit = fruits[left];
                fruitCount.put(leftFruit, fruitCount.get(leftFruit) - 1);
                if (fruitCount.get(leftFruit) == 0) {
                    fruitCount.remove(leftFruit);
                }
                left++;
            }
            // Update maximum window size
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
}