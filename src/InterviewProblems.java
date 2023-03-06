import org.junit.jupiter.api.Test;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * 面试题 题解
 */
public class InterviewProblems {
    @Test
    public void test() {

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
















