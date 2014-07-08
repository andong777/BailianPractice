#include<cstdio>
#include<cstring>
using namespace std;
const int MAXN=105;
bool map[MAXN][MAXN];
int dx[10]={0,0,1,-1,-1,-1,1,1};
int dy[10]={1,-1,0,0,-1,1,-1,1};
int n, m;
void dfs(int x,int y)
{
    int i, nx, ny;
    map[x][y]=false;
    for(i=0;i<8;i++)
    {
        nx=x+dx[i], ny=y+dy[i];
        if(nx<1||ny<1||nx>n||ny>m) continue;
        if(map[nx][ny]) dfs(nx,ny);
    }
}
int main()
{
    int i, j, num;
    char a;
    while(scanf("%d%d",&n,&m)&&(n||m))
    {
        num=0;
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=m;j++)
            {
                scanf(" %c",&a);
                if(a=='@')
                {
                    map[i][j]=true;
                }
                else
                {
                    map[i][j]=false;
                }
            }
        }
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=m;j++)
            {
                if(map[i][j])
                {
                    dfs(i,j);
                    num++;
                }
            }
        }
        printf("%d\n",num);
    }
    return 0;
}