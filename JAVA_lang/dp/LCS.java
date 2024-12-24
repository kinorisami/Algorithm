package dp;

import java.util.Scanner;

public class LCS {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 读取字符串长度
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine(); // 清除换行符

            // 读取两个字符串
            String a = scanner.nextLine();
            String b = scanner.nextLine();

            // 转换为字符数组，便于索引从1开始
            char[] aChars = (" " + a).toCharArray();
            char[] bChars = (" " + b).toCharArray();

            // 创建动态规划数组
            int[][] f = new int[n + 1][m + 1];

            // 动态规划求解
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    // 状态转移：取最大值
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    if (aChars[i] == bChars[j]) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                    }
                }
            }

            // 输出结果
            System.out.println(f[n][m]);
        }
    }
}
