import java.util.*;
public class EditDistance {
    public static int minEditDistance(String x,String y) {
            int n=x.length();
            int m=y.length();
            int[][] a=new int[n+1][m+1];
            for(int i=0;i<=n;i++) {
                a[i][0]=i;
            }
            for(int j=0;j<=m;j++) {
                a[0][j]=j;
            }
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=m;j++) {
                    if(x.charAt(i-1)==y.charAt(j-1)) {
                            a[i][j]=a[i-1][j-1];
                    }else {
                            a[i][j]=Math.min(a[i-1][j-1]+2,Math.min(a[i-1][j]+1,a[i][j-1]+1));
                    }
                }
           }
           return a[n][m];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter first string: ");
        String x=sc.nextLine();
        System.out.println("enter second string: ");
        String y=sc.nextLine();
        sc.close();
        System.out.println("Minimum edit distance: "+minEditDistance(x,y));
    }
}
