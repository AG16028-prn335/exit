#include <stdlib.h>
#include <stdio.h>
#include <limits.h>

struct Stack
{
int top;
unsigned capacidad;
int* arreglo;
};
struct Stack* createStack(unsigned capacidad){
struct Stack* pila=(struct Stack*)malloc(sizeof(struct Stack));
pila->capacidad= capacidad;
pila->top=-1;
pila->arreglo=(int*)malloc(pila->capacidad*sizeof(int));
return pila;
}

void push(struct Stack* pila, int valor)
{
pila->arreglo[++pila->top]=valor;
printf("valor pusheado %d\n",valor);
}

int pop(struct Stack* pila){
return pila->arreglo [pila->top--];
}

int peek(struct Stack* pila){
return pila ->arreglo[pila->top];
}

int main(){
int n,cont=0,num;
printf("cuantos numeros ingresara?");
scanf("%d",&n);
int vec[n];
struct Stack* pila=createStack(n);

for(int x=0;x<n;x++){
printf("ingrese el %d° numero",(x+1));
scanf("%d",&num);
vec[x]=num;
}

for(int x =0;x<n-1;x++){
if(vec[x]!=vec[x+1]){
cont++;
}
}
struct Stack* rayovac=createStack(cont);
int ve[cont];
for(int x =0;x<cont-1;x++){
if(vec[x]!=vec[x+1]){
ve[x]=vec[x];
}
}

return 0;
}
