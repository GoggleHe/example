package org.example.leetcode.solutions;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4256 👎 0

import java.util.HashSet;
import java.util.Set;

/**
 *
 **/
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int left = 0, right = 1;
        Set<Character> slide = new HashSet<>();
        slide.add(chars[left]);
        while (left < right && right < chars.length) {
            if (slide.contains(chars[right])) {
                slide.remove(chars[left]);
                left++;
            } else {
                slide.add(chars[right]);
                right++;
            }
            if (left == right) {
                slide.add(chars[right]);
                right++;
            }
            int size = slide.size();
            if (size > result) {
                result = size;
            }
        }
        int size = slide.size();
        if (size > result) {
            result = size;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int length = solution3.lengthOfLongestSubstring("dvdf");
        System.out.println(length);

    }
}
