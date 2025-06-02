package com.example.demo.gfgdsa;

import java.util.*;

public class GFG_DSA_Practice_Day6 {

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 3};
        String s1 = "GREEKSFORGREEKS";
        String s2 = "GEEKRS";
        System.out.println(compareTwoStrings(s1, s2));
        String str= "i am ganesh";
        System.out.println(reverseString(str));
        System.out.println(reverseWord("Ganesh"));
        System.out.println(reverseStingBrute(str));
        findFirstNonRepeatingBrute("aabccd");
        System.out.println(firstNonRepeatingCharacter("aabccd"));
        System.out.println(firstNonRepeatingCharacterUsingLinkedHasMap("aabbcc"));
    }

    static void findDuplicates(int[] arr) {
        Set<Integer> set = new HashSet();
        for (int i : arr) {
            if (set.add(i)) {
                continue;
            } else {
                System.out.println("the duplicate number is: " + i);
                break;
            }

        }
    }


    static boolean compareTwoStrings(String s1, String s2) {
        if (s1.length() < s2.length())
            return false;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == s2.length();

    }

    static boolean anagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    static String reverseString(String str) {
        char[] letters = str.toCharArray();
        int start = 0;
        for (int low = 0; low < letters.length; low++) {
            if (letters[low] == ' ') {
                reverse(letters, start, low - 1);
                start = low + 1;

            }
        }
        reverse(letters, start, letters.length-1);
        reverse(letters, 0, letters.length-1);
        return new String(letters);
    }
    static String reverseWord(String str){
        char[] letters= str.toCharArray();
        reverse(letters,0, letters.length-1);
        return new String(letters);
    }



    static void reverse(char[] str, int low , int high){
        while(low < high){
            char temp = str[low];
            str[low]= str[high];
            str[high]= temp;
            low++;
            high--;
        }
    }
    //using stack data structure
    static String reverseStingBrute(String str){
        String[] string= str.trim().split("\\s+");
        Stack<String> stack = new Stack<>();
        StringBuilder result= new StringBuilder();
        for(String ch: string){
            stack.push(ch);

        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
            if(!stack.isEmpty()){
                result.append(" ");
            }
        }
        return result.toString();
    }

    static void findFirstNonRepeatingBrute(String str){
        for(int i=0; i<str.length();i++){
            boolean flag= false;
            for(int j=0; j<str.length(); j++){
                if(i != j && str.charAt(i)==str.charAt(j)){
                    flag= true;
                    break;
                }
            }
            if(!flag){
                System.out.println(str.charAt(i));
                break;
            }

        }
    }

    static char firstNonRepeatingCharacter(String str){
        int[] count= new int[256];
        for(char ch: str.toCharArray()){
            count[ch]++;
        }
        for(int i=0; i<str.length();i++){
            if(count[str.charAt(i)]==1){
                return str.charAt(i);
            }
        }
        return 0;
    }

    static char firstNonRepeatingCharacterUsingLinkedHasMap(String str){
        Map<Character, Integer> map= new LinkedHashMap<>();

        for(char ch: str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(Map.Entry<Character, Integer> entrySet: map.entrySet()){
            if(entrySet.getValue()==1){
                return entrySet.getKey();
            }
        }
        return 0;
    }


}
