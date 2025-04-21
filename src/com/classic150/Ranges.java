package com.classic150;

import java.util.ArrayList;
import java.util.List;

public class Ranges {


    /**
     * No. 228 汇总区间
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        ArrayList<String> res = new ArrayList<>();
        if (length == 0) {
            return res;
        }


        int slow = 0, fast = 0;

        while (slow < length) {
            fast = slow + 1;
            while (fast < length && nums[fast] - nums[fast -1] == 1) {
                ++fast;
            }

            if (fast - slow > 1) {
                res.add(nums[slow] + "->" + nums[fast - 1]);
            } else {
                res.add(String.valueOf(nums[slow]));
            }
            slow = fast;
        }

        return res;
    }
}
