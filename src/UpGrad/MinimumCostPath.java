package UpGrad;

import java.util.Scanner;

class MinimumCostPath {

    private static int minCost(int cost[][], int m, int n) {
        int minCost[][] = new int[m + 1][n + 1];
        /* Initialise the first column of the minimum cost (table) array */
        minCost[0][0] = cost[0][0];
        for(int i=1;i<=m;i++){
            minCost[i][0] = minCost[i-1][0] + cost[i][0];
        }
        /* Initialise the first row of the table array */
        for(int i=1;i<=n;i++){
            minCost[0][i] = minCost[0][i-1] + cost[0][i];
        }

        /* Construct the rest of the table array from the recursion relation */
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                minCost[i][j] = Math.min(minCost[i-1][j-1],Math.min(minCost[i-1][j], minCost[i][j-1])) + cost[i][j];
            }
        }

        return minCost[m][n];
    }

    public static void main(String args[]) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        Scanner scan = new Scanner(System.in);
        int xCoordinate = scan.nextInt();
        int yCoordinate = scan.nextInt();
        System.out.println(minCost(cost, xCoordinate, yCoordinate));
    }
}

