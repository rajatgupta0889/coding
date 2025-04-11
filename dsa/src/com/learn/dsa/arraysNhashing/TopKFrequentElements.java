package com.learn.dsa.arraysNhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    /*
     * https://leetcode.com/problems/top-k-frequent-elements/description/
     * 347. Top K Frequent Elements
     * */

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

       List<Integer>[] freq= new ArrayList[nums.length + 1];
        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            int num = entry.getKey();
            int freqCount = entry.getValue();
            freq[freqCount].add(num);
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = freq.length-1 ; i>=0; i--){
            if(!freq[i].isEmpty()){
                for (int j = 0; j < freq[i].size(); j++){
                    res[index++] = freq[i].get(j);
                    if(index == k)
                        return res;
                }
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] result = topKFrequentElements.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
