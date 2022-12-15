#include<stdio.h>
#include<conio.h>
int i=0, length = 0;
struct node 
{
    int data;
    struct node *next;
    struct node *prev;
    
};

struct node * head = 0;
struct node * tail;
struct node * newnode;
struct node * temp;

void create()
{
    int choice = 1;
    while(choice == 1)
    {
        newnode = (struct node *)malloc(sizeof(struct node));
        printf("Enter data in the node: ");
        scanf("%d", &newnode->data);
        
        newnode->next=0;
        newnode->prev=0;

        if(head == 0)
        {
            head = newnode;
            temp = newnode;
            tail = newnode;
        }
        else
        {
            temp->next = newnode;
            newnode->prev = temp;
            temp = newnode;
            tail = newnode;
        }
        length++;
        printf("do you want to continue? (1/0): ");
        scanf("%d", &choice);

    }
    
}

void insert()
{   
    int pos, i, sel;
    newnode = (struct node *)malloc(sizeof(struct node));
    temp = head;
    newnode->next=0;
    newnode->prev=0;
    printf("\nEnter the position you want to insert the newnode at: ");
    scanf("%d", &pos);

    if(pos <= 0 || pos > length)
    {
        printf("Invalid Length");
        insert();
    }

    printf("\nEnter the data of the newnode: ");
    scanf("%d", &newnode->data);
    
    if(pos != 1 && pos !=length) //insert at position, if you want to insert after position change int i = 1
    {   
        printf("\n1. Insert At Position\n2. Insert After Position\nEnter selection: ");
        scanf("%d", &sel);
        if(sel == 1)
            i = 1;
        else
            i = 0;
        
        while(i < pos-1)
        {
            temp = temp->next;
            i++;
        }
        newnode->prev = temp;
        newnode->next = temp->next;
        temp->next = newnode;
        newnode->next->prev = newnode;
    }

    if(pos == 1)
    {
        head->prev = newnode;
        newnode->next = head;
        head = newnode;
    }

    if(pos == length)
    {
        tail->next = newnode;
        tail = newnode;
        
    }



    length++;
    display();
}

void delete()
{

    //COMPLETE ON YOUR WON (EASY)

}

void Reverse()
{
    struct node * current;
    struct node * nextnode;
    current = head;
    while(current != 0)
    {
        nextnode = current->next;
        current->next = current->prev;
        current->prev = nextnode;
        current = nextnode;
    }
    current = head;
    head = tail;
    tail = current;
    printf("\nReversed List is: ");
    display();
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
    // printf("\nTail node is: %d", tail->data);
    // printf("\nLength is: %d", length);
}

void main()
{
    create();
    display();
    // insert();
    Reverse();

    getch();
}
