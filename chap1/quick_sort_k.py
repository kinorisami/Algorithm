import random

# 输入需要排序的数的个数和需要显示的排序后的第k个数
n, k = map(int, input().split())

q = list(map(int, input().split()))


def quick_sort(q, l, r):
    if l >= r:
        return

    i = l - 1
    j = r + 1
    y = random.randint(l, r)
    x = q[y]

    while i < j:
        i += 1
        while q[i] < x:
            i += 1

        j -= 1
        while q[j] > x:
            j -= 1

        if i < j:
            q[i], q[j] = q[j], q[i]

    quick_sort(q, l, j)
    quick_sort(q, j + 1, r)


quick_sort(q, 0, n - 1)
print(q[k - 1])

