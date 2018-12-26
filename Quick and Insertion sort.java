/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.Scanner;

/**
 *
 * @author Laxmi Chainani
 */
class FirstDaa{
   
    void insertion(int a[],int n){
    for(int i=1;i<n;i++){
    int value=a[i];
   int j=i-1;
    while(j>=0 && a[j]>value){
    a[j+1]=a[j];
    j--;
    }
    a[j+1]=value;
    }
  }
    
   int partition(int a[],int l,int h){
       int m=-1;
       for(int j=0;j<=h;j++){
       if(a[j]<a[h])
       {
         m=m+1;
         //swap value of m and j
         int temp=a[m];
         a[m]=a[j];
         a[j]=temp;
        }
      }
        int temp2=a[m+1];
         a[m+1]=a[h];
         a[h]=temp2;
       
         return m+1 ;
   }
    
    void quick_sort(int a[],int l,int h){
    if(l<h){
    int q=partition(a,l,h);
    quick_sort(a,l,q-1);
    quick_sort(a,q+1,h);
    }
     
    }

}
public class DaaFirst {
    
    
    public static void main(String args[])
    {
        FirstDaa a=new FirstDaa();
        Scanner scan=new Scanner(System.in);
        System.out.println("1.Insertion Sort");
        System.out.println("2.Quick Sort");
        System.out.println("Enter your choice: ");
        int c=scan.nextInt();
          
        System.out.println("Enter number of elements:");
        int n=scan.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<arr.length;i++){
        arr[i]=scan.nextInt();
        }
        
        switch(c){
            
            case 1:
                           a.insertion(arr,n);
                           break;
            case 2:
                             a.quick_sort(arr,0,n-1);
                             break;
            default:
                           System.out.println("Invalid Input");
                           
        }
        
         System.out.println("Printed array is as follows: ");
          for(int i=0;i<arr.length;i++)
          System.out.print(" "+arr[i]); 
                         
      
    }
    
}
