package com.learn.dsa.arraysNhashing;

import java.util.*;

public class GroupAnagrams {
    /*
     * https://leetcode.com/problems/group-anagrams/description/
     * 49. Group Anagrams
     * */
    public List<List<String>> groupAnagrams(String[] strs) {
                Map<String, List<String>> map = new HashMap<>();

                for( String str : strs){
                    char[] charArray = str.toCharArray();
                    Arrays.sort(charArray);

                    String sortedStr = new String(charArray);
                    map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
                }
                return new ArrayList<>(map.values());
        }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams.groupAnagrams(input);
        System.out.println(result);
    }
}
