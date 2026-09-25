/*class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void findCombinations(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index == candidates.length || target < 0) {
            return;
        }
        current.add(candidates[index]);
        findCombinations(candidates, target - candidates[index], index, current, result);
        current.remove(current.size() - 1); // Backtrack
        findCombinations(candidates, target, index + 1, current, result);
    }
}*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] candidates, int remain, int startIndex, List<Integer> currentPath, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            currentPath.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i, currentPath, result);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}