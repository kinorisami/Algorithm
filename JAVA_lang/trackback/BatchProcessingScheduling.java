package trackback;

import java.util.*;

public class BatchProcessingScheduling {

    // 定义任务类
    static class Task {
        int id; // 任务的编号
        int duration; // 任务的处理时间

        public Task(int id, int duration) {
            this.id = id;
            this.duration = duration;
        }
    }

    // 存储任务的完成时间
    private static int minCompletionTime = Integer.MAX_VALUE;
    private static List<Task> bestSchedule = new ArrayList<>();

    // 回溯法进行任务调度
    public static void backtrack(List<Task> tasks, List<Task> currentSchedule, int currentTime, int taskIndex) {
        // 如果所有任务都已处理完，计算当前调度的完成时间
        if (taskIndex == tasks.size()) {
            int completionTime = currentTime;
            for (Task task : currentSchedule) {
                completionTime += task.duration; // 计算当前完成时间
            }
            // 更新最优结果
            if (completionTime < minCompletionTime) {
                minCompletionTime = completionTime;
                bestSchedule = new ArrayList<>(currentSchedule); // 存储当前的最优调度
            }
            return;
        }

        // 遍历所有未处理的任务，进行调度
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (!currentSchedule.contains(task)) {
                // 将当前任务添加到调度中，并继续回溯
                currentSchedule.add(task);
                backtrack(tasks, currentSchedule, currentTime + task.duration, taskIndex + 1);
                // 回溯：移除任务，尝试其他任务调度顺序
                currentSchedule.remove(currentSchedule.size() - 1);
            }
        }
    }

    // 输出调度的任务顺序和最优完成时间
    public static void printSchedule() {
        System.out.println("最优调度方案：");
        for (Task task : bestSchedule) {
            System.out.println("任务 " + task.id + "，处理时间：" + task.duration);
        }
        System.out.println("最优完成时间：" + minCompletionTime);
    }

    public static void main(String[] args) {
        // 定义任务列表，任务的处理时间
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, 3)); // 任务1，处理时间3
        tasks.add(new Task(2, 2)); // 任务2，处理时间2
        tasks.add(new Task(3, 1)); // 任务3，处理时间1

        // 调用回溯算法求解最优调度
        backtrack(tasks, new ArrayList<>(), 0, 0);
        printSchedule(); // 输出最优调度方案
    }
}
