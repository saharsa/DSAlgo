package HackerEarth.BinarySearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * There is an infinite series of bulbs indexed from 1. And there are 40 switches indexed from 1 to 40. Switch with index x is connected to the bulbs with indexes that are multiple of x. i.e switch 2 is connected to bulb 4, 6, 8 ....
 *
 * You can easily observe that some bulbs are connected to multiple switches and some are not connected to any switch.
 *
 * Chotu is playing with these switches, he wants to know the Kth glowing bulb from the start if certain switches are in ON state. If any of the switch is ON, connected to any bulb then bulb starts glowing. But chotu has special fond of prime numbers so he only puts prime indexed switches ON.
 *
 * INPUT-
 *
 * First line contains number of test cases (T). Each test case contains two lines- First line contains a string S of length 40 containing 0s and 1s that represents the state of bulbs. 1 is ON , 0 is OFF. Second line contains one integer k. Atleast One switch is in ON condition.
 *
 * OUTPUT-
 *
 * Output one integer per test case representing kth glowing bulb.
 *
 * CONSTRAINTS-
 *
 * 1 <= T <= 500
 *
 * S contains only 0s and 1s. 1s are only at prime positions.
 *
 * 1 <= k <= 10^15
 *
 * 1 is not prime
 */
public class GlowingBulbs {
    public static void main(String[] args) throws Exception {
        //String switches = "0110000000000000000000000000000000000000";
        //String switches = "0010000000000000000000000000000000000000";
        //String switches = "0100000000100000001000100000101000001000";
        //int k = 16807;
        File file = new File("./src/HackerEarth/BinarySearch/input.txt");
        //File x = new File(".");
        //System.out.println(x.getAbsoluteFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        //Scanner sc = new Scanner(System.in);
        //int testCases = Integer.parseInt(sc.nextLine());
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        int testCases = Integer.parseInt(br.readLine());
        for(int h=0;h<testCases;h++){
            //String switches = sc.nextLine();
            String switches = br.readLine();
            //int k = Integer.parseInt(sc.nextLine());
            Long k = Long.parseLong(br.readLine());
            ArrayList<Long> onBulbs = new ArrayList<>();
            for(int i=0;i<primes.length;i++){
                Long switchState = Long.parseLong(""+switches.charAt(primes[i]-1));
                if(switchState==1){
                    onBulbs.add((long)primes[i]);
                }
            }
            System.out.println(calculateKthNumber(k, onBulbs));
        }
    }

    public static long calculateKthNumber(long k, ArrayList<Long> onBulbs) {
        long left = 0, right = k*onBulbs.get(onBulbs.size()-1);
        //System.out.println(right);
        while (right-left > 1) {
            long mid = left + (right-left)/2;
            //System.out.println(mid);
            long multiples_till_mid = calculateMultiples(mid, onBulbs);
            //System.out.println(multiples_till_mid);
            if (multiples_till_mid >= k) {
                right = mid;
                continue;
            }else{
                left=mid;
            }
        }
        return right;
    }

    public static long calculateMultiples(long number, ArrayList<Long> divisors){
        long odd=0,even=0;
        long combinations = (1<<divisors.size());
        for(long i=1;i<combinations;i++){
            long p=1;
            for(long j=0;j<divisors.size();j++){
                if((i & (1<<j))>0){
                    p*=divisors.get((int)j);
                }
            }
            if((Long.bitCount(i) & 1)>=1){
                odd+=(number/p);
            }else{
                even+=(number/p);
            }
        }
        return odd-even;
    }
}
