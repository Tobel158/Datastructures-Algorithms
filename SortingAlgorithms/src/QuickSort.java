public class QuickSort {
    public static void main(String args[]){
        //Scanner input = new Scanner(System.in());
        int [] arr = {5, 8, 1, 3, 7, 9, 2};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    public static void quickSort(int [] arr){
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int left, int right){
        //partition
        if(right > left){
            //int index = parition(arr, left, right);
            int index = partitionWithRightPivot(arr, left, right);
            //int index = parition(arr, left, right)
            quickSort(arr,left, index-1 );
            quickSort(arr, index + 1, right);
        }

    }
    public static int parition(int[]arr, int left, int right){
        //Pivot is the first element of the array
        int pivot = arr[left];
        int lastS1 = left;//the divide between Section 1 and section 2;
        for( int firstUnknown = left+1; firstUnknown <= right; firstUnknown++ ){

            if(arr[firstUnknown] < pivot){ //expand section 1
                lastS1++;
                swap(arr, firstUnknown, lastS1);
            }
            //else element will be part of sectin 2
        }
        swap(arr, lastS1,left);
        return lastS1;
    }
    public static int partitionWithRightPivot(int[] arr, int left, int right){
        int pivot = arr[right];
        int firstS2 = right;
        for (int firstUnKnown = right - 1; firstUnKnown>=left; firstUnKnown--){
            if(arr[firstUnKnown] > pivot){
                firstS2--;
                swap(arr, firstS2, firstUnKnown);
            }
        }
        swap(arr, firstS2, right);
        return firstS2;
    }
//    public static int partitionWithSpecifiedPivot(int[] arr, int left, int right, int pivot){
//
//    }


    public static void swap (int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
