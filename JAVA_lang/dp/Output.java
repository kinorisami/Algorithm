package dp;

public class Output {
    // 输出 m[i][j] 矩阵
    public static void Output1(int i, int j, int[][] m) {
        for (int row = 1; row <= i; row++) {
            for (int col = 1; col <= j; col++) {
                System.out.print(m[row][col] + " ");
            }
            System.out.println();
        }
    }

    // 输出 s[i][j] 矩阵
    public static void Output2(int i, int j, int[][] s) {
        for (int row = 1; row <= i; row++) {
            for (int col = 1; col <= j; col++) {
                System.out.print(s[row][col] + " ");
            }
            System.out.println();
        }
    }
}
