#include <stdio.h>
int main()
{
    int i, n;
    void compute(int b[], int);
    printf("Enter the length of the array: ");
    scanf("%d", &n);
    int a[n];
    for (i=0;i<n;i++)
    {
        printf("Enter a value: ");
        scanf("%d", &a[i]);
    }
    compute(a, n); return 0;
}
void compute(int b[], int n)
{
    int i, t=0;
    for (i=0;i<n;i++)
    {
        t = b[i];
        b[i] = b[i-1];
        b[i-1] = t;
    }
        printf("The reversed array is:\n");
        for (i=0;i<n;i++)
    {
        printf("%d", b[i]);
    }
}