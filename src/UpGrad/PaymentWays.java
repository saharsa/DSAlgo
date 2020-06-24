package UpGrad;

import java.util.Arrays;
import java.util.Scanner;
public class PaymentWays {
    public static int count(int[] d, int amount) {

        int[][] V = new int[amount + 1][d.length];

        /* Write down the base solution*/
        for(int i=0;i<d.length;i++){
            V[0][i] = 1;
        }
        for(int i=0;i<=amount;i++){
            V[i][0] = 1;
        }

        /* Fill in the rest of the matrix using recursion relation */
        for(int i=1;i<=amount;i++){
            for(int j=1;j<d.length;j++){
                V[i][j] = V[i][j-1] + (i-d[j]>=0?V[i-d[j]][j]:0);
            }
        }
        return V[amount][d.length-1];
    }

    public static void main(String args[]) {
        int[] d = {1,5,7,10};
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        System.out.println(count(d, amount));
        scan.close();
    }
}
