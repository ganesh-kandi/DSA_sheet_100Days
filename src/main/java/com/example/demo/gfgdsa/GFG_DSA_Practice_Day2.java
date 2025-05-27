package com.example.demo.gfgdsa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GFG_DSA_Practice_Day2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5}; // Input array
        System.out.println(containsDuplicate(arr));

        System.out.println(BinarySearch(arr,4));
    }


    public static boolean containsDuplicate(int[] nums) {
        Set set= new HashSet();
        for(int i=0; i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    //BinarySearch
    public static int BinarySearch(int[] nums, int target) {
        int s=0, e=nums.length-1;
        return searchHelper(nums,s,e,target);
    }
    public static int searchHelper(int[] nums, int s, int e, int target){

        if(s>e){
            return -1;
        }
        else{
            int mid=(s+e)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                return searchHelper(nums, mid+1,e,target);
            }
            else{
                return searchHelper(nums,s,mid-1,target);
            }
        }
    }

    static List<Integer> findEquilibriumIndices(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int totalSum=0;

        for(int i: arr){
            totalSum +=i;
        }

        int leftSum=0;
        int rightSum=0;

        for(int i=0; i<arr.length;i++){
            rightSum = totalSum-leftSum-arr[i];
            if(rightSum== leftSum){
                list.add(i);
            }
            leftSum+=arr[i];
        }
        return list;
    }

}
