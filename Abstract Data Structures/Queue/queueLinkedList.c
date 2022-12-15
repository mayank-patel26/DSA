//IMPLEMENTATION OF QUEUE USING LINKED LIST - dynamic memory allocation
// 2 conditions need to be satisfied: i). FIFO principle   ii). Time Complexity of enqueue() and dequeue() should be O(1)

#include<conio.h>
#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
};

struct node *front = 0;  //head pointer
struct node *rear = 0;  //tail pointer


void enqueue(int m)
{
    struct node *newnode;
    newnode = (struct node *)malloc(sizeof(struct node));
    newnode->data = m;
    newnode->next = 0;

    if(front == 0 && rear == 0) //when the queue is empty, insertion using enqueue() will insert the first node
    {
        front = newnode;
        rear = newnode;
    }
    else //when the queue is not empty
    {
        rear->next = newnode;
        rear = newnode;
    }
}

void dequeue()
{   if(front == 0 && rear == 0)
    {
        printf("\nThe queue is empty, Underflow condition");
    }
    else
    {
        struct node *temp;
        temp = front;
        printf("\nThe dequeued element is: %d", front->data);
        front = front->next;
        free(temp);
    }
}

void peek()
{
    if(front==0 && rear==0)
    {
        printf("\nThe queue is empty");
    }
    else
    {
        printf("\nThe data at front is: %d", front->data);
    }
}

void display()
{
    struct node *temp;
    if(front == 0 && rear == 0)
    {
        printf("\nQueue is Empty");
    }
    else
    {   
        printf("\n");
        temp = front;
        while(temp!=0)
        {
            printf("%d ", temp->data);
            temp = temp->next;
        }
    }
}

void main()
{

    enqueue(10);
    enqueue(50);
    enqueue(90);
    display();
    dequeue();
    peek();
    display();

    getch();
}