#include <conio.h>
#include <stdio.h>

int main()
{
    int i, n, a[10], no, pos;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &n);
    printf("\nEnter array elements: ");
    for(i=0;i<n;i++)
    {
        scanf("%d", &a[i]);
    }

    printf("\nEntered array is: ");
    for(i=0;i<n;i++)
    {
        printf("%d\t", a[i]);
    }

    printf("\nEnter the number to insert in the array: ");
    scanf("%d", &no);
    printf("\nEnter the position to insert the number: ");
    scanf("%d", &pos);

    for(i=n;i>=pos;i--)
    {
        a[i] = a[i-1];
    }

    a[pos-1] = no;

    printf("\nNew array is: ");
    for(i=0;i<=n;i++)
    {
        printf(" %d ", a[i]);
    }
    getch();
    return 0;
   
}