package trackback;

public class MaxClique {
    static int[] x; // 当前解
    static int n; // 图G的顶点数
    static int cn; // 当前顶点数
    static int bestn; // 当前最大顶点数
    static int[] bestx; // 当前最优解
    static boolean[][] matrix; // 图G的邻接矩阵

    // 计算最大团的大小
    public static int maxClique(boolean[][] m, int[] v) {
        matrix = m;
        n = matrix.length;
        x = new int[n];
        cn = 0;
        bestn = 0;
        bestx = v;
        backtrack(0);
        return bestn;
    }

    // 回溯法主过程
    private static void backtrack(int i) {
        if (i == n) { // 到达叶结点
            System.out.println("当前最优解如下: ");
            for (int j = 0; j < n; j++) {
                bestx[j] = x[j];
                System.out.println("v[" + (j + 1) + "]=" + bestx[j]);
            }
            bestn = cn;
            System.out.println("当前最大顶点数: " + bestn);
            return;
        }

        // 检查顶点 i 与当前团的连接性
        boolean connected = true;
        for (int j = 0; j < i; j++) {
            if (x[j] == 1 && !matrix[i][j]) { // i 和 j 不相连
                connected = false;
                break;
            }
        }

        if (connected) { // 尝试将 i 加入团
            x[i] = 1;
            cn++;
            backtrack(i + 1);
            cn--;
        }

        // 剪枝：仅在可能超越当前最大顶点数时进入右子树
        if (cn + n - i > bestn) {
            x[i] = 0;
            backtrack(i + 1);
        }
    }

    // 测试方法
    private static void test() {
        boolean[][] matrix = {
            { false, true, false, true, true },
            { true, false, true, false, true },
            { false, true, false, false, true },
            { true, false, false, false, true },
            { true, true, true, true, false }
        };
        int[] v = new int[matrix.length];
        int bestn = maxClique(matrix, v);
        System.out.println("最大团的大小: " + bestn); // 打印最佳团的大小
    }

    public static void main(String[] args) {
        test();
    }
}
