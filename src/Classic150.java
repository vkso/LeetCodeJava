import java.util.Arrays;
import java.util.HashMap;

public class Classic150 {

    /**
     * 数组 / 字符串
     */

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

    /**
     * 26. 删除有序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    /**
     * 80. 删除有序数组中的重复项II
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int slow = 2, fast = 2;

        while (fast < n) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 169. 多数元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }

            if (count.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    public int majorityElementX(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 189. 轮转数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    public void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

    /**
     * 按照顺序，将原来数组中的 k 位置的值，拷贝到新的数组中
     * @param nums
     * @param k
     */
    public void rotateX(int[] nums, int k) {
        int n = nums.length;
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, n);
    }

    /**
     * 121. 买卖股票的最佳时机
     * Notes: i 天买卖股票获得的最大收益，是 i 天之前的天数中，最低点那天买入。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                if (prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 122.  买卖股票的最佳时机II
     * 在每天都要买卖， 贪心法，只要是当天买入，第二天卖出有利润，就可以进行这一个操作
     * @param prices
     * @return
     */
    public static int maxProfitX(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int ans = 0;

        // 【贪心算法】可以假设，只要前一天的股票买入，今天卖出有利润，那么就最小化的将每一天的利润都累计到最终的结果中
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += (prices[i] - prices[i-1]);
            }
        }

        return ans;
    }


    /**
     * 双指针
     */

    /**
     * 125. 验证回文串
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        // 将字符串大写字符转换为小写字符
        String lowerCase = s.toLowerCase();

        // 移除所有的非字母数字字符
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lowerCase.length(); i++) {
            char ch = lowerCase.charAt(i);
            if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                sb.append(ch);
            }
        }

        String newStr = sb.toString();
        if (newStr == null) {
            return true;
        }

        for (int i = 0, j = newStr.length() - 1; i < j; i++, j--) {
            if (newStr.charAt(i) == newStr.charAt(j)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindromeX(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        StringBuffer reverseSB = new StringBuffer(sb).reverse();
        return sb.toString().contentEquals(reverseSB);
    }

    /**
     * 392. 判断子序列
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0) {
            return true;
        }

        if (tLen == 0) {
            return false;
        }

        int sCur = 0, tCur = 0;

        while (sCur < sLen && tCur < tLen) {
            if (s.charAt(sCur) == t.charAt(tCur)) {
                sCur++;
            }
            tCur++;
        }

        return sCur == sLen;
    }


    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(str);
    }
}
