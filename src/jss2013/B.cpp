# include <iostream>  
# include <cstdio>  
# include <map>  
# include <cmath>  
  
using namespace std;  
  
map<int,int> member;  
  
void match(int p)  
{  
    int lower = 0;  
    int upper = 0;  
    map<int,int>::iterator i;  
    map<int,int>::iterator j;  
    map<int,int>::iterator k;  
    i = member.find(p);  
    if ( i != member.end() )  
    {  
        if ( i == member.begin() )  
        {  
            j = i;  
            j++;  
            printf("%d %d\n",i->second,j->second);  
        }  
        else  
        {  
            j = i;  
            j++;  
            upper = j->first - i->first;  
            k = i;  
            k--;  
            lower = i->first - k->first;  
            if ( lower <= upper )  
            {  
                printf("%d %d\n",i->second,k->second);  
            }  
            else   
            {  
                printf("%d %d\n",i->second,j->second);  
            }  
        }  
    }  
    else return;  
}  
  
          
  
  
  
  
int main()  
{  
    int n = 0;  
    int id = 0;  
    int power = 0;  
    cin >> n;  
    member.insert(make_pair(1000000000,1));  
    for ( int i = 0; i < n; i++ )  
    {  
        scanf("%d%d",&id,&power);  
        member.insert(make_pair(power,id));  
        match(power);  
    }  
    return 0;  
}  