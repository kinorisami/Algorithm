package greedy;

public class Loading extends MergeSort {

    // 定义物品类
    public static class Item {
        float weight; // 物品重量
        int index; // 物品的序号

        public Item(float weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }

    // 贪心算法实现最大装载问题
    public static float loading(float capacity, float[] weights, int[] solution) {
        int n = weights.length;
        Item[] items = new Item[n];
        float[] sortedWeights = new float[n];

        // 初始化物品数组
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], i);
            sortedWeights[i] = items[i].weight;
        }

        // 使用 MergeSort 对重量数组进行排序
        mergeSort(sortedWeights);

        // 更新物品数组，按排序后的重量更新
        for (int i = 0; i < n; i++) {
            items[i].weight = sortedWeights[i];
        }

        float totalWeight = 0; // 当前总重量
        int remainingCapacity = (int) capacity; // 剩余容量
        for (int i = 0; i < n; i++) {
            solution[i] = 0; // 初始化状态变量为 0
        }

        // 贪心选择物品
        for (int i = 0; i < n && items[i].weight <= remainingCapacity; i++) {
            solution[items[i].index] = 1; // 选择当前物品
            totalWeight += items[i].weight; // 更新总重量
            remainingCapacity -= items[i].weight; // 更新剩余容量
        }

        return totalWeight; // 返回最大装载重量
    }

    public static void main(String[] args) {
        float capacity = 150; // 背包容量
        float[] weights = {30, 10, 60, 40, 50, 20}; // 物品重量数组
        int[] solution = new int[weights.length]; // 用于存储选择方案

        // 调用贪心算法
        float maxWeight = loading(capacity, weights, solution);

        // 输出结果
        System.out.println("最大装载重量为：" + maxWeight);
        System.out.print("选择的物品为：");
        for (int i = 0; i < weights.length; i++) {
            System.out.print(solution[i]);
        }
        System.out.println();
    }
}
