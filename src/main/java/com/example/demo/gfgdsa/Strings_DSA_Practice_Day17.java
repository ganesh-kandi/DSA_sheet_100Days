package com.example.demo.gfgdsa;

import java.util.*;

public class Strings_DSA_Practice_Day17 {
    public static void main(String[] args) {
    //fizzbuzz(15);
       String[] arr = {"flower","flow","floight"};
        //longestCommonPrefix(arr);
        System.out.println(longestSubStringWithoutSameChar("abatman"));
        System.out.println(longestSubStringWithoutSameCharUsingHashMap("abatman"));
        //System.out.println(validParentheses("([])"));
    }

    static void fizzbuzz(int k){
        List<String> result = new ArrayList<>();
        for(int i=1;i<=k;i++){

            if(i%3==0 && i%5==0){
                result.add("FIZZBUZZ");
            }
            else if(i%3==0){
                result.add("FIZZ");
            }else if(i%5==0){
                result.add("BUZZ");
            }else{
                result.add(String.valueOf(i));
            }
        }

        for (String s: result){
            System.out.print(s + ",");
        }
    }

    static void longestCommonPrefix(String[] str){
        //take first element as prefix
        String prefix= str[0];

        for(int i=1; i<str.length;i++){
            String current= str[i];
            while(current.indexOf(prefix)!=0){
                prefix= prefix.substring(0,prefix.length()-1);
            }
        }
        System.out.println(prefix);
    }

    static int longestSubStringWithSameChar(String str, int k){
        int[] count= new int[26];
        int l=0;
        int maxElement=0, length=0;
        for(int r=0;r<str.length();r++){
            char ch= str.charAt(r);
            count[ch-'A']++;
            maxElement= Math.max(maxElement, count[ch-'A']);

            while(r-l+1 -maxElement >k){
                count[str.charAt(l)-'A']--;
                l++;
            }
            length= Math.max(length,r-l+1);
        }
        return length;
    }

    static int longestSubStringWithoutSameChar(String str){
        HashSet<Character> set =  new HashSet<>();
        int l=0,r=0,maxElement=0;
        while(r<str.length()){
            if(set.contains(str.charAt(r))){
                set.remove(str.charAt(l));
                l++;
            }else {
                set.add(str.charAt(r++));
            }
            maxElement = Math.max(maxElement,r-l);


        }
        return maxElement;
    }

    static int longestSubStringWithoutSameCharUsingHashMap(String str){
        Map<Character,Integer> map = new HashMap<>();
        int left=0; int maxLength=0;
        for(int right=0;right<str.length();right++){
            char ch= str.charAt(right);

            if(map.containsKey(ch)){
                left = Math.max(map.get(ch)+1,left);
            }
            map.put(ch,right);
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;

    }

    static boolean validParenthesesBrute(String str){
        int l;
        do{ l= str.length();
            str = str.replace("()","")
                .replace("{}","")
                .replace("[]","");
        }while(str.length()!=l);
        return str.isEmpty();
    }
    static boolean validParentheses(String str){
        HashMap<Character, Character> map= new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(Character ch: str.toCharArray()){
            if(ch =='('|| ch=='{'|| ch=='['){
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()) return false;
                Character top = stack.pop();
                if (!top.equals(map.get(ch))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
