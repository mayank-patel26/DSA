/*

Infix: <operand><operator><operand>
Prefix: <operator><operand><operand>
Postfix: <operand><operand><operator>

Precedence and Associativity: 
1. () {} []
2. ^          -->  R-L   
3. *  /       -->  L-R
4. +  -       -->  L-R 

*/

#include<stdlib.h>
#include<conio.h>
#include<stdio.h>
#include<ctype.h>

#define MAX 100
char stack[MAX];
int top = -1;

void push(char p){
    if(top == MAX-1)
        printf("\nOverflow");
    else{
        top++;
        stack[top] == p;
    }
}

char pop(){
    if(top == -1){
        printf("Underflow");
        return -1;
    }
        
    else{
        return(stack[top--]);
    }
        
}

char peek(){
    if(top == -1){
        return -1;
    }
    else{
        return(stack[top]);
    }
}

int isEmpty(){
    if(top == -1){
        return 1;
    }
    else{
        return 0;
    }
}

int precedence(char x){
    if(x == '(' || x == ')')
        return 4;
    else if(x == '^')
        return 3;
    else if(x == '*' || x == '/')
        return 2;
    else if(x == '+' || x == '-')
        return 1;
    else if(x == '(')
        return 0;
}

int assoc(char x){
    if(x == '^')
        return 0; //R to L
    else
        return 1; //L to R
}


void main(){
    int j=0, k=0;
    char infix[MAX], postfix[MAX];
    printf("Enter the infix expression: ");
    scanf("%s", &infix);

    while(infix[j]!='0'){

        if(infix[j]!='(' && infix[j]!=')' && infix[j]!='^' && infix[j]!='/' && infix[j]!='*' && infix[j]!='+' && infix[j]!='-'){
            postfix[k++] == infix[j];
        }
        else if(isEmpty() || peek() == '('){
            push(infix[j]);
        }
        else if(infix[j]=='(')
            push( infix[j]);
        else if(infix[j]==')'){
            while(peek()!='('){
                postfix[k++] = pop();
            }
            pop();
        }
        else if(precedence(infix[j]) > precedence(peek())){
            push(infix[j]);
        }
        else if(precedence(infix[j]) < precedence(peek())){
            postfix[k++] = pop();
            if(isEmpty())
                continue;
            push(infix[j]);
        }
        else{
            if(assoc(infix[j])){
                postfix[k++] = pop();
                push(infix[j]); 
            }
            else
                push(infix[j]);
        }
        j++;
    }

    while(top != -1){
        postfix[k++] = pop();
    }

    postfix[k] = 0;
    puts(postfix);

    getch();
}