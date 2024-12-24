package dp;

public class Alg1 extends Output {
    public static void matrixChain(int[] p, int[][] m, int[][] s) {
        int n = p.length - 1;
        for (int i = 1; i <= n; i++) m[i][i] = 0; // 单一矩阵
        for (int r = 2; r <= n; r++) // 矩阵链长
            for (int i = 1; i <= n - r + 1; i++) { // 断开位置数
                int j = i + r - 1; // 根据链长 r 构造 A[i:j]
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j]; // 基于子问题初始化
                s[i][j] = i; // 最优断开位置初始化
                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
    }

    public static void traceback(int[][] s, int i, int j) {
        if (i == j || j - i == 1) return; // 分段长为 1 或 2 为止
        System.out.println("矩阵A" + s[i][j] + " 和矩阵A" + (s[i][j] + 1) + " 之间分段。");
        traceback(s, i, s[i][j]);
        traceback(s, s[i][j] + 1, j);
    }

    public static void main(String[] arguments) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[][] s = new int[8][8];
        int[][] m = new int[8][8];
        matrixChain(p, m, s);
        System.out.println("m[i][j] 构成的矩阵为：");
        Output.Output1(p.length - 1, p.length - 1, m);
        System.out.println("s[i][j] 构成的矩阵为：");
        Output.Output2(p.length - 1, p.length - 1, s);
        System.out.println("此矩阵连乘积的最优解为：");
        traceback(s, 1, p.length - 1);
    }
}
