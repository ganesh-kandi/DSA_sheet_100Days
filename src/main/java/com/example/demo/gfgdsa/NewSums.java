package com.example.demo.gfgdsa;

public class NewSums {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(isValidJump(nums));
        System.out.println(minJumpOpt(nums));
    }

    public static boolean isValidJump(int[] arr){
        int maxJump=0;

        for(int i=0;i<arr.length; i++){
            if(i > maxJump) return false;
            maxJump = Math.max(maxJump, arr[i]+i);
            if(maxJump >= arr.length-1) return true;
        }
        return false;
    }
    public static int minJump(int[] arr){
        int min= Integer.MAX_VALUE;
        int[][] dp = new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0; j<arr.length;j++){
                dp[i][j]=-1;
            }
        }
        return jump(arr, dp,0,0);

    }
    public static int jump(int[] arr, int[][] dp, int index, int jump){
        int mini=Integer.MAX_VALUE;

        if(index>=arr.length-1) return jump;
        if(dp[index][jump]!=-1) return dp[index][jump];
        for(int i=1; i<= arr[index];i++){
            mini= Math.min(mini, jump(arr,dp,index+i,jump+1));
        }
        dp[index][jump]=mini;
        return mini;
    }

    //optimal solution for min jumps converting recursion to range r and l
    public static int minJumpOpt(int[] arr){
        int l=0, r=0; int jumps=0;
        while(r< arr.length-1){
            int far=r;
            for(int i=l; i<=r; i++){
                far= Math.max(far, i+arr[i]);
            }
            jumps++;
            l=r+1;
            r= far;
        }
        return jumps;
    }


}
