#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

const int MAX = 50;
int dp[MAX][MAX];
std::string a, b;
std::vector<char> subs;

int Max(int a, int b) {
    return (a > b) ? a : b;
}

void LCSlength(const std::string& a, const std::string& b, int m, int n) {
    int i, j;
    for (i = 0; i <= m; i++)
        dp[i][0] = 0;
    for (j = 0; j <= n; j++)
        dp[0][j] = 0;
    for (i = 1; i <= m; i++)
        for (j = 1; j <= n; j++)
        {
            if (a[i-1] == b[j-1]){
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = Max(dp[i-1][j], dp[i][j-1]);
            } 
        }
}

void printLCS(const std::string& a, const std::string& b, int m, int n) {
    subs.clear();  
    int k = dp[m][n];
    int i = m;
    int j = n;
    while(k > 0) {
        if(dp[i][j] == dp[i-1][j]) {
            i--;
        } else if(dp[i][j] == dp[i][j-1]) {
            j--;
        } else {
            subs.push_back(a[i-1]);
            i--;
            j--;
            k--;
        }
    }
    std::reverse(subs.begin(), subs.end());
}

int main() {
    std::cout << "请输入第一个字符串: ";
    std::cin >> a;
    std::cout << "请输入第二个字符串: ";
    std::cin >> b;

    int m = a.length();
    int n = b.length();

    LCSlength(a, b, m, n);
    printLCS(a, b, m, n);

    std::cout << "最长公共子序列长度: " << dp[m][n] << std::endl;
    std::cout << "最长公共子序列: ";
    for (char c : subs) {
        std::cout << c;
    }
    std::cout << std::endl;

    return 0;
}
