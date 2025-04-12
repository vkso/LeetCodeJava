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
}
