package com.example.demo.gfgdsa;


public class Strings_DSA_Practice_Day19 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubStringOptimal("abadabc"));
    }

    static String longestPalindromeStringBrute(String str){
        //check all possible palindromes
        String result="";
        int maxLength = 0;
        for(int i=0; i<str.length();i++){
            for(int j=i;j<str.length();j++){
                String sub= str.substring(i,j+1);
                if(isPalindrome(sub) && sub.length()>maxLength){
                    result = sub;
                    maxLength= sub.length();
                }
            }
        }
        return result;
    }
    static boolean isPalindrome(String str){
        int left=0, right=str.length()-1;
        while(left<right){
            if(str.charAt(left++)!= str.charAt(right--)){
                return false;
            }
        }
        return true;
    }
    static int resultStart=0;
    static int resultLength=0;

    static String longestPalindromeSubStringOptimal(String str){

        for(int start=0; start<str.length();start++){
            expand(str, start, start);
            expand(str, start, start+1);
        }
        return str.substring(resultStart, resultStart+resultLength);
    }
    static void expand(String str, int begin, int end){
        while(begin>=0 && end<str.length() && str.charAt(begin)== str.charAt(end)){
            begin--;
            end++;
        }
        if(resultLength< end-begin-1){
            resultStart= begin+1;
            resultLength= end-begin-1;
        }
    }
}
