package com.example.demo.gfgdsa;

public class GFG_DSA_Practice_Day5 {
    public static void main(String[] args) {
        bitwiseOperators();
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
}
