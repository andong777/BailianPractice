#include <algorithm>
#include <iostream>
#include <string>
#include <queue>
#include <cstring>
#include <cstdlib>
#include <cstdio>
#include <cmath>

#define N 500010

using namespace std;

int cow[N], minc[N][20], maxc[N][20];
int n, q;

void RMQinit()
{
    int i, j, m;
    for(i=1; i<=n; ++i)
        minc[i][0] = maxc[i][0] = cow[i];
    m = int(log(n*1.0)/log(2.0));
    for(i=1; i<=m; ++i)
        for(j=n; j>=1; --j)
        {
            maxc[j][i] = maxc[j][i-1];
            if(j+(1<<(i-1)) <= n)
                maxc[j][i] = max(maxc[j][i], maxc[j+(1<<(i-1))][i-1]);

            minc[j][i] = minc[j][i-1];
            if(j+(1<<(i-1) <= n))
                minc[j][i] = min(minc[j][i], minc[j+(1<<(i-1))][i-1]);
        }
}

int RQMmin(int l, int r)
{
    int m = int(log(r-l+1.0)/log(2.0));
    return min(minc[l][m], minc[r-(1<<m)+1][m]);
}

int RQMmax(int l, int r)
{
    int m = int(log(r-l+1.0)/log(2.0));
    return max(maxc[l][m], maxc[r-(1<<m)+1][m]);
}

int main()
{
    int a, b;
    int i;
    scanf("%d %d", &n, &q);
    for(i=1; i<=n; ++i)
        scanf("%d", &cow[i]);
    RMQinit();
    while(q--)
    {
        scanf("%d %d", &a, &b);
        printf("%d\n", RQMmax(a, b)-RQMmin(a, b));
    }
    return 0;
}