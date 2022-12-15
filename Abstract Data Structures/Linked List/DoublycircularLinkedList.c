
#include<stdio.h>
#include<conio.h>

int length = 0, i;

struct node
{
    int data;
    struct node * next;
    struct node * prev;
};

struct node * tail;
struct node * current;
struct node * temp;
struct node * head = 0;
struct node * nextnode;
struct node * prevnode;
struct node * newnode;


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
            tail = newnode;
            head->prev = head;
            head->next = head;
        }
        else
        {
            tail->next = newnode;
            newnode->prev = tail;
            newnode->next = head;
            head->prev = newnode;
            tail = newnode;
        }
        length++;
        printf("do you want to continue? (1/0): ");
        scanf("%d", &choice);
    }
    printf("\nTail is: %d", tail->data);
}

void insert()
{
    int pos;
    printf("\nEnter the position you want to insert the node at: ");
    scanf("%d", &pos);
    newnode = (struct node *)malloc(sizeof(struct node));  
    
    /*malloc returns void pointer to the starting address 
    and so we typecase it to struct node type*/
    
    printf("Enter the data in the newnode: ");
    scanf("%d", &newnode->data);
    newnode->prev=0;
    newnode->next=0;

    if(pos <=0 || pos > length)
    {
        printf("Invalid position");
        insert();
    }

    else if(head == 0)
    {
        head = newnode;
        tail = newnode;
        newnode->next = newnode;
        newnode->prev = newnode;
    }

    else if(pos == 1)
    {
        newnode->next = head;
        head->prev = newnode;
        newnode->prev = tail;
        head = newnode;
        tail->next = head;
    }


    else if(pos == length)
    {
        newnode->prev = tail;
        tail->next = newnode;
        newnode->next = head;
        head->prev = newnode;
        tail = newnode;
    }

    else
    {
        int i = 1;
        temp = head;
        while(i < pos-1)
        {
            temp = temp->next;
            i++;
        }
        newnode->prev = temp;
        newnode->next = temp->next;
        temp->next->prev = newnode;
        temp->next = newnode;
    }
    length++;
    display();
}


void delete()
{
    int pos;
    printf("\nEnter the position of the node that you want to delete: ");
    scanf("%d", &pos);
    temp = head;
    
    if(head == 0)
    {
        printf("\nThe list is empty");
    }

    else if(head->next == head)
    {
        printf("\nThere is only one node in the list");
        head = 0;
        tail = 0;
        free(temp);
    }
    else if(pos == 1)
    {
        head->next->prev = tail;
        head = head->next;
        free(temp);    
    }
    else if(pos == length)
    {
        temp = tail;
        tail = tail->prev;
        tail->next = head;
        head->prev = tail;
        free(temp);
    }
    else
    {
        int i = 1;
        temp = head;
        while(i < pos)
        {
            temp = temp->next;
            i++;
        }
        temp->prev->next = temp->next;
        temp->next->prev = temp->prev;
        free(temp);
    }
    printf("Tail is: %d", tail->data);
    length--;
    display();
}


void display()
{   
    printf("\n");
    temp = head;
    while(temp != tail)
    {
        printf("%d\t", temp->data);
        temp = temp->next;
    }
    printf("%d\t", temp->data);
}

void main()
{
    create();
    display();
    // insert();
    delete();

    getch();
}