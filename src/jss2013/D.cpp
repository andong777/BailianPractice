#include <iostream>

const int maxn = 1000010;
int q[maxn][2],rear,front,i,n,m,j,a[maxn];

void push(int i,bool flag)
{
	if(flag)	while(rear>front&&q[rear-1][0]<a[i+m])	rear--;
	else		while(rear>front&&q[rear-1][0]>a[i+m])	rear--;
	q[rear][0] = a[i+m];
	q[rear][1] = i+m ;
	rear++;
}

int main()
{
	scanf("%d%d",&n,&m);
	for( i = 1 ; i <= n ; i++)
		scanf("%d",&a[i]);
	for( j = 0 ; j < 2 ; j++)
	{
		front = rear = 1 ;
		q[front][1] = 0 ;
		for( i = 1-m ; i <= n-m ; i++)
		{
			if(i>0)	printf("%d ",q[front][0]);
			while(front<rear&&q[front][1]<=i)	front++;
			push(i,j);
		}
		printf("%d\n",q[front][0]);
	}
	return 0;
}