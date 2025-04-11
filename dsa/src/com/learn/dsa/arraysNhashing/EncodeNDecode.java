package com.learn.dsa.arraysNhashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeNDecode {
         /*
        * https://leetcode.com/problems/encode-and-decode-strings/description/
        * 271. Encode and Decode Strings
        * */

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : strs){
            stringBuilder.append(s.length()).append("#").append(s);
        }

        return stringBuilder.toString();

    }

    public List<String> decode(String str) {
            List<String> result = new ArrayList<>();
            int index = 0;
            while (index < str.length()){
                int jIndex = index;
                while (str.charAt(jIndex) != '#'){
                    jIndex++;
                }
                int length = Integer.parseInt(str.substring(index, jIndex));
                index = jIndex + 1;
                jIndex = index + length;
                result.add(str.substring(index, jIndex));
                index = jIndex;
            }

            return result;

    }

    public static void main(String[] args) {
        EncodeNDecode encodeNDecode = new EncodeNDecode();
        String encodedString = encodeNDecode.encode(List.of("neetewewewewewewewewfdsadfasfda","code","love","you"));
        System.out.println(encodedString);
        List<String> decodedList = encodeNDecode.decode(encodedString);
        for (String s : decodedList) {
            System.out.println(s);
        }
    }

}
