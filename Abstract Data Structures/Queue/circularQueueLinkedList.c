//IMPLEMENTATION OF CIRCULAR QUEUE USING LINKED LIST

#include<conio.h>
#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
};

struct node *front = 0;
struct node *rear = 0;

void enqueue(int m)
{
    struct node *newnode;
    newnode = (struct node*)malloc(sizeof(struct node));
    newnode->next = 0;
    newnode->data = m;
    // printf("Enter the data to be inserted: ");
    // scanf("%d", &newnode->data);

    if(rear == 0)
    {
        front = newnode;
        rear = newnode;
        rear->next = front;
    }
    else
    {
        rear->next = newnode;
        rear = newnode;
        rear->next = front;
    }
    printf("\nAfter enqueue: front is: %d and rear is: %d", front->data, rear->data);
}


void dequeue()
{
    struct node *temp;
    temp = front;
    
    if(front == 0 && rear == 0)
    {
        printf("\nQueue is empty, underflow condition");
    }
    else if(front == rear)
    {
        printf("inside else if");
        printf("\nThe dequeued element is: %d", temp->data);
        front = 0;
        rear = 0;
        free(temp);
    }
    else
    {
        front = front->next;
        rear->next = front;
        printf("\nThe dequeued element is: %d", temp->data);
        free(temp);
    }
}

void peek()
{
    if(front == 0 && rear == 0)
    {
        printf("\nQueue is empty");
    }
    else
    {
        printf("\nThe element at front is: %d", front->data);
    }
}


void display()
{   
    struct node *temp;
    temp = front;
    if(front == 0 && rear == 0)
    {
        printf("\nQueue is empty");
    }
    else
    {
        printf("\n");
        while(temp != rear)
        {
            printf("%d ", temp->data);
            temp = temp->next;
        }
        printf("%d ", rear->data);
    }
}

void main()
{
    enqueue(10);
    enqueue(20);
    enqueue(30);
    enqueue(50);
    enqueue(150);
    display();

    dequeue();
    display();

    getch();
}