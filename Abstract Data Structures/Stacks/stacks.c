/*insertion and deletion is only possible from one end that is the top. LIFO-Last In First Out principle. OR you can also say
FILO-First In Last Out

insertion is known as push
deletion is known as pop

Operations: (you can only push data of one data type only)
1. Push(data you want to push)
2. Pop()     <no arguments are passed here>
3. Peek() / top()   <returns the topmost element of the stack without removing the topmost element from the stack>
4. isEmpty()   <true if the stack is empty>
5. isFull()   <true if the stack is full>

either static or dynamic memory allocation for stack
Static - using arrays
Dynamic - using Linked List

in starting the stack is empty and so the top = -1
index goes from bottom to top

if you do pop() operation on an empty stack then it is known as an Underflow Condition.
if you do push(data you want to insert) on a full stack it is known as an Overflow Condition.

Applications:
1. Reverse a String
2. Undo mechanism
3. Recursion/Function call
4. To check the balance of parenthesis
5. Infix to Postfix / Infix to Prefix
6. Topological Sorting
7. Tree Traversal
8. Evaluation of Postfix Expression
and many more

*/

//IMPLEMENTATION OF STACK USING ARRAYS (Static Memory Allocation

#include<stdio.h>
#include<conio.h>

#define N 5
int stack[N];
int top = -1;

void push() //O(1)
{
    int n;
    printf("Enter the data: ");
    scanf("%d", &n);

    if(top == N-1)
    {
        printf("The Stack is full. Overflow");
    }
    else
    {
        top++;
        stack[top] = n;
    }
}

void pop()  //O(1)
{
    int item;
    if(top == -1)
    {
        printf("Underflow");
    }
    else
    {
        item = stack[top];
        top--;
        printf("The popped element is: %d", item);
    }
}

void peek()  //O(1)
{
    if(top == -1)
    {
        printf("The stack is empty");
    }
    else
    {
        printf("The top element is: %d", stack[top]);
    }
}

void display()
{
    if(top == -1)
    {
        printf("The stack is empty");
    }
    else
    {
        int i;
        for(i=top;i>=0;i--)
        {
            printf("%d\t", stack[i]);
            top--;
        }
    }
}


void main()
{   
    int choice;
    printf("\n1. Push\n2. Pop\n3. Peek\n4. Display\nEnter your choice: ");
    scanf("%d", &choice);
    switch (choice)
    {
    case 1:  push();   break;
    case 2:  pop();   break;
    case 3:  peek();   break;
    case 4: display(); break;
    default: printf("Invalid Input");  main(); break;
    }

    main();

    getch();
}