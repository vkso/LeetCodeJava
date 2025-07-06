import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {

    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int i : nums2) {
            this.map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }

    public void add(int index, int val) {
        this.nums2[index] += val;
        this.map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int i : nums1) {
            count += this.map.getOrDefault(tot - i, 0);
        }
        return count;
    }
}
