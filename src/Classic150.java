public class Classic150 {

    /**
     * 88. 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // tail 为 nums1 数组的最后一个位置
        int tail = nums1.length - 1;
        int curNums1 = m - 1;
        int curNums2 = n - 1;

        while (curNums1 >= 0 && curNums2 >= 0) {

            if (nums1[curNums1] > nums2[curNums2]) {
                nums1[tail--] = nums1[curNums1];
                curNums1--;
            } else {
                nums1[tail--] = nums2[curNums2];
                curNums2--;
            }

        }

        while (curNums1 >= 0) {
            nums1[tail--] = nums1[curNums1--];
        }

        while (curNums2 >= 0) {
            nums1[tail--] = nums2[curNums2--];
        }
    }

    /**
     * 27. 移除元素
     * @param nums
     * @param val
     * @return 返回数组的有效位置索引，题目的判断，是根据返回的索引来的，并不需要必须修改数组的数组内容
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
