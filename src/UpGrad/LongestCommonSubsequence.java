package UpGrad;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ataatctgtactttcgcgcgcgatacagttgctcaagtagccattcgggtgcctgacggcatgacatgtatgccactttcaccaaagtaatcatcttaac";
        String s2 = "ggtaataaaaggctcgcccaccccgaccctgaagtgaagaagtaacgttgttcatgatcgacccgcatgaattcatagcaacgccgactgatctactccc";
        //String s1 = "CBABACA";
        //String s2 = "ABCABBA";
        lcs(s1,s2);
        //System.out.println("catctacatcttaactcatgcccgccgatg".length());
    }

    public static void lcs(String s1, String s2){
        int[][] matrix = new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<=s2.length();i++){
            for(int j=0;j<=s1.length();j++){
                if(i==0 || j==0){
                    matrix[i][j] = 0;
                }else if(s1.charAt(j-1)==s2.charAt(i-1)){
                    matrix[i][j] = 1 + matrix[i-1][j-1];
                }else{
                    matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
                }
            }
        }
        System.out.println("Longest subsequence length="+matrix[s2.length()][s1.length()]);
        int j=s1.length(), i=s2.length();
        while(i>0 && j>0){
            //System.out.println(s1.charAt(i-1)+" "+i+" "+s2.charAt(j-1)+" "+j);
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                System.out.print(s1.charAt(i-1));
                i--;
                j--;
            }else{
                if(matrix[i-1][j]>matrix[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
    }
}
