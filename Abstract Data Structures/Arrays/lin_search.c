#include<stdio.h>
int main()
{
    int i, n, found=0, num, t;
    printf("Enter the length of array:\n");
    scanf("%d", &n);
    int a[n];
    printf("Enter the elements of array: ");
    for(i=0;i<n;i++)
    {
        scanf("%d", &a[i]);
    }

    printf("Enter the element to be deleted:\n");
    scanf("%d", &num);
    
    for(i=0;i<n && found==0;i++)
    {
        if(a[i]==num)
        {
            found=1;
            t=i;
            break;
        }
    }   

    if(found==1)
    {   
        printf("The element was found and deleted\n");
        for(i=t;i<n;i++)
        {
            a[i]=a[i+1];
        }

        printf("The new array is: \n");

        for(i=0;i<(n-1);i++)
        {
            printf("%d ", a[i]);
        }
    }
    else
    printf("The element was not found\n");
}