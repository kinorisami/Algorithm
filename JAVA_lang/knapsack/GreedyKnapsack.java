package knapsack;

import java.util.Arrays;
import java.util.Comparator;

// 时间复杂度 O(n log n)
public class GreedyKnapsack {
    static class Item {
        int value, weight;
        double ratio; // 单位重量价值比

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    public static int greedyKnapsack(int[] v, int[] w, int c) {
        int n = v.length;

        // 创建物品列表
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(v[i], w[i]);
        }

        // 按单位重量价值比排序（降序）
        Arrays.sort(items, Comparator.comparingDouble((Item i) -> -i.ratio));

        int totalValue = 0, remainingCapacity = c;

        // 贪心选择物品
        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                // 如果能装下整个物品
                totalValue += item.value;
                remainingCapacity -= item.weight;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] v = {60, 100, 120};  // 物品的价值
        int[] w = {10, 20, 30};    // 物品的重量
        int c = 50;                // 背包容量

        int result = greedyKnapsack(v, w, c);
        System.out.println("使用贪心算法的总价值：" + result);
    }
}
