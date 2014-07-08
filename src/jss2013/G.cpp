#include <iostream>
#include <algorithm>
using namespace std;

#define INFINITE 100000
int leftmintime[1001];
int rightmintime[1001];
int N,X,Y,MAX;
struct Board
{
    int lx;
    int rx;
    int high;
}board[1001];

bool cmp(Board a,Board b)
{
    if(a.high > b.high) return true;
    else return false;
}
int mintime(int index,bool left)
{
    int i,x;
    int y = board[index].high;
    if(left)
        x = board[index].lx;
    else
        x = board[index].rx;
    for(i = index + 1;i <= N;i++)
        if(board[i].lx <= x && board[i].rx >= x)
            break;
    
    if(i <= N){ // 板index的下方有板
        if(y - board[i].high > MAX)
            return INFINITE;
    }
    else{
        if(y > MAX)
            return INFINITE;
        else
            return y;
    }
    int lefttime = y - board[i].high + x - board[i].lx;
    int righttime = y - board[i].high + board[i].rx - x;
    if(leftmintime[i] == -1)
        leftmintime[i] = mintime(i,true);
    if(rightmintime[i] == -1)
        rightmintime[i] = mintime(i,false);
    lefttime+=leftmintime[i];
    righttime+=rightmintime[i];
    if(lefttime < righttime)
        return lefttime;
    else
        return righttime;
}

int main()
{
    int t;
    
    cin >> t;
    while(t--){ 
        int i;
        memset(leftmintime,-1,sizeof(leftmintime));
        memset(rightmintime,-1,sizeof(rightmintime));
        cin >> N >> X >> Y >> MAX;
        for(i = 1;i <= N;i++){
            cin >> board[i].lx >> board[i].rx >> board[i].high;
        }
        sort(board,board+N,cmp);  //对板从上到下一次排序编号

        board[0].lx = X;
        board[0].rx = X;
        board[0].high = Y;
        cout << mintime(0,true);
    }
    return 0;
}