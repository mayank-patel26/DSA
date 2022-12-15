/*
BINARY EXPRESSION TREE: THEORY:

leaves-operands
internal node-operators

least precedence operator(the operator that would be executed at last) would be at the top of the tree i.e. root of the tree.
highest precedence operator(the operator that would be executed at last) would be at the leaf of the tree i.e. near or at bottom.

example: keeping in mind the precedence which is:
^ : R->L
*  / : L->R
-  + : L->R

Construction of Binary Expression Tree from Infix Expression:
infix expression: a*b/c+e/f*g+k-x*y
step 1: we first find the lowest precedence operator which is either -  or + and they have associativity of L to R , so we traverse 
the infix expression from left to right and find the LAST operator i.e. the - operator before x variable
and we continue in this manner to construct the tree from top to bottom

Preorder traversal will give prefix expression (Root Left Right)
Postorder traversal will give postfix expression (Left Right Root)
Inorder traversal will give infix expression (verify if the tree is correct) (Left Root Right)

Construction of Binary Expression Tree from Postfix Expression:
we convert infix to postfix first.
We use stack here
we traverse the postfix expression, if there is an operand push it into the stack. BUT as soon as an operand is encountered, a newnode
is created and a POINTER to that newnode is pushed into the stack.
if an operator is encountered, the operands are popped out (pointers are popped out) and the operator is pushed in between the
operands such that the operands become the left child and right child of the operator respectively.
and then we again push the pointer to the sub-tree into the stack.


*/