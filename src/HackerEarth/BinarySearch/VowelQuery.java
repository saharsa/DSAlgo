package HackerEarth.BinarySearch;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class VowelQuery {
    static PrintWriter out = new PrintWriter(System.out);
    static Reader sc = new Reader();
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        char[] s = (" "+sc.readLine()).toCharArray();
        int len = s.length-1;
        int i;
        int[] vows = new int[len+1];
        for(i=1;i<=len;i++){
            vows[i] = vows[i-1];
            if(s[i]=='a' || s[i]=='e' || s[i]=='i' || s[i]=='o' || s[i]=='u')
                vows[i]++;
        }
        int n = sc.nextInt();
        int[] a = new int[n+1];
        long[] cum = new long[n+1];
        for(i=1;i<=n;i++){
            cum[i] = cum[i-1];
            a[i] = sc.nextInt();
            int pos = Math.abs(a[i]);
            if(a[i]>=0) cum[i] += 1L*vows[pos+1];
            else cum[i] += 1L*(vows[len]-vows[pos]);
        }
        int q = sc.nextInt();
        for(i=0;i<q;i++){
            long K = sc.nextLong();
            int pos = Arrays.binarySearch(cum,K);
            System.out.println(K+","+pos);
            if(pos<0) pos = -(pos+1);
            if(pos==n+1){
                System.out.println(-1);
                continue;
            }
            int lo,hi;
            K -= cum[pos-1];
            if(a[pos]>=0){
                lo=1; hi=a[pos]+1;
            }
            else{
                lo=Math.abs(a[pos])+1; hi=len;
            }
            System.out.println(lo+","+hi+","+K);
            while(lo<hi){
                int mid = (lo+hi)>>1;
                int val = vows[mid]-vows[lo-1];
                if(val<K){
                    K -= val;
                    lo = mid+1;
                }
                else hi = mid;
            }
            System.out.println(s[lo]);
        }
        //String S = scanner.next();
        /*int N = scanner.nextInt();
        int[] val = new int[N];
        for(int i=0;i<N;i++){
            val[i] = scanner.nextInt();
        }
        int Q = scanner.nextInt();
        int[] tasks = new int[Q];
        for(int i=0;i<Q;i++){
            tasks[i] = scanner.nextInt();
        }
        StringBuilder X = new StringBuilder("");
        for(int i=0; i<N;i++){
            int pos = val[i];
            if(pos>=0){
                X.append(S.substring(0,Math.abs(pos)+1));
            }else{
                X.append(S.substring(Math.abs(pos)));
            }
        }
        String[] XArr = X.toString().split("");
        String[] vowels = new String[XArr.length];
        int j=0;
        for(int i=0;i<XArr.length;i++){
            if(XArr[i].equals("a") || XArr[i].equals("e") || XArr[i].equals("i") || XArr[i].equals("o") || XArr[i].equals("u")){
                vowels[j] = XArr[i];
                j++;
            }
        }
        for(int i=0;i<Q;i++){
            if(tasks[i]-1<XArr.length){
                if(vowels[tasks[i]-1] != null){
                    System.out.println(vowels[tasks[i]-1]);
                }else{
                    System.out.println(-1);
                }
            }else{
                System.out.println(-1);
            }
        }*/
    }

    static class Reader{
        final private int BUFFER_SIZE = 1 << 20;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[1000000]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

}
