//CIRCULAR QUEUE IMPLEMENTATION USING ARRAYS - static memory allocation

#include<conio.h>
#include<stdio.h>
#include<stdlib.h>

#define N 5
int queue[N];
int front = -1;
int rear = -1;

void enqueue(int m)
{
    if(front == -1 && rear == -1)
    {
        front = 0;
        rear = 0;
        queue[rear] = m;
    }
    else if((rear+1)%N == front)
    {
        printf("\nQueue is full, Overflow Condition");
    }
    else
    {
        rear = (rear+1)%N;
        queue[rear] = m;
    }
}

void dequeue()
{
    if(front == -1 && rear == -1)
    {
        printf("\nQueue is empty, Underflow Condition");
    }
    else if(front == rear)
    {
       front == -1;
       rear == -1; 
    }
    else
    {
        printf("\nThe dequeued element is: %d", queue[front]);
        front = (front+1)%N;
    }
}

void peek()
{
    if(front == -1 && rear == -1)
    {
        printf("\nQueue is empty");
    }
    else
    {
        printf("\nElement at front is: %d", queue[front]);
    }
}

void display()
{
    if(front == -1 && rear == -1)
    {
        printf("\nQueue is empty, Underflow condition");
    }
    else
    {
        printf("\n");
        int i = front;
        while(i != rear)
        {
            printf("%d ", queue[i]);
            i = (i+1)%N;
        }
        printf("%d ", queue[rear]);
    }
}

void main()
{
    enqueue(15);
    enqueue(25);
    enqueue(30);
    enqueue(40);
    enqueue(50);
    display();
    peek();
    dequeue();
    enqueue(100);
    display();

    getch();
}