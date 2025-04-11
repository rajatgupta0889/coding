package com.learn.dsa.arraysNhashing;

public class ProductOfArraysExceptSelf {
    /*
     * https://leetcode.com/problems/product-of-array-except-self/description/
     * 238. Product of Array Except Self
     * */

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;

        int[] prefixProduct= new int[len];

        int[] result= new int[len];
        prefixProduct[0] = 1;
        for(int i =1; i< len; i++){
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }
        int postfixProduct = 1;

        for(int i = len -1; i >=0; i--){
            result[i] = prefixProduct[i] * postfixProduct;
            postfixProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArraysExceptSelf productOfArraysExceptSelf = new ProductOfArraysExceptSelf();
        int[] result = productOfArraysExceptSelf.productExceptSelf(new int[]{1,2,3,4});
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println(" ");
        result =  productOfArraysExceptSelf.productExceptSelf(new int[] {-1,1,0,-3,3});
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
