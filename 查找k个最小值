import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        Main m=new Main();
        m.find(a,k);
        int b[]=new int[k];
        for(int i=0;i<k;i++)
  b[i]=a[i];
  Arrays.sort(b);
        for(int i=0;i<k;i++)
        {
            if(i!=k-1)
            System.out.print(b[i]+",");
            else System.out.print(b[i]);
        }
  
  } 
     int find(int[] a, int k)
 {
  int low=0,high=a.length-1;
  int num=partition(a,low,high);
  while(true)
  {
   if(num==k-1) return a[num];
   else if(num<k-1) 
   {
    low=num+1;
    num=partition(a,low,high);
   }
   else
   {
    high=num-1;
    num=partition(a,low,high);
   }
  }
 }
 int partition(int[] a, int low, int high)
 {
  int i=low,j=high+1;
  int pivot=a[low];
  while(true)
  {
   while(a[++i]<pivot) if(i==high) break;
   while(a[--j]>pivot) if(j==low) break;
   if(i>=j) break;
   exch(a,i,j);
  }
  exch(a,low,j);
  return j;
 }
 void exch(int[] a, int i, int j)
 {
  int temp;
  temp=a[i];
  a[i]=a[j];
  a[j]=temp;
 }
}