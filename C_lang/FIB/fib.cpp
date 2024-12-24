#include <iostream>

const int MAX = 1000010;
int dp[MAX];
int Fib(int n)
{
    int count = 0;
    dp[1]=dp[2]=1;
    std::cout << dp[1] << " ";
    count++;
    std::cout << dp[2] << " ";
    count++;
    for (int i = 3; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
        std::cout << dp[i] << " ";
        count++;
        if (count % 10 == 0) {
            std::cout << std::endl;
        }
    }
    return dp[n];
}
int main() {
   
    int n;
    std::cin >> n;
    Fib(n);
    return 0;
}