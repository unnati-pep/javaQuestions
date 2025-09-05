import java.util.Scanner;
public class assQ3{
    void prods(char[][] table1, int[][] table2,int k){
        for(int i=0;i<table1.length;i++){
            for(int j=0;j<table1[i].length;j++){
                if(table2[i][j]>=k){
                    System.out.println(table1[i][j]);
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter rows: ");
        int rows=sc.nextInt();
        System.out.println("Enter columns: ");
        int cols=sc.nextInt();
        char[][] table1=new char[rows][cols];
        System.out.println("Enter table1(characters): ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                table1[i][j]=sc.next().charAt(0);
            }
        }
        int[][] table2=new int[rows][cols];
        System.out.println("Enter table2(values): ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                table2[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter k: ");
        int k=sc.nextInt();
        assQ3 p=new assQ3();
        p.prods(table1,table2,k);
    }
}