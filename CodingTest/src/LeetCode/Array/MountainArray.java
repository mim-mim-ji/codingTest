package LeetCode.Array;

public class MountainArray {
    /*
    arr.length >= 3
    There exists some i with 0 < i < arr.length - 1 such that:
    arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
    arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     */
    public static void main(String[] args) {
        int[]arr = {0,3,2,1};
        int[]arr2 = {3,7,6,4,3,0,1,0};
        System.out.println(validMountainArray1(arr));
        System.out.println(validMountainArray2(arr2));
    }

    public static boolean validMountainArray1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;

        if(arr.length < 3) return false;

        for(int i=0;i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
                maxIdx = i;
            }
        }

        if(maxIdx == arr.length-1 || maxIdx == 0) return false;

        for(int i=0;i<maxIdx;i++){
            if(arr[i]>=arr[i+1]) return false;
        }

        for(int i=maxIdx+1;i<arr.length;i++){
            if(arr[i]>=arr[i-1]) return false;
        }
        return true;
    }

    //TwoPointer
    public static boolean validMountainArray2(int[] arr) {
        if(arr.length < 3) return false;

        int left = 0;
        int right = arr.length-1;

        while(left < right){
            if(arr[left] < arr[left+1]){
                left++;
            }else if(arr[right]<arr[right-1]){
                right--;
            }else{
                break;
            }
        }
        //arr[left] == arr[right] == top인 arr원소
        if(left == 0 || right == arr.length-1 || arr[left] != arr[right]) return false;

        return true;
    }
}
