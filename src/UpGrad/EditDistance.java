package UpGrad;

public class EditDistance {
    public static void main(String[] args) {
        editDistance("olo", "role");
        editDistance("snack", "snap");
    }
    public static void editDistance(String source, String target){
        if(source==null || target==null){
            throw new IllegalArgumentException("Cannot be null");
        }
        int sourceLength = source.length();
        int targetLength = target.length();
        int[][] matrix = new int[sourceLength+1][targetLength+1];
        for(int i=0;i<=targetLength;i++){
            matrix[0][i] = i;
        }
        for(int i=0;i<=sourceLength;i++){
            matrix[i][0] = i;
        }
        for(int i=1;i<=sourceLength;i++){
            for(int j=1;j<=targetLength;j++){
                int cost = 1;
                if(source.charAt(i-1)==target.charAt(j-1)){
                    cost = 0;
                }
                matrix[i][j] = Math.min(cost+matrix[i-1][j-1], Math.min(1+matrix[i-1][j], 1+matrix[i][j-1]));
            }
        }
        System.out.println("Maximum operations required="+matrix[sourceLength][targetLength]);
    }
}
