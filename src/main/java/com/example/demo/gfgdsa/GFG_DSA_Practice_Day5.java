package com.example.demo.gfgdsa;

import java.util.ArrayList;
import java.util.List;

public class GFG_DSA_Practice_Day5 {
    public static void main(String[] args) {
        bitwiseOperators();
        int[] arr= {10,22,12,3,0,6};
        List<Integer> list = leaders(arr);
        for(int i: list){
            System.out.print(i + ", ");
        }


    }
    static void bitwiseOperators(){
        N2B(12);
        N2B(10);
        System.out.println(12 ^ 10);
    }

    static String N2B(int n){
        String a="";
        while(n>=1){
            int x= n%2;
            n=n/2;
            a = x+ a;
        }
        System.out.println(a);

        return a;
    }
    static List<Integer> leaders(int[] arr){
        List<Integer> ans= new ArrayList<>();
        int maxi= Integer.MIN_VALUE;

        for(int i=arr.length-1; i>=0;i--){
            if(arr[i]>maxi){
                ans.add(arr[i]);
            }
            maxi = Math.max(arr[i], maxi);
        }

        return ans;
    }
}
