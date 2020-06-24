package UpGrad;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CoinExchange {
    public static void dynamic(int[] denominations, int amount){
        int[][] V = new int[amount+1][denominations.length+1];
        HashMap<Integer,Integer> denCount = new HashMap<>();
        for(int j=0;j<=denominations.length;j++){
            V[0][j] = 0;
        }
        for(int i=0;i<=amount;i++){
            V[i][0] = i;
        }
        for(int j=1;j<= denominations.length;j++){
            for(int i=1;i<=amount;i++){
                if(denominations[j-1]<=i && V[i][j-1] > V[i-denominations[j-1]][j]+1){
                    V[i][j] = 1 + V[i-denominations[j-1]][j];
                }else{
                    V[i][j] = V[i][j-1];
                }
            }
        }
        System.out.println("Minimum no. of coins required="+V[amount][denominations.length]);
        System.out.println("The coins are:");
        for(int i=amount;i>=1;i--){
            for(int j=denominations.length;j>=1;j--){
                while(j>0){
                    if(V[i][j]==V[i][j-1]){
                        j=j-1;
                    }else{
                        //System.out.print(denominations[j-1]+" ");
                        if(denCount.get(denominations[j-1])==null){
                            denCount.put(denominations[j-1],1);
                        }else{
                            denCount.put(denominations[j-1], denCount.get(denominations[j-1])+1);
                        }
                        i = i-denominations[j-1];
                    }
                }
            }
        }
        for (Map.Entry entry : denCount.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        for(int i=0;i<=amount;i++){
            for(int j=0;j<=denominations.length;j++) {
                System.out.print(V[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void dynamic2(int[] d, int amount) {
        int[][] V = new int[amount + 1][d.length + 1];

        // if amount=0 then you don't need any coin to pay for 0
        for (int j = 0; j <= d.length; j++) {
            V[0][j] = 0;
        }

        // if you are supposed to use the first coin only then you have to give so many coins, as first coin has value 1
        for (int i = 0; i <= amount; i++) {
            V[i][0] = i;
        }


        // now fill rest of the matrix.
        for (int j = 1; j <= d.length; j++) {
            for (int i = 1; i <= amount; i++) {

                // check if the coin value is less than the amount needed
                if (d[j - 1] <= i && V[i][j - 1] > V[i - d[j - 1]][j] + 1) {
                    V[i][j] = 1 + V[i - d[j - 1]][j];
                } else {
                    V[i][j] = V[i][j - 1];
                }
            }
        }
        System.out.println("Minimum number of coins used is :" + V[amount][d.length]);


        int i = amount;
        int j = d.length;
        while (j > 0 && i > 0) {

            if (V[i][j] == V[i][j - 1]) {
                j = j - 1;

            } else {

                System.out.println("Picked coin  :" + d[j - 1]);
                i = i - d[j - 1];
            }

        }

        while (i > 0) {
            System.out.println("Picked coin  :" + d[0]);
            i = i - 1;
        }

    }

    public static void main(String[] args) {
        int[] denominations = {1,2,5,8,10,14};
        int amount = 1291;
        dynamic(denominations, amount);
        //dynamic2(denominations,amount);
    }
}
