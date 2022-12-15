//Insertion and Deletion is preferred to do from the head as Time Complexity will be O(1).
// In Stack we will call the head as top.

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>


struct node
{
    int data;
    struct node *link;
};

struct node *top = 0;

void push(int n)
{
    struct node * newnode;
    newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = n;
    newnode->link = top;
    top = newnode;
}


void pop()
{   
    struct node * temp;
    temp = top;
    if(top == 0)
    {
        printf("Stack is empty");
    }
    else
    {
        printf("The Top element is: %d", top->data);
        top = top->link;
        free(temp);
    }
}


void peek()
{
    if(top == 0)
    {
        printf("Stack is empty");
    }
    else
    {
        printf("Top element is: %d", top->data);
    }
}


void display()
{
    struct node * temp;
    temp = top;
    if(top == 0)
    {
        printf("Stack is empty");

    }
    else
    {
        while(temp != 0)
        {
            printf("%d\t", temp->data);
            temp = temp->link;
        }
    }
    
}



void main()
{
    push(5);
    push(10);
    display();
    printf("\n");
    pop();
    printf("\n");
    display();

    getch();
}
