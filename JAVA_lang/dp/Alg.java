package dp;

public class Alg {
    // 计算最大不相交子集的动态规划数组
    public static void mnset(int[] c, int[][] size) {
        int n = c.length - 1; // 数组c的长度减1，表示问题规模
        // 初始化第1根接线柱的值
        for (int j = 1; j < c[1]; j++) {
            size[1][j] = 0; // 当上接线柱的值小于c[1]时，无解
        }
        for (int j = c[1]; j <= n; j++) {
            size[1][j] = 1; // 当上接线柱的值大于等于c[1]时，解为1
        }
        // 动态规划填表
        for (int i = 2; i < n; i++) { // 遍历接线柱2到n-1
            for (int j = 1; j < c[i]; j++) {
                size[i][j] = size[i - 1][j]; // 如果当前值小于c[i]，则继承上一行的值
            }
            for (int j = c[i]; j <= n; j++) {
                size[i][j] = Math.max(size[i - 1][j], size[i - 1][c[i] - 1] + 1); // 取最大值
            }
        }
        // 处理第n根接线柱
        size[n][n] = Math.max(size[n - 1][n], size[n - 1][c[n] - 1] + 1);
    }

    // 回溯构造最优解
    public static int traceback(int[] c, int[][] size, int[] net) {
        // 数组net[0:m-1]存储最大不相交子集的元素
        int n = c.length - 1;
        int j = n;
        int m = 0;
        for (int i = n; i > 1; i--) { // 从最后一根接线柱往前遍历
            if (size[i][j] != size[i - 1][j]) { // 如果当前值不等于上一行的值
                net[m++] = i; // 将当前接线柱加入解集
                j = c[i] - 1; // 更新列索引
            }
        }
        if (j >= c[1]) net[m++] = 1; // 如果剩余列满足条件，将第1根接线柱加入解集
        return m;
    }

    public static void main(String[] arguments) {
        int c[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // c[0]未使用
        int[][] size = new int[20][20]; // 动态规划表
        int[] net = new int[20]; // 存储解集
        
        mnset(c, size); // 计算动态规划表
        int x = traceback(c, size, net); // 构造最优解
        
        System.out.println("最大不相交子集的元素个数为：" + x);
        System.out.println("最大不相交子集的各个元素为：");
        for (int i = 1; i <= x; i++) {
            System.out.print("(" + i + "," + net[x - i] + ") ");
        }
        System.out.println(" ");
    }
}