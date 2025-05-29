package com.example.demo.gfgdsa;

import java.util.ArrayList;
import java.util.List;

public class GFG_DSA_Practice_Day4 {

    public static void main(String[] args) {
        int[] arr = {1,1,2,4,6,7,10};
        int[] arr2= {1,2,2,3,11,13};

        mergeTwoSortedArrays(arr, 7, arr2, 6);
    }


    public static void mergeTwoSortedArrays(int[] arr, int m, int[] arr2, int n){

        int i=0, j=0;
        List<Integer> list = new ArrayList<>();
        while(i<m && j<n){
            if(arr[i]<=arr2[j]){
                list.add(arr[i++]);
            }else{
                list.add(arr2[j++]);
            }
        }
        while(i<m){
            list.add(arr[i++]);
        }
        while(j<n){
            list.add(arr2[j++]);
        }

        // it will be possible when the arr size is m+n otherwise it will throw index out of bound
//        for(int k=0; k<m+n; k++){
//            arr[k]= list.get(k);
//        }
        for(int k: list){
            System.out.print(k+", ");
        }
    }
}
