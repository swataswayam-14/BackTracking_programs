import java.util.*;
public class NQueensInNRows {

    public static void nQueensInNRows(char arr[][], int row){
        if(row == arr.length){
            printBoard(arr);
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
    public static void printBoard(char arr[][]){
        System.out.println("-------Chess board--------");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        char arr[][] = new char[5][5];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = '.';
            }
            
        }
        nQueensInNRows(arr, 0);

    }
}
