package knapsack;

// 时间复杂度 O (n * c)，空间复杂度 O(c)

public class Knapsackdp1 {
    public static void knapsack(int[] v, int[] w, int c) {
        int n = v.length;  // 物品数量
        int[] dp = new int[c + 1];  // dp 数组，用于存储背包容量为 j 时的最大价值
        
        for (int i = 0; i < n; i++) {
            // 倒序更新，避免重复计算
            for (int j = c; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        System.out.println("最大总价值为：" + dp[c]);
    }

    public static void main(String[] args) {
        int[] v = {0, 60, 100, 120};  // 物品的价值
        int[] w = {0, 10, 20, 30};    // 物品的重量
        int c = 50;                   // 背包的容量
        knapsack(v, w, c);
    }
}
