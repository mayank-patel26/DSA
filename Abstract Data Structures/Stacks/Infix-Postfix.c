#define SIZE 50
#include <ctype.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

char s[SIZE];
int top = -1;

void push(char e)
{
    s[++top] = e;
}

char pop()
{
    return s[top--];
}

int pr(char e)
{
    switch (e)
    {
    case '#':
        return 0;
    case '(':
        return 1;
    case '+':
    case '-':
        return 2;
    case '*':
    case '/':
    case '%':
        return 3;
    case '^':
        return 4;
    default:
        break;
    }
}

void intoPost(char infx[50], char pofx[50])
{
    char ch;
    int i = 0, k = 0;
    push('#');

    while ((ch = infx[i++]) != '\0')
    {
        if (ch == ' ')
        {
            continue;
        }
        if (ch == '(')
        {
            push(ch);
        }
        else if (isalnum(ch))
        {
            pofx[k++] = ch;
            pofx[k++] = ' ';
        }
        else if (ch == ')')
        {
            while (s[top] != '(')
            {
                pofx[k++] = pop();
                pofx[k++] = ' ';
            }
            pop();
        }
        else
        {
            if (pr(s[top]) == 4 && pr(ch) == 4)
            {
                push(ch);
            }
            else
            {
                while (pr(s[top]) >= pr(ch))
                {
                    pofx[k++] = pop();
                    pofx[k++] = ' ';
                }
                push(ch);
            }
        }
    }
    while (s[top] != '#')
        pofx[k++] = pop();
    pofx[k++] = ' ';
    pofx[k] = '\0';
}

void main()
{
    char infx[50], pofx[50], prefixF[50];
    int j;
    printf("\n\nRead the Infix Expression ? ");
    gets(infx);

    intoPost(infx, pofx);
    printf("\n\nGiven Infix Expn: %s Postfix Expn : %s\n", infx, pofx);
}