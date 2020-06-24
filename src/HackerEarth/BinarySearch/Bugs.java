package HackerEarth.BinarySearch;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.Scanner;

/**
 * You are developer at XYZ company. You like to call the bugs in your code as enemies. You maintain
 * an array A of the list of enemies in decreasing order of their difficulty i.e., the most
 * difficult bug will be the first element of the array. Initally, there is no bugs in the code. You
 * are given N tasks. Each task contains one of the following two types of operations:
 * <p>
 * 1. 1 P: Add a bug with difficulty P into the array A.
 * <p>
 * 2. 2: Sort the array in decreasing order and print the difficulty of (n / 3)th bug in the sorted
 * array, where n is the size of the array A. If the number of bugs is less than 3, print Not enough
 * enemies.
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First line contains an integer N, denoting the number of tasks.
 * <p>
 * The next N lines contain one of the two types of operations mentioned above.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * For every operation of type 2, print the difficulty of (n / 3)th bug in the sorted array, where n
 * is the size of the array A. If the number of bugs is less than 3, print Not enough enemies.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * <p>
 * SAMPLE INPUT 10 1 1 1 7 2 1 9 1 21 1 8 1 5 2 1 9 2 SAMPLE OUTPUT Not enough enemies 9 9
 * Explanation Task 1: Add 1 to the array. Current array is [1].
 * <p>
 * Task 2: Add 7 to the array. Current array is [7,1].
 * <p>
 * Task 3: Array size is less than 3. Output is "Not enough enemies".
 * <p>
 * Task 4: Add 9 to the array. Current array is [9,7,1].
 * <p>
 * Task 5: Add 21 to the array. Current array is [21,9,7,1].
 * <p>
 * Task 6: Add 8 to the array. Current array is [21,9,8,7,1].
 * <p>
 * Task 7: Add 5 to the array. Current array is [21,9,8,7,5,1].
 * <p>
 * Task 8: Array size is 6. n/3 is equal to 2. Number at rank 2 in array is 9. Output is 9.
 * <p>
 * Task 9: Add 9 to the array. Current array is [21,9,9,8,7,5,1].
 * <p>
 * Task 10: Array size is 7. n/3 is equal to 2. Number at rank 2 in array is 9. Output is 9.
 */
public class Bugs {

    public static PrintWriter w = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        Reader scanner = new Reader();
        int taskLength = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < taskLength; i++) {
            int operation = scanner.nextInt();
            if (operation == 1) {
                int toAdd = scanner.nextInt();
                addElement(arr, toAdd);
            } else if (operation == 2) {
                if (arr.size() < 3) {
                    System.out.println("Not enough enemies");
                } else {
                    System.out.println(arr.get(arr.size() - arr.size() / 3));
                }
            }
        }
        w.flush();
    }

    public static void addElement(ArrayList<Integer> list, int x) {
        if (list.isEmpty()) {
            list.add(x);
            return;
        }
        if (list.size() == 1) {
            if (list.get(0) < x)
                list.add(x);
            else
                list.add(0, x);
            return;
        }
        if (list.get(list.size() - 1) < x) {
            list.add(x);
            return;
        }
        int low = 0, high = list.size() - 1, mid = 0;
        while (low < high) {
            mid = (low + high) >> 1;
            if (list.get(mid) < x) {
                low = mid + 1;
                continue;
            }
            if (list.get(mid) > x) {
                high = mid;
                continue;
            }
            if (list.get(mid) == x) {
                low = high = mid;
            }
        }
        list.add(low, x);
        return;
    }
}

class Reader {

    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String nextLine() throws IOException {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public String next() throws IOException {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg) {
            return -ret;
        }
        return ret;
    }

    public int[] nextIntArray(int n) throws IOException {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        return a;
    }

    public char nextChar() throws IOException {
        return next().charAt(0);
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg) {
            return -ret;
        }
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }

        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg) {
            return -ret;
        }
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) {
            buffer[0] = -1;
        }
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead) {
            fillBuffer();
        }
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null) {
            return;
        }
        din.close();
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
}
