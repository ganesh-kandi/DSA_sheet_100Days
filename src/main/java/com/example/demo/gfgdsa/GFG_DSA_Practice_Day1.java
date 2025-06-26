package com.example.demo.gfgdsa;

public class GFG_DSA_Practice_Day1 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 5}; // Input array
        int sum = 20; // Target product value

        // Check if there is a subarray with the given product and print the result
        //System.out.println(hasSubarrayWithSum(arr,sum));

        int arr1[] = {1, 2, -5, -4}; // Input array
        int product = 20;
        //System.out.println(hasSubarrayWithProductOA(arr,product));
        findTwoArrays(arr);
        //System.out.println(8/3);
    }
    static boolean hasSubarrayWithSum(int[] arr, int k) {
        int n= arr.length;
        for(int i=0; i<n; i++) {
            int sum=0;
            for(int j=i;j<n;j++) {
                sum = sum+arr[j];
                if(sum==k) {
                    return true;
                }
            }
        }
        return false;
    }
    //bruteforce approach
    //TC: O(N^2), O(1)
    static boolean hasSubarrayWithProduct(int[] arr, int k) {
        int n= arr.length;
        for(int i=0; i<n;i++){
            int product=1;
            for(int j=i;j<n;j++){
                product= product*arr[j];
                if(product==k){
                    return true;
                }
            }
        }
        return false;
    }

    //optimised approach
    //recommended only for +ve's with TC of O(N) with sliding window technique
    static boolean hasSubarrayWithProductOA(int[] arr, int k) {
        int start=0;
        int product=1; int n= arr.length;
        for(int end= 0; end<n; end ++){
            product = product * arr[end];

            while(product > k && start<= end){
                product = product / arr[start];
                start++;
            }
            if(product== k){
                return true;
            }
        }
        return false;
    }

    //Max SubArray Sum
    static int maxSubArraySum(int[] arr){
        int cur_Sum= 0;
        int final_Sum= Integer.MIN_VALUE;

        for(int i: arr){
            cur_Sum +=i;

            if(final_Sum< cur_Sum){
                final_Sum= cur_Sum;
            }
            if(cur_Sum<0){
                cur_Sum=0;
            }
        }
        return final_Sum;
    }
    //643. Maximum Average Subarray I
    public double findMaxAverage(int[] arr, int k) {
        int n= arr.length;
        int sum=0;

        for (int j : arr) {
            sum += j;
        }
        int maxSum= sum;
        //slilde the window
        for(int i=k;i<n;i++){
            sum = sum -arr[i-k]+arr[i];
            maxSum= Math.max(sum, maxSum);
        }
        return (double) maxSum/k;
    }

    public static int findSplitPoint(int[] arr) {
        int n= arr.length;
        int leftSum=0;
        for(int i: arr){
            leftSum +=i;
        }

        int rightSum=0;
        for(int i= n-1; i>=0; i--){
            rightSum += arr[i];

            leftSum -=arr[i];
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }
    static void findTwoArrays(int[] arr){
        int n= arr.length;
        int splitPoint = findSplitPoint(arr);
        if(splitPoint==-1 || splitPoint== n){
            System.out.println("not possible");
        }
        else{
            for(int i=0; i<n;i++){
                if(splitPoint==i)
                    System.out.println();
                System.out.print(arr[i]+ " ");
            }
        }
    }

}
