import java.util.*;
public class NQueensNoOfWays {

    //static variable - because in recursion for each function call , a new parameter is passed , we donot want that , instead we want to use a single variable to store the number of ways
    static int count;

    public static void nQueensInNRows(char arr[][], int row){
        if(row == arr.length){
            count++;
            return;
        }
        //column loop
        
        for(int j=0;j<arr.length;j++){
            if(isSafe(arr, row, j)){
                arr[row][j] = 'Q';
                nQueensInNRows(arr, row+1);//function call
                arr[row][j] = '.';//backtracking
            }
        }
    }
    public static boolean isSafe(char arr[][] , int row , int col){
        //vertical up
        for(int i=row-1 ; i>=0;i--){
            if(arr[i][col] == 'Q'){
                return false;
            }
        }

        //diagonal left up
        for(int i=row-1 , j=col-1 ; i>=0 && j>=0;i--,j--){
            if(arr[i][j] == 'Q'){
                return false;
            }
        }

        //diagonal right up

        for(int i=row-1, j=col+1 ; i>=0 && j< arr.length;i--, j++){
            if(arr[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
  
    public static void main(String args[]){
        char arr[][] = new char[4][4];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = '.';
            }
            
        }
        nQueensInNRows(arr, 0);
        System.out.println("Total ways to solve N queens is "+count);

    }
}
//the time complexity of this code is O(n!)