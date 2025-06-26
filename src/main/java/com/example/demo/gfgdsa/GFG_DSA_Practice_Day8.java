package com.example.demo.gfgdsa;

import java.util.HashMap;
import java.util.Map;

public class GFG_DSA_Practice_Day8 {

//✅ Longest Common Prefix among an Array of Strings
//✅ Check if One String is a Rotation of Another
//✅ Remove Adjacent Duplicates in a String (like "abbaca" → "ca")
//✅ Check if a String Contains Only Digits
//✅ Count and Print All Duplicates in a String
//✅ Print All Permutations of a Given String (using Recursion)


    public static void main(String[] args) {
        //System.out.println(rotationOfString("antw", "tnaa"));
        allDuplicatesInStringUsingMap("aabcdee");
    }

    static boolean rotationOfString(String str1, String str2){
        if(str1.length()!=str2.length()){
            System.out.println("it is not equal lengths");
            return false;
        }
        int j=0;
        for(int i=str1.length()-1; i>=str1.length()/2;i--){
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
                continue;
            }else{
                System.out.println("it is not rotation of string one");
                return false;
            }
        }
        return true;
    }

    static void allDuplicatesInString(String str){
        int[] count = new int[256];
        for(char ch: str.toCharArray()){
            count[ch]++;
        }

        for(int i=0; i<256; i++){
            if(count[i]>1){
                System.out.println((char)i +" : "+ count[i]   );
            }
        }
    }

    static void allDuplicatesInStringUsingMap(String str){
        Map<Character, Integer> map= new HashMap<>();
        for(char ch: str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(Map.Entry<Character, Integer> feq: map.entrySet()){
            if(feq.getValue()>1){
                System.out.println( feq.getKey() + " : "+ feq.getValue());
            }
        }
    }



}
