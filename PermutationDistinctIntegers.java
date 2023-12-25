import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationDistinctIntegers {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtrack(result, list, 0, nums.length);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int start, int end) {
        if (start == end) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < end; i++) {
                Collections.swap(list, start, i);
                backtrack(result, list, start + 1, end);
                Collections.swap(list, start, i);
            }
        }
    }
}
