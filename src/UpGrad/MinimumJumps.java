package UpGrad;

import java.util.Arrays;
import java.util.Scanner;

class MinimumJumps {
    public static int minJump(int n) {
        int f[] = new int[n + 1];
        f[1] = 0;
        for(int i=2;i<=n;i++){
            f[i] = (i%2==0 ? (i%3==0? Math.min(f[i-1], Math.min(f[i/2], f[i/3])) : Math.min(f[i-1], f[i/2])) : (i%3==0? Math.min(f[i/3], f[i-1]) : f[i-1])) + 1;
        }
        return f[n];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int distance = scan.nextInt();
        if (distance > 0) {
            System.out.println(minJump(distance));
        } else {
            System.out.println("Distance should be a positive integer");
        }

    }
}

