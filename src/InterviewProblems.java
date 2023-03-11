import org.junit.jupiter.api.Test;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * 面试题 题解
 */
public class InterviewProblems {
    @Test
    public void test() {
        String[] array = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        String[] longestSubarray = findLongestSubarray(array);
        for (String s : longestSubarray) {
            System.out.println(s);
        }

    }

    /**
     * 面试题01.06. 字符串压缩
     *
     * @param s
     * @return
     */
    public String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        int l = 0, r = 0, len = s.length();
        while (l < len) {
            while (r < len && s.charAt(l) == s.charAt(r)) {
                ++r;
            }
            sb.append(s.charAt(l)).append(r - l);
            l = r;
        }
        return sb.length() < len ? sb.toString() : s;
    }

    /**
     * 面试题16.07. 最大数值
     * Tips: 不使用条件判断运算符 if else 语句
     *
     * @param a
     * @param b
     * @return
     */
    public int maximum(int a, int b) {
        return ((Math.abs(a - b) + a + b) / 2);
    }

    /**
     * No. 16.24. 数对和
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                --right;
            } else if (sum < target) {
                ++left;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                ret.add(list);
                --right;
                ++left;
            }
        }
        return ret;
    }

    /**
     * 面试题 17.05. 字母与数字
     *     Tips: 将两个字母分别用 1 和 -1 代替，问题可以转换为"前缀和"问题
     * @param array
     * @return
     */
    public String[] findLongestSubarray(String[] array) {
        Map<Integer, Integer> indices = new HashMap<>();
        indices.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        int startIndex = -1;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                ++sum;
            } else {
                --sum;
            }
            if (indices.containsKey(sum)) {
                int firstIndex = indices.get(sum);
                if (i - firstIndex > maxLength) {
                    maxLength = i - firstIndex;
                    startIndex = firstIndex + 1;
                }
            } else {
                indices.put(sum, i);
            }
        }
        if (maxLength == 0) {
            return new String[0];
        }
        String[] ans = new String[maxLength];
        System.arraycopy(array, startIndex, ans, 0, maxLength);
        return ans;
    }

    /**
     * 面试题17.22. 单词转换
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        List<String> list = new ArrayList<>();
        if (!set.contains(endWord)) {
            return list;
        }
        Queue<List<String>> queue = new LinkedList<>();
        list.add(beginWord);
        queue.add(list);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                List<String> curPath = queue.poll();
                String curWord = curPath.get(curPath.size() - 1);
                for (int i = 0; i < curWord.length(); i++) {
                    char[] ch = curWord.toCharArray();
                    char temp = ch[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == temp) {
                            continue;
                        } else {
                            ch[i] = j;
                        }
                        String nextWord = new String(ch);
                        if (set.contains(nextWord)) {
                            List<String> newPath = new ArrayList<>(curPath);
                            newPath.add(nextWord);
                            set.remove(nextWord);
                            if (nextWord.equals(endWord)) {
                                return newPath;
                            } else {
                                queue.add(newPath);
                            }
                        }
                    }
                    ch[i] = temp;
                }
                size--;
            }
        }
        return new ArrayList<>();
    }


}
















