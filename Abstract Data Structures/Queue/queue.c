#include<stdio.h>
#include<conio.h>

#define N 10
int queue[N];
int copyQueue[N];
int front = -1;
int rear = -1;
int cfront = -1;
int crear = -1;
int length=0;

void enqueue(int inputQueue[], int m)
{
    if(rear == N-1) // when the queue is full
    {
        printf("\nOverflow Condition");
    }
    else if(front == -1 && rear == -1) // when the queue is empty (all insertion would pass through this condition once)
    {
        front = rear = 0;
        inputQueue[rear] = m;
        length++;
    }
    else
    {
        rear++;
        inputQueue[rear] = m;
        length++;
    }
    // printf("\n%d", length);
}

void dequeue(int inputQueue[])
{
    if(front == -1 && rear == -1) // when the queue is empty
    {
        printf("\nUndeflow Condition");
    }
    else if(front == rear) // only 1 element is remaining in the queue
    {
        front = rear = -1;
        length--;
    }
    else
    {   
        printf("\nThe dequeued element from the queue is: %d", inputQueue[front]);
        front++;
        length;
    }
    // printf("\n%d", length);
}

void CopyQueue()
{
    for(int i=0;i<length;i++)
    {
        copyQueue[i] = queue[i];
    }
    cfront = 0;
    crear = length-1;
}

void display(int inputQueue[])
{
    int i;

    if(front == -1 && rear == -1)
    {
        printf("\nQueue is empty");
    }
    else
    printf("\n");
    {
        for(i=front;i<=rear;i++)
        {
            printf("%d ", inputQueue[i]);
        }
    }
}


void main()
{

    int n, queueChoice, num;
    printf("\n1. Enqueue\n2. Dequeue\n3. CopyQueue\nEnter your choice: ");
    scanf("%d", &n);
    switch(n)
    {     
        case 1: printf("\nEnter the value to enqueue: ");
                scanf("%d", &num);
                printf("\nEnter the Queue to perform operation on:\n1. Main Queue\n2. Copy Queue: ");
                scanf("%d", &queueChoice);
                if(queueChoice == 1)
                {
                    enqueue(queue, num);
                    display(queue);
                    main(); break;
                }
                else if(queueChoice == 2)
                {
                    enqueue(copyQueue, num);
                    display(copyQueue);
                    main(); break;
                }
                else
                {
                    printf("\nInvalid Choice");
                }

        case 2: printf("\nEnter the Queue to perform operation on:\n1. Main Queue\n2. Copy Queue: ");
                scanf("%d", &queueChoice);
                if(queueChoice == 1)
                {
                    dequeue(queue);
                    display(queue);
                    main(); break;
                }
                else if(queueChoice == 2)
                {
                    dequeue(copyQueue);
                    display(copyQueue);
                    main(); break;
                }
                else
                {
                    printf("\nInvalid Choice");
                }

        case 3: CopyQueue(); display(copyQueue); main(); break; 

        default: printf("\nInvalid Choice");
    }
    
    getch();
}



