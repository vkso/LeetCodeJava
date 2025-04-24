package com.classic150;

public class BinarySearch {
    /**
     * No. 35 搜索插入位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {    // =
            int mid = l + (r - l) / 2;    // 向下取整，这里 l 是向下取整获得的结果
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;    // 目标插入点的位置，即第一个大于 target 出现的位置
    }
}
