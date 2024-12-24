package trackback;
import java.util.*;

public class FlowShop {
    static int n; // 作业数
    static int f1; // 机器1完成处理时间
    static int f; // 完成时间和
    static int bestf; // 当前最优值
    static int[][] m; // 各作业所需要的处理时间
    static int[] x; // 当前作业调度
    static int[] bestx; // 当前最优作业调度
    static int[] f2; // 机器2完成处理时间

    public static void trackback(int i) {
        if (i == n) { // 到达排列树的叶结点（i=n：表示第n层）
            // 存储最优解
            for (int j = 0; j < n; j++) {
                bestx[j] = x[j];
            }
            bestf = f; // 更新最优解
        } else {
            for (int j = i; j < n; j++) { // 未到达叶结点，继续排列
                // 交换作业顺序
                swap(x, i, j);

                f1 += m[x[i]][0]; // 作业在机器1的处理时间
                if (i > 0) {
                    // 机器2的时间取决于机器1和前一作业
                    f2[i] = Math.max(f2[i - 1], f1) + m[x[i]][1];
                } else {
                    f2[i] = f1 + m[x[i]][1]; // 第1层作业的处理时间
                }

                f += f2[i]; // 更新总完成时间

                // 剪枝：如果当前总时间小于最优时间，则继续递归
                if (f < bestf) {
                    trackback(i + 1); // 递归到下一层
                }

                // 回溯，恢复状态
                f -= f2[i];
                f1 -= m[x[i]][0]; // 恢复机器1的时间
                swap(x, i, j); // 恢复作业顺序
            }
        }
    }

    // 交换作业顺序
    private static void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    // 测试用例
    private static void test() {
        int[][] testm = {{2, 1}, {3, 1}, {2, 3}};
        m = testm;
        n = m.length;

        // 作业顺序初始化
        int[] testx = {0, 1, 2};
        x = testx;
        bestx = new int[n];
        f2 = new int[n];
        f1 = 0;
        f = 0;
        bestf = Integer.MAX_VALUE;

        trackback(0); // 开始回溯

        System.out.println("最优作业调度为：");
        System.out.println(Arrays.toString(bestx));
        System.out.println("最优值（最小完成时间和）为：");
        System.out.println(bestf);
    }

    public static void main(String[] args) {
        test();
    }
}
