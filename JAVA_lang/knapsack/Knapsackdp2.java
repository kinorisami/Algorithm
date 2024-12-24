package knapsack;

// 时间复杂度 O(n*c)

public class Knapsackdp2 {
    public static void knapsack(int[] v, int[] w, int c, int[][] m) {
        int n = v.length - 1;  // 物品数量，v.length 包括了索引为 0 的额外元素
        // 初始化 m 数组
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                m[i][j] = 0;  // 初始化所有值为 0
            }
        }

        // 动态规划过程
        for (int i = 1; i <= n; i++) {  // 遍历所有物品
            for (int j = 0; j <= c; j++) {  // 遍历所有背包容量
                if (j < w[i]) {
                    m[i][j] = m[i - 1][j];  // 物品i不能装入背包
                } else {
                    // 物品i可以装入背包，选择最大价值
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        // 输出最大总价值
        System.out.println("最大总价值为：" + m[n][c]);
    }

    public static void main(String[] args) {
        int[] v = {0, 60, 100, 120};  // 物品的价值
        int[] w = {0, 10, 20, 30};    // 物品的重量
        int c = 50;                   // 背包的容量
        int[][] m = new int[v.length][c + 1];  // 动态规划表
        knapsack(v, w, c, m);
    }
}
