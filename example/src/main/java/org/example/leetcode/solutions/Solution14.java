package org.example.leetcode.solutions;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
// 👍 1196 👎 0

/**
 *
 **/
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        int prefixIndex = 0;
        int length = strs.length;
        int i = 1;
        label:
        for(;;){
            while(i < length ){
                if(prefixIndex < strs[i].length() && prefixIndex < strs[i - 1].length() && strs[i - 1].charAt(prefixIndex) == strs[i].charAt(prefixIndex)){
                    i++;
                }else{
                    break label;
                }
            }
            prefixIndex++;
            i = 1;
        }
        return strs[0].substring(0,prefixIndex);
    }

    public static void main(String[] args) {
        String substring = "".substring(0, 0);
        System.out.println(substring);
        boolean equals = substring.equals("");
        System.out.println(equals);
    }
}
