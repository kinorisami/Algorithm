package greedy;

public class Dijkstra {

    // Dijkstra 算法实现
    public static void dijkstra(int startVertex, float[][] graph, float[] dist, int[] prev) {
        int n = dist.length - 1;
        if (startVertex < 1 || startVertex > n) return;

        boolean[] s = new boolean[n + 1]; // 记录顶点是否已加入集合 S

        // 初始化
        for (int i = 1; i <= n; i++) {
            dist[i] = graph[startVertex][i];
            s[i] = false;
            if (dist[i] == Float.MAX_VALUE) {
                prev[i] = 0;
            } else {
                prev[i] = startVertex;
            }
        }
        dist[startVertex] = 0;
        s[startVertex] = true; // 起始顶点加入集合 S

        // 主循环
        for (int i = 1; i < n; i++) {
            float temp = Float.MAX_VALUE;
            int u = startVertex; // 初始化 u

            // 找出距离起点最近且未加入集合 S 的顶点
            for (int j = 1; j <= n; j++) {
                if (!s[j] && dist[j] < temp) {
                    u = j;
                    temp = dist[j];
                }
            }

            s[u] = true; // 将顶点 u 加入集合 S

            // 更新 dist 和 prev 数组
            for (int j = 1; j <= n; j++) {
                if (!s[j] && graph[u][j] < Float.MAX_VALUE) {
                    float newDist = dist[u] + graph[u][j];
                    if (newDist < dist[j]) { // 如果更新后的距离更短
                        dist[j] = newDist;
                        prev[j] = u;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int m = 5; // 顶点个数
        float MAX = Float.MAX_VALUE;
        float[][] graph = new float[m + 1][m + 1];

        // 初始化图，设置为无穷大
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                graph[i][j] = MAX;
            }
        }

        // 设置图的边权
        graph[1][2] = 10;
        graph[1][4] = 30;
        graph[1][5] = 100;
        graph[2][3] = 50;
        graph[3][5] = 10;
        graph[4][3] = 20;
        graph[4][5] = 60;

        float[] dist = new float[m + 1];
        int[] prev = new int[m + 1];

        // 调用 Dijkstra 算法
        dijkstra(1, graph, dist, prev);

        // 输出从顶点 1 到其他顶点的最短路径的前驱顶点
        System.out.println("从顶点 1 到其他顶点的前一顶点关系为：");
        for (int i = 1; i <= m; i++) {
            System.out.println("prev[" + i + "] = " + prev[i]);
        }
    }
}
