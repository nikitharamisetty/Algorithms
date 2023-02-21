import java.util.Arrays;
public class heapSort {

    public static void minHeap(int[] arr, int val){             // Function to convert arr into minHeap
        int l = val*2;
        int r = val*2 + 1;
        int minimum = val;
        int length = arr[0];
        if(l <= length && arr[l] < arr[minimum])             //see which child is smaller than parent
            minimum = l;
        if(r <= length && arr[r] < arr[minimum])
            minimum = r;

        if(minimum != val) {
            int temp = arr[minimum];                       //if there is smaller element, swap the elements
            arr[minimum] = arr[val];
            arr[val] = temp;
            minHeap(arr, minimum);
        }
    }

    public static void buildHeap(int[] arr){           // Function to construct an heap
        int length = arr[0];

        int temp_parent = length/2;

        while(temp_parent>0){
            minHeap(arr, temp_parent);
            temp_parent -= 1;
        }

    }

    public static void heapSort(int[] arr){          //Function to heap sort
        int length = arr[0];
        for(int i = length; i >= 1; i--){            //swap first element with last and then procolate down
            int temp = arr[i];
            arr[i] = arr[1];
            arr[1] = temp;
            arr[0] = arr[0]-1;
            minHeap(arr, 1);
        }
        arr[0] = length;
    }

    public static void main(String[] args){
        int[] arr = {15,7,60,3,49,5,70,41,30,29,16,12,6,1,10,99};
        System.out.println("The first element is the size of heap or array");
        System.out.println("Input array: " );
        System.out.print("[");
        for (int i : arr)            // printing the array
            System.out.print(i + "  ");
        System.out.print("]");
        System.out.println();

        buildHeap(arr);

        System.out.println("After converting into heap: ");
        System.out.print("[");
        for (int i : arr)            // printing the array
            System.out.print(i + "  ");
        System.out.print("]");
        System.out.println();

        heapSort(arr);

        System.out.println("After heap sort:");
        System.out.print("[");
        for (int i : arr)            // printing the array
            System.out.print(i + "  ");
        System.out.print("]");
        System.out.println();
    }
}

