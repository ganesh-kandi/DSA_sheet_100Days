package com.example.demo.gfgdsa;

import java.util.HashMap;
import java.util.Map;

public class GFG_DSA_Practice_Day3 {
    public static void main(String[] args) {
        int[] arr = {3,10,5,100,2,4,1};
        int target = 6;
//        int[] result = twoSumBrute(arr, target);
//        for(int i: result){
//            System.out.print(i + ", ");
//        }
        //insertionSort(arr);
        mergeSort(arr, 0, 6);
        for (int i:arr) {
            System.out.print(i + ", ");
        }


    }

    static int[] twoSumBrute(int[] arr, int target){
        for(int i=0; i<arr.length;i++){

            for(int j=0;j<arr.length;j++){
                if(i==j){
                    continue;
                }
                if(arr[i]+ arr[j]== target){
                    return new int[] {i, j};
                }

            }
        }
        return null;
    }

    //Optimal solution using hashmap TC: O(N), SC: O(N)
    static int[] twoSum(int[] arr, int target){
        Map<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){

            if(map.containsKey(target-arr[i])){
                return new int[]{map.get(target- arr[i]), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }

    public static void insertionSort(int[] arr){
        for(int i=0; i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp= arr[j-1];
                arr[j-1]= arr[j];
                arr[j]= temp;
                j--;
            }
        }
        for(int i: arr) {
            System.out.print(i + ", ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left<right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }

    }

    public static void merge(int[] arr, int left, int mid ,int right){



        int n1= mid-left +1;
        int n2= right -mid;

        int[] leftarr= new int[n1];
        int[] rigtharr= new int[n2];

        for(int i=0; i<n1;i++){
            leftarr[i]= arr[left+i];
        }
        for(int i=0;i<n2; i++){
            rigtharr[i]= arr[mid+1 +i];
        }
        int k=left;
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(leftarr[i]<= rigtharr[j]){
                arr[k++]= leftarr[i++];
            }else{
                arr[k++]= rigtharr[j++];
            }
        }
        while(i<n1){
            arr[k++]= leftarr[i++];

        }
        while(j<n2){
            arr[k++]= rigtharr[j++];
        }
    }

}
