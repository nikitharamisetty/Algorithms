import java.util.Arrays;
import java.util.Scanner;
public class TertiarySearch{
    static int search(int array[], int h, int r, int value)
    {
        if(r>=h){
            int mid1 = h + (r-h) / 3;
            int mid2 = r - (r-h) /3;
            
            if(array[mid1]==value){
                return mid1;
            }
            if(array[mid2]==value){
                return mid2;
            }         
            if(array[mid1]>value){
                return search(array,h,mid1-1,value);
            }
            else if(array[mid2]<value){
                return search(array,mid2+1,r,value);
            }
            else{
                return search(array,mid1+1,mid2-1,value);
            }        
        }return -1;
        
        
    }
    public static void main(String args[])
    {
        int[] array = {1,2,3,4,5,6,7,8,9,10,14,16,17,20,24};
        int n = array.length;
        
        System.out.println("Given Array:");
        System.out.println(Arrays.toString(array));
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter key value:"); 
        int val = myObj.nextInt();   
        System.out.println("Finding the element: " + val);
        int el = search(array, 0, n-1, val);
        if (el!= -1){
            System.out.println("Element found in the array at position: "+ el);
        }else{
            System.out.println("Element not found in the given array");
        }

    }
    
}