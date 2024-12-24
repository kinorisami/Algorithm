def merge_sort(data, l, r):
    if l >= r:
        return
    mid = (l + r) // 2
    merge_sort(data, l, mid)
    merge_sort(data, mid + 1, r)
    tmp = []
    i = l
    j = mid + 1
    while (i <= mid) and (j <= r):
        if data[i] <= data[j]:
            tmp.append(data[i])
            i += 1
        else:
            tmp.append(data[j])
            j += 1

    tmp += data[i:mid + 1]
    tmp += data[j:r + 1]
    data[l:r + 1] = tmp



n = int(input())
data = [int(x) for x in input().split()]
l = 0
r = n - 1
merge_sort(data, l, r)
print(' '.join(map(str, data)))


