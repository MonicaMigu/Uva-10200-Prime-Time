#include <stdio.h>
#include <string.h>

int main()
{
    int primeNumList[10010];
    int a, b;
    memset(primeNumList, 0, sizeof(primeNumList)); // 初始化質數表所需記憶體
    for (int i = 0; i <= 10005; i++) primeNumList[i] = prime(i * i + i + 41); // 建立質數表
    while (scanf("%d%d", &a, &b) != -1) // 重複讀入直到 EOF
    {
        int sum = 0;
        for (int i = a; i <= b; i++) sum += primeNumList[i]; // 加全範圍內質數數量
        printf("%.2f\n", sum * 1.0 / (b - a + 1) * 100 + 1e-8); // 帶入通式求機率
    }
    return 0;
}
// 質數表產生器
int prime(int n)
{
    for (int i = 2; i * i <= n; i++) if ((n % i) == 0) return 0;
    return 1;
}