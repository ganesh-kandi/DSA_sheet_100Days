package com.example.demo.gfgdsa;
 class Employee{
    String name;
}
public class Demo {

    public static void main(String[] args) {
        //String reverse= reverseString("ganesh");

        Employee e=new Employee();
        e.name="a";
        Integer x=new Integer(10);
        emp(x);
System.out.println(x);
       // System.out.println(1004%10);
    }
    public static void emp(Integer x) {
       Integer.sum(x,20);
    }
        public static void emp(Employee e)
    {
        //e=new Employee();
        e.name="string";
    }
    public static String reverseString(String name){
        //ganesh -> hsenag
        //gh
        //{g,h} 0, 2-1=1
        //chars[0] = g;
        char[] chars= name.toCharArray();
        int left=0, right= chars.length-1;
        while(left<right){
            char temp= chars[left]; //temp=g
            chars[left]=chars[right];// h
            chars[right]= temp; //g
            left++; //1
            right--;//0
        }
        return new String(chars);
    }

    //4004

    //4004
    public static void palimdrom(int i){
        int reverse=0;
        while(i>0){
           int digit = i% 10;
           reverse = reverse *10 + digit;
           i=i/10;
        }
    }
}
