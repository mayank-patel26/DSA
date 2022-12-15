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
struct node * tail;
struct node * current;
struct node * nextnode;

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
    tail = temp;
    temp->next = head;
    printf("Length of the Linked List: %d", length);
    printf("\n");
    printf("Data in tail is: %d", tail->data);
}

void insert()
{   
    int pos;
    newnode = (struct node *)malloc(sizeof(struct node));
    printf("\nEnter the position you want to insert the new node at: ");
    scanf("%d", &pos);
    printf("Enter the data in the newnode: ");
    scanf("%d", &newnode->data);

    if(pos <= 0 || pos > length)
    {
        printf("Invalid positon");
        insert();
    }

    else if(pos == 1)
    {
        newnode->next = tail->next;
        tail->next = newnode;
        head =  newnode;
    }
    else if(pos == length)
    {
        newnode->next = tail->next;
        tail->next = newnode;
        tail = newnode;
        // printf("Tail element is: %d", tail->data);
        
    }

    else
    {
        temp = tail->next;
        while(i < pos - 1)
        {
            temp = temp->next;
            i++;
        }

        newnode->next = temp->next;
        temp->next = newnode;
    }

    display();
}


void delete()
{   
    int pos;
    printf("\nEnter the position of that you want to delete: ");
    scanf("%d", &pos);
    temp = tail->next;
    printf("\n%d", tail->data);
    
    if(pos <= 0 || pos > length)
    {
        printf("Invalid positon");
        insert();
    }

    if(tail == 0)
    {
        printf("the list is empty");
    }


    if(pos == 1)
    {
        if(temp->next == temp)
        {
            tail = 0;
            free(temp);
        }   
        else
        {
            tail->next = temp->next;
            free(temp);
        }
        
    }

    if(pos == length)
    {
        current = tail->next;
        if(current->next == current)
        {
            tail = 0;
            free(temp);
        }   
        else
        {
            while(current->next != tail->next)
            {
                prev = current;
                current = current->next;
            }
            prev->next = prev->next;
            tail = prev;
            free(current);
        }
    }

    else
    {
        int i = 1;
        current = tail->next;
        while(i < pos-1)
        {
            current = current->next;
            i++;
        }
        nextnode = current->next;
        current->next = nextnode->next;
        free(nextnode);
    }

    displayusingtail();
}

void Reverse()
{
    current = tail->next;
    nextnode = current->next;
    if(tail ==0 )
    {
        printf("The list is empty");
    }
    else if(tail->next ==  tail)
    {
        printf("There is only one node in the list");
    }
    else
    {
        while(current != tail)
        {
            prev = current;
            current = nextnode;
            nextnode = current->next;
            current->next = prev;
        }
        nextnode->next = tail;
        tail = nextnode;
    }
    printf("\nReversed List is: ");
    displayusingtail();
}

void display()
{   
    printf("\n");
    temp = head;
    while(temp->next != head)
    {
        printf("%d\t", temp->data);
        temp = temp->next;
    }
    printf("%d\t", temp->data);
}



void displayusingtail()
{   
    printf("\n");
    temp = tail->next;
    while(temp->next != tail->next)
    {   
        printf("%d\t", temp->data);
        temp = temp->next;
    }
    printf("%d\t", temp->data);
}


void main()
{
    create();
    displayusingtail();
    // insert();
    // delete();
    Reverse();



    getch();
}