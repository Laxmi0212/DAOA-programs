                                                                                      #inclue<stdio.h>
#include<conio.h>
#include<math.h>

int compute(int a,int n,int p)
{
int s,s1,s2;
if(n==1)
return a%p;
else
if(n%2==0) // if even simply half the power
{
s=n/2;    //power half
s1=pow(a,s);  //formula=((a^s %p)^2)%p
s2=s1%p;
return ((s2*s2) % p);
}
else
{
s=n/2;    //power half
s1=pow(a,s);  //formula=((a^s %p)^2)%p
s2=s1%p;
return (((s2*s2)*a) % p);
}
}


void main()
{
 int a,n,p,result;
 clrscr();
 printf("We want to compute a^n mod p\n");

 printf("Enter the value of a: ");
 scanf("%d",&a);
 printf("Enter the value of n: ");
 scanf("%d",&n);
 printf("Enter the value of p: ");
 scanf("%d",&p);

 result= compute(a,n,p);
 printf("Result is %d",result);
  getch();
}

