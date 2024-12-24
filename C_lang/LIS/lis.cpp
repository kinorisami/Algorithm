#include <iostream>
#include <algorithm>

const int N = 1010;

int n;
int a[N],dp[N];

int main() {
    std::cin >> n;
    for(int i = 1; i <= n; i++)  std::cin >> a[i];

    for(int i = 1; i <= n; i++) 
    {
        dp[i] = 1;
        for(int j = 1; j < i; j++)
            if(a[j] < a[i])
            dp[i] = std::max(dp[i], dp[j] + 1);
    }
    int res =0;
    for (int i = 1; i <= n; i++) res = std::max(res, dp[i]);
    return 0;
}