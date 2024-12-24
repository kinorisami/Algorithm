package trackback;

public class NQueen1 {
    static int n; // 皇后个数
    static int[] x; // 当前解
    static long sum; // 当前已找到的可行方案数

    public static long nQueen(int nn) {
        n = nn;
        sum = 0;
        x = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            x[i] = 0;
        }
        backtrack(1);
        return sum;
    }

    private static boolean place(int k) {
        // 检查第 k 行第 x[k] 位置与已经放置的 k-1 个皇后的位置关系
        for (int j = 1; j < k; j++) {
            if ((Math.abs(k - j) == Math.abs(x[k] - x[j])) || (x[k] == x[j])) {
                return false;
            }
        }
        return true;
    }

    private static void backtrack(int t) {
        if (t > n) {
            sum++; // 到达叶结点
            System.out.println(n + " 后问题的摆放位置为：");
            for (int i = 1; i <= n; i++) {
                System.out.println("第 " + i + " 行 第 " + x[i] + " 列");
            }
        } else {
            // 未到达叶结点
            for (int i = 1; i <= n; i++) {
                x[t] = i;
                // 不满足可行性约束条件－剪去子树
                if (place(t)) {
                    backtrack(t + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int nn = 4;
        long sum1 = nQueen(nn);
        System.out.println(nn + " 后问题的解个数为：" + sum1);
    }
}
