%{
#include<stdio.h>
#include<stdlib.h>
%}


// FLOAT COMPLEX HEX
%token  INT  USER_OP  NL ID EOF STRING

%left '?'
%left "while" "for"
%right "if" 
%left "else"  

%left "next" "break"
%right "in"
%right LEFT_ASSIGN 
%right EQ_ASSIGN
%left RIGHT_ASSIGN
%left NS_GET NS_GET_INT
%left OR OR2 
%left AND AND2
%left NOT UNOT
%nonassoc GT LT GE LE EQ NE

%left '~' TILDE
%left '+' '-' 
%left '*' '/'
%left UMINUS UPLUS
%left ':'
%left "." "..."
%left '$' '@'
%right '^'
%nonassoc '(' '[' ')' ']' '{' '}' ',' ';' LBB RBB

%%

prog:   expr ';' expr
    |   NL expr
    |   NL
        EOF
    ;

expr:  
        ID
    |   STRING
    |   HEX
    |   INT
    |   FLOAT
    |   COMPLEX
    |   "NULL"
    |   "NA"
    |   "Inf"
    |   "NaN"
    |   "TRUE"
    |   "FALSE"

    |   '-' expr %prec UMINUS
    |   '+' expr %prec UPLUS
    |   "!" expr  %prec UNOT
    |   '?' expr 
    |   '~'expr %prec TILDE


    |   expr '[''[' sublist ']'']' 
    |   expr '[' sublist ']'
    |   expr NS_GET expr
    |   expr '$' expr
    |   expr '@' expr
    |   expr '^' expr

    |   expr ':' expr
    |   expr USER_OP expr 
    
    |   expr '*' expr
    |   expr '/' expr
    |   expr '+' expr
    |   expr '-' expr
    |   expr LT expr
    |	expr LE expr
	|	expr EQ expr
	|	expr NE expr
	|	expr GE expr	
	|	expr GT expr
    |   expr AND expr 
    |   expr AND2 expr
    |   expr OR expr 
    |   expr OR2 expr
    |   expr '~' expr
    |   expr LEFT_ASSIGN expr
    |   expr RIGHT_ASSIGN expr
    
    |   "function" '(' formlist ')' expr
    |   "function" '('')' expr
    |   expr '(' sublist ')'              
    |   '{' exprlist '}' 
    |   "if" condn expr
    |   "if" condn expr "else" expr
    |   "for" '(' ID "in" expr ')' expr 
    |   "while" condn expr
    |   "repeat" expr
    |   "next"
    |   "break"
    ;

condn: '(' expr ')'
    ;

exprlist:   expr ';' expr
    | expr NL expr
    ;

formlist: form ',' form 
    | ',' form;

form:   ID
    |   ID EQ_ASSIGN expr
    |   "..."
    |   '.'
    ;

sublist: sub ',' sub ;

sub:   expr
    |   ID EQ_ASSIGN
    |   ID EQ_ASSIGN expr
    |   STRING EQ_ASSIGN
    |   STRING EQ_ASSIGN expr
    |   "NULL" EQ_ASSIGN
    |   "NULL" EQ_ASSIGN expr
    |   "..."
    |   '.'
    |
    ;
%%


int main()
{	printf("Expression:\n");
	yyparse();
        
	printf("\nValid!\n");
	return 0;
}

int yyerror(char *msg)
{
	printf("the statement is invalid\n");
	exit(0);
}

