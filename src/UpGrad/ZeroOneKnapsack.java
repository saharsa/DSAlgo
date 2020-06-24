package UpGrad;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int knapsackSize = 23;
        int[] weights = {5,7,3,8,4,3,7,5}, values = {12,10,9,16,14,7,14,10};
        maximumValue(knapsackSize, weights, values);
    }

    public static void maximumValue(int knapsackSize, int[] weight, int[] value){
        int nItems = weight.length;
        int[][] matrix = new int[nItems+1][knapsackSize+1];
        for(int i=1;i<=nItems;i++){
            for(int j=1;j<=knapsackSize;j++){
                if(weight[i-1]<=j){
                    matrix[i][j] = Math.max(matrix[i-1][j], value[i-1]+matrix[i-1][j-weight[i-1]]);
                }else{
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }
        System.out.println("Maximum possible value="+matrix[nItems][knapsackSize]);
        int j = knapsackSize;
        int i = nItems;
        while(i>0 && j>0){
            if(matrix[i][j] != matrix[i-1][j]){
                System.out.println("Selected item no. "+i+" of weight="+weight[i-1]);
                j = j - weight[i-1];
            }
            i--;
        }
    }
}
