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

class Demo{
void majority(int arr[],int n){
    
       if(n%2!=0)
        {
             int cnt=0;
             int a=arr[n-1];
            System.out.println("Array is odd we check last element as majority");
            System.out.println("Last element is "+a);
              
            for(int i=0;i<arr.length;i++)
                {
                    if(a==arr[i])
                        cnt++;
                }
                if(cnt>n/2)
                    System.out.println("It is majority");
                     
                else
                {
                    System.out.println("Not a majority discard that element search for element in remaining even array..\n");
                    majority(arr,n-1);
                }
            
        }
        
        else
        {
                 int i=0;
                int  k=0;
                 int j;
                 int arr2[]=new int[n];
        
                 while(i<n-1){
                 j=i+1;
                 if(arr[i]==arr[j])
                 {
                     arr2[k]=arr[i];
                     k++;
                 }
                 i=i+2;
                 }
                 
                 int length=k;
                 
                 if(length==1)
                 {
                     int count=0;
                   for(i=0;i<arr.length;i++)
                   {
                        if(arr2[0]==arr[i])
                        count++;
                   }
                        if(count>n/2)
                        System.out.println("Majority is "+arr2[0]);
                         else
                         System.out.println("No majority exists..");
                 }
                 else
                     if(length==0)
                          System.out.println("No majority exists..");
                     else
                         majority(arr2,length);
                 
                
        
        }

}
}
public class Majority {
    
    public static void main(String args[]){
        Demo a=new Demo();
        Scanner scan=new Scanner(System.in);
            
        System.out.println("Enter number of elements:");
        int n=scan.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<arr.length;i++){
        arr[i]=scan.nextInt();
        }
        a.majority(arr,n);
      }
    
}
