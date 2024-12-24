def inversion_pair( l , r):
    global num

    if l >= r:
        return 0 
    mid = (l + r) //2
    num_left = inversion_pair(l, mid)
    num_right = inversion_pair(mid + 1, r)
    num = num_left + num_right  
    tmp = []
    i = l
    j = mid + 1

    while(i<=mid) and (j <= r):
        if data[i]<=data[j]:
            tmp.append(data[i])
            i+= 1
        else:
            tmp.append(data[j])
            j += 1
            num += mid - i + 1 
    tmp.extend(data[i:mid + 1])
    tmp.extend(data[j:r+1])
    data[l:r+1] = tmp
    return num
    
n = int(input())
data = [int(x) for x in input().split()]
num = 0 


print( inversion_pair(0, n-1))
