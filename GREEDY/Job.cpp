#include<iostream>
#include<algorithm>
using namespace std;

struct Job{
    char id;
    int deadline;
    int profit;
};

bool comparison(Job a, Job b)
{
    return (a.profit > b.profit);
}

void printJobScheduling(Job arr[], int n)
{
    sort(arr, arr + n, comparison);
    int result[n];
    bool slot[n];
    for(int i=0;i<n;i++)
    {
        slot[i] = false;
    }
    for(int i=0;i<n;i++)
    {
        for(int j=min(n,arr[i].deadline)-1;j>=0;j--)
        {
            if(slot[j] == false)
            {
                result[j] = i;
                slot[j] = true;
                break;
            }
        }
    }
    for(int i=0;i<n;i++)
    {
        if(slot[i])
        {
            cout<<arr[result[i]].id<<" ";
        }
    }
}

int main()
{
    int n;
    cout<<"Enter n:"<<endl;
    cin>>n;
    Job arr[n];
    Job j;
    for(int i=0;i<n;i++)
    {
        char id1;
        int deadline1, profit1;
        cout<<"Enter id, deadline, profit: "<<endl;
        cin>>id1>>deadline1>>profit1;
        
        j.id = id1;
        j.deadline = deadline1;
        j.profit = profit1;
        arr[i] = j;
    }

    cout<<"Following is maximum profit sequence of jobs \n";
    printJobScheduling(arr, n);
    return 0;
}