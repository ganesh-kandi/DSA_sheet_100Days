package com.example.demo.gfgdsa;

import java.util.Arrays;

public class Strings_DSA_Practice_Day13 {
    public static void main(String[] args) {
        //palindromeusingWhile("acba");
        System.out.println(reverseString("ganesh"));
    }
    public static void palindrome(String str){
        int r= str.length()-1;
        boolean flag=true;
        for(int l=0; l<str.length()/2;l++){
            if(str.charAt(l)!=str.charAt(r)){
                flag= false;
                break;
            }
            r--;
        }
        if(flag)
            System.out.println("it is a palindrome");
        else
            System.out.println("not a palindrome");
    }
    public static void palindromeusingWhile(String str){
        int left=0,right=str.length()-1;
        boolean flag= true;
        while(left<right){
            if(str.charAt(left++)!=str.charAt(right--)){
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println("it is palindrome");
        else
            System.out.println("it is not palindrome");
    }

    static String reverseString(String str){
        int l=0, r=str.length()-1;
        char[] ch = str.toCharArray();
        System.out.println(ch);
        while(l<r){
            swap(ch, l, r);
            l++;
            r--;
        }
        return new String(ch);
    }
    static void swap(char[] ch, int l, int r){
        char t= ch[l];
        ch[l]=ch[r];
        ch[r]=t;
    }
}
