/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Laxmi Chainani
 */

class small{

    int findmedian(int arr[],int length){
    Arrays.sort(arr);
    return arr[length/2];
    }
    
   
    
    int partition(int arr[],int l,int h,int x){
        
        int i=0;
        int m=-1;
        
        
         int temp=arr[x];
              arr[x]=arr[h];
              arr[h]=temp;
              
              
        
              
        for(i=0;i<arr.length;i++){
            if(arr[i]<arr[h])
            {
                m=m+1;
              //  swap(&arr[m],&arr[i]);
              int tp=arr[m];
              arr[m]=arr[i];
              arr[i]=tp;
            }
        }
        
        //swap(&arr[m+1],&arr[x]);
          int tem=arr[m+1];
              arr[m+1]=arr[h];
              arr[h]=tem;
       
              return m+1;
    }
    
    void split(int arr[],int median[],int[][] output,int numchunks,int n,int l ){
        
        int start=l;
        int length;
        
        for(int i=0;i<numchunks;i++){
        //  int start=i*5;//5 is chunksize, start is the starting index of each subarray
     
     if(n>5)
      // length=5;
         length=Math.min(n-start,5);//everytime length is 5(min) but for last we are calculating(min) 
     
     else
         length=n;
      
      int[] temp=new int[length];//1d array of 1 subarray
      
      System.arraycopy(arr, start, temp,0, length);//copy data from arr into temp,starting from 0 index upto 5 or less(length of array)
      output[i]=temp;//temp represents 1 subarray
      
        //Now we are going to find median of output[i] subarrays
       median[i]=findmedian(output[i],output[i].length);
       start=start+5;
   }
    
    }
    
    
  int  ksmallest(int arr[],int l,int h,int k,int n){
       
     int numchunks=(int)Math.ceil((double)n/5);//calculate total num of subarray of size 5 are going to form
     int median[]=new int[numchunks];
      int[][] output=new int[numchunks][];
      
      split(arr,median,output,numchunks,n,l);
      
      
      int pivot=findmedian(median,median.length);
      int i;
      for(i=0;i<arr.length;i++){
      if(arr[i]==pivot)
          break;
      }
      
      int pos=partition(arr,l,h,i);
      //System.out.println(" "+pos);
      int r=pos+1;//rank of pivot;
      
      if(r==k)
          return arr[r-1];
      if(k<r)
      {
          n=r-1;
         return  ksmallest(arr,l, pos-1,k,n);
      }
      else
      {
          n=n-r;
         return  ksmallest(arr,pos+1,h,k,n);
      }
      }
}


public class Ksmall {
    
    public static void main(String args[]){
    
         small a=new small();
         Scanner scan=new Scanner(System.in);
        System.out.println("Enter number of elements you want to enter");
        int n=scan.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<arr.length;i++){
        arr[i]=scan.nextInt();
        }
        
        System.out.println("Enter kth smallest index you want to search: ");
        int k=scan.nextInt();
        
       int element=a.ksmallest(arr,0,n-1,k,n);
       
       System.out.println("kth smallest element is: "+element);
                 
        
    }
    
}
