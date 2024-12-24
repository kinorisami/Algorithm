package knapsack;

// 时间复杂度 O(2^n)

public class KnapsackBacktracking {
    private static int maxValue = 0; // 保存最大总价值

    public static void knapsack(int[] v, int[] w, int c) {
        maxValue = 0; // 初始化最大价值
        backtrack(v, w, c, 0, 0, 0);
        System.out.println("背包的最大总价值为：" + maxValue);
    }

    /**
     * 回溯函数

     * @param v 价值数组
     * @param w 重量数组
     * @param c 背包容量
     * @param i 当前物品索引
     * @param currentWeight 当前背包重量
     * @param currentValue 当前总价值
     */
    private static void backtrack(int[] v, int[] w, int c, int i, int currentWeight, int currentValue) {
        // 超过背包容量或遍历完所有物品时返回
        if (currentWeight > c || i == v.length) {
            // 更新最大价值
            if (currentValue > maxValue) {
                maxValue = currentValue;
            }
            return;
        }

        // 不选当前物品
        backtrack(v, w, c, i + 1, currentWeight, currentValue);

        // 选当前物品（需要确保容量不会超出）
        if (currentWeight + w[i] <= c) {
            backtrack(v, w, c, i + 1, currentWeight + w[i], currentValue + v[i]);
        }
    }

    public static void main(String[] args) {
        int[] v = {60, 100, 120};  // 物品的价值
        int[] w = {10, 20, 30};    // 物品的重量
        int c = 50;                // 背包容量

        knapsack(v, w, c);
    }
}
