#include <stdio.h>
int main()
{   
    int i, n;
    void compute(int b[], int);
    printf("Enter the length of the array: ");
    scanf("%d", &n);
    int a[n];
    for(i=0;i<n;i++)
    {
        printf("Enter a value: ");
        scanf("%d", &a[i]);
    }
    compute(a, n); return 0;
}
void compute( int b[], int n)
{
    int i, min=b[0], max=b[0];
    for(i=0;i<n;i++)
    {   
        if((b[i])>max)
        max = b[i];
        else if((b[i]<min))
        min = b[i];
    }
    printf("The maximum value is %d and the minimum value is %d", max, min);
}