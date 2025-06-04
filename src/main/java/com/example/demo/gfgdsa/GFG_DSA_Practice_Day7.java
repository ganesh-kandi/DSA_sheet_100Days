package com.example.demo.gfgdsa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GFG_DSA_Practice_Day7 {

//✅ Remove All Duplicates from a String while preserving order
//✅ Check if a String is a Palindrome (Iterative and Recursive)
//✅ String Compression (like aabcccccaaa → a2b1c5a3)
//✅ Sum of Digits in a String
//✅ Sum of All Numbers Present in a String (e.g., "abc12xyz34" → 46)
//✅ Check if Characters of One String Can Form Another (with frequency map)


    public static void main(String[] args) {

//        removeDuplicatesUsingArray("ganian");
//        System.out.println(isPalindrome("gannag"));

        //System.out.println(stringCompression("aaabccdabbbb"));

        System.out.println(sumOfDigitsOptimal("abc12xyz34"));

        System.out.println(canFormString("aabbcc", "aabccbb"));
    }
    static void removeDuplicates(String str){
        Set<Character> set = new HashSet<>();
        char[] chars= str.toCharArray();
        for(char ch: chars){
            if(set.add(ch)){
                continue;
            }else{

                System.out.print(ch+", ");
            }
        }
    }

    static void removeDuplicatesUsingArray(String str){
        int[] count = new int[256];
        for(char ch: str.toCharArray()){
            count[ch]++;
        }

        for(int i=0; i<256;i++){
            if(count[i]>1){
                System.out.print((char) i+", ");
            }
        }
    }

    static boolean isPalindrome(String str){
        int j=str.length()-1;
        for(int i=0; i<str.length()/2;i++){
            if(str.charAt(i)== str.charAt(j)){
                j--;
                continue;
            }else{
                return false;
            }
        }
        System.out.println("it is a palindrome");
        return true;
    }

    static  String stringCompression(String str){

        StringBuilder result= new StringBuilder();
        int count=1;
        for(int i=1; i<str.length();i++){
            if(str.charAt(i-1)== str.charAt(i)){
                count++;
            }else{
                result.append(str.charAt(i-1)).append(count);
                count=1;
            }
        }
        result.append(str.charAt(str.length()-1)).append(count);
        return result.toString();
    }

    static int sumoOfDigits(String str){
        int count=0;
        for(char ch: str.toCharArray()){
            if(Character.isDigit(ch)){
                System.out.println(ch);
                count += Integer.parseInt(String.valueOf(ch));
            }else{
                continue;
            }
        }
        return count;
    }

    static int sumOfDigitsOptimal(String str){
        int sum=0;
        StringBuilder num = new StringBuilder();
        for(char ch: str.toCharArray()){
            if(Character.isDigit(ch)){
                num.append(ch);

            }else{
                if(num.length()>0){
                    sum += Integer.parseInt(num.toString());
                    num.setLength(0);
                }
            }
        }
        sum += Integer.parseInt(num.toString());
        return sum;
    }

    static boolean canFormString(String str1, String str2){
        Map<Character,  Integer> freqMap= new HashMap<>();

        for(char ch: str1.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        for(char ch: str2.toCharArray()){
            if(!freqMap.containsKey(ch) || freqMap.get(ch) ==0){
                return false;
            }
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)-1);
        }
        return true;
    }




}
