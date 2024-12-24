package greedy;

// 先将配个区间按照右端点从小到大排序
// 从前往后以此枚举每个区间
//      第i个区间的左端点大于第i-1的右端点
//      将该区间加入集合

public class GreedySelector {

    // 使用贪心算法选择最大数量的相容活动
    public static int greedySelector(int[] s, int[] f, boolean[] a) {
        // 假定 f 已经是按非减顺序排列
        int n = s.length - 1; // 活动数量
        a[1] = true; // 第一个活动默认选中
        int j = 1; // 上次选中的活动索引
        int count = 1; // 计数已选活动数量

        for (int i = 2; i <= n; i++) {
            if (s[i] >= f[j]) { // 如果活动 i 的开始时间大于等于活动 j 的结束时间
                a[i] = true; // 选择活动 i
                j = i; // 更新最近选中的活动
                count++; // 活动计数加一
            } else {
                a[i] = false; // 不选择活动 i
            }
        }
        return count; // 返回最大相容活动的数量
    }

    public static void main(String[] args) {
        int[] s = {0, 1, 3, 0, 5, 3, 6, 5, 8, 8, 2, 12}; // 活动开始时间，s[0]未使用
        int[] f = {0, 4, 5, 6, 7, 8, 10, 9, 11, 12, 13, 14}; // 活动结束时间，未排序
        boolean[] a = new boolean[s.length]; // 用于记录活动选择情况

        // 调用贪心选择算法
        int maxCompatibleActivities = greedySelector(s, f, a);

        // 输出结果
        System.out.println("最大相容活动的个数为：" + maxCompatibleActivities);
        System.out.print("最大相容活动的子集为：");
        for (int i = 1; i < s.length; i++) {
            if (a[i]) {
                System.out.print("[" + s[i] + "," + f[i] + "), ");
            }
        }
        System.out.println();
    }
}
