#include <conio.h>
#include <stdio.h>

int main()
{
    int i, n, a[10], pos;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &n);
    printf("\nEnter the elements of the array: ");
    for(i=0;i<n;i++)
    {
        scanf("%d", &a[i]);
    }
    printf("\nEntered array is: ");
    for(i=0;i<n;i++)
    {
        printf(" %d ", a[i]);
    }

    printf("\nEnter the position to delete from array: ");
    scanf("%d", &pos);

    for(i=pos-1;i<n-1;i++)
    {
        a[i] = a[i+1];
    }

    printf("\nNew array is: ");
    for(i=0;i<n-1;i++)
    {
        printf(" %d ", a[i]);
    }
    getch();
    return 0;
}