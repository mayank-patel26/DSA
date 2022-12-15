#include<conio.h>
#include<stdio.h>
#include<stdlib.h>
int i, length=0;

struct node
{
    int data;
    struct node * next;
};

struct node * head = 0; 
struct node * newnode;
struct node * temp;
struct node * prev;

void create()
{   
    int choice = 1;
    while(choice == 1)
    {
        newnode = (struct node *)malloc(sizeof(struct node));
        printf("Enter data in the Node: ");
        scanf("%d", &newnode->data);
        newnode->next = 0;

        if(head == 0)
        {
            head = newnode;
            temp = newnode;
        }

        else    
        {
            temp->next = newnode;
            temp = newnode;
        }
        length++;
        printf("Do you want to continue (1/0)? ");
        scanf("%d", &choice);
    }
    printf("Length of the Linked List: %d", length);
    printf("\n");
}

void insert()
{       
    struct node * newtemp;
    struct node * prevtemp;
    int i, j;
    int pos;
    printf("\nEnter position to insert new node at: ");
    scanf("%d", &pos);
    newnode = (struct node *)malloc(sizeof(struct node));
    temp = head;
    printf("Enter data in the newnode: ");
    scanf("%d", &newtemp->data);

        if(pos == 1)
        {
            head = newnode;
            newtemp = newnode;
            newtemp->next = temp;
        }
        else
        {   
            newtemp = newnode;
            prevtemp = head;
            while(temp != 0)
            {
                for(i=0;i<=pos;i++)
                {   
                    temp = temp->next;
                }
                for(j=0;j<pos;j++)
                {   
                    prevtemp = prevtemp->next;
                }
            }

            prevtemp->next = newnode;
            newtemp->next = temp;
        }
}


void delete()
{
    int pos;
    printf("\nEnter the position to delete the node from: ");
    scanf("%d", &pos);

    if(pos == 1)
    {
        temp = head;
        head = temp->next;
        free(temp);
    }

    else if(pos>1 && pos != length)
    {   
        temp = head;
        prev = head;
        for(i=1;i<pos-1;i++)
        {
            prev = prev->next;
        }
        temp = prev->next;

        prev->next = temp->next;
        free(temp);
    }
    else if(pos == length)
    { 
        prev = head;
        for(i=1;i<pos-1;i++)
        {
            prev = prev->next;
        }
        temp = prev->next;

        prev->next = temp->next;
        free(temp);
    }
    else
    {
        printf("Invalid Length entered");
    }
}


void display()
{   
    printf("\n");
    temp = head;
    while(temp != 0)
    {
        printf("%d\t", temp->data);
        temp = temp->next;
    }
}

void getLength()
{   
    int count=0;
    temp = head;
    while(temp!=0)
    {
        count++;
        temp=temp->next;
    }
    printf("\nThe length of the linked list is: %d", count);
}

void ReverseIterative()
{   
    struct node * currentnode;
    struct node * prevnode;
    struct node * nextnode;
    
    currentnode = head;
    prevnode = 0;
    nextnode = head;
    
    while(nextnode!=0)
    {   
        nextnode = nextnode->next;
        currentnode->next = prevnode;
        prevnode = currentnode;
        currentnode = nextnode;
    }
    head = prevnode;
}

void main()
{   
    int b;
    create();
    display();
    // printf("\n1. Insert\n2. Delete\nEnter you choice: ");
    // scanf("%d", &b);
    // switch(b)
    // {
    //     case 1: insert(); break;
    //     case 2: delete(); break;
    //     default: printf("Invalid Choice");
    // }
    // getLength();
    ReverseIterative();
    display();

    getch();    
}