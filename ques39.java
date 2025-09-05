//Matrix multiplication of 2D arrays.


import java.util.Scanner;

public class ques39 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the dimensions of matrix A
        System.out.print("Enter the number of rows in matrix A: ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of columns in matrix A: ");
        int n = scanner.nextInt();

        // Input the dimensions of matrix B
        System.out.print("Enter the number of rows in matrix B: ");
        int n2 = scanner.nextInt();  // should be same as n
        System.out.print("Enter the number of columns in matrix B: ");
        int p = scanner.nextInt();

        // Check if multiplication is possible
        if (n != n2) {
            System.out.println("Matrix multiplication is not possible. Number of columns in A must equal number of rows in B.");
            return;
        }

        // Input matrix A
        int[][] matrixA = new int[m][n];
        System.out.println("Enter elements of matrix A:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // Input matrix B
        int[][] matrixB = new int[n][p];
        System.out.println("Enter elements of matrix B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Perform matrix multiplication
        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB, m, n, p);

        // Print the result matrix
        System.out.println("Resultant matrix C (A * B):");
        printMatrix(resultMatrix);

        scanner.close();
    }
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB, int m, int n, int p) {
        int[][] resultMatrix=new int[m][p];
        for(int i=0;i<m;i++){
            for(int j=0;j<p;j++){
                resultMatrix[i][j]=0;
                for(int k=0;k<n;k++){
                    resultMatrix[i][j]+=matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return resultMatrix;
    }

    // Utility function to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
