import java.util.*;

public class BacktrackingOnArrays{
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
    public static void ChangeArray(int val , int i , int arr[]){
        if(i==arr.length){
            printArray(arr);
            return;
        }

        arr[i] = val;
        ChangeArray(val+1, i+1, arr);
        arr[i] = arr[i] - 2;//backtracking step 
    }
    public static void main(String args[]){
        int arr[] = new int[5];
        ChangeArray(1,0,arr);
        printArray(arr);

    }
}