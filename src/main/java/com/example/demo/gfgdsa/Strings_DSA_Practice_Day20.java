package com.example.demo.gfgdsa;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Strings_DSA_Practice_Day20 {
    public static void main(String[] args) {
        System.out.println(SortCharactersByFrequenc("tree"));

        String str= "leetcodel";
        //int assic = firstNonRepeatingChar(str);
        //System.out.println((char) firstNonRepeatingChar(str));


        printTheCharBasedOnFreq("greeksforgreeks");
    }


/*Time Complexity:
    Building frequency map: O(n) 
    Heap insertions: O(n log n)
    Build result: O(n)
 Total: O(n log n)

Space Complexity:
    HashMap: O(n)
    PriorityQueue: O(n)
    StringBuilder: O(n)
 Total: O(n)
*/
    static String SortCharactersByFrequenc(String str){
        Map<Character, Integer> map= new HashMap<>();

        for(char ch: str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Character> pq= new PriorityQueue<>((a, b)->map.get(b)-map.get(a));

        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch= pq.poll();
            int freq = map.get(ch);
            sb = sb.append(String.valueOf(ch).repeat(freq));
        }
        return sb.toString();
    }

    static int firstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(map.get(ch)==1){
                return ch;
            }
        }
        return -1;
    }

    public void SortCharactersByFrequency(String str){
    }

    static void printTheCharBasedOnFreq(String str){
        int[] count = new int[26];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)-'a']++;
        }
        str.charAt(0);
        for(int i=0;i<26;i++){
            if(count[i]>0){
                System.out.println((char)(i + 'a') + " : " + count[i]);
            }
        }

        System.out.println("**********************");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            if(count[i]>0){
                for(int j=0;j<count[i];j++){
                    sb.append((char) (i+'a'));
                }
            }
        }

        System.out.println(sb.toString());
    }
}
