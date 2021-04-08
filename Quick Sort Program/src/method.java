import java.util.*;

public class method {
    static int[] printArray;

    public void quickSort(int array[], int low, int high) {
        if (array.length == 1) {
            printArray = array;
            return;
        } else if (low < high) {
            int rLow = partition(array, low, high);
            quickSort(array, low, rLow);
            quickSort(array, rLow + 1, high);
            printArray = array;
        }
    }

    public int partition(int array[], int low, int high) {
        int pivot = array[low];
        int recursiveLow = low;
        for (int j = low + 1; j <= high; j++) {
            if (array[j] > pivot) {
                recursiveLow = recursiveLow + 1;
                int temp = array[recursiveLow];
                array[recursiveLow] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[recursiveLow];
        array[recursiveLow] = array[low];
        array[low] = temp;
        return recursiveLow;
    }

    public static void print() {
        if (printArray.length == 1) {
            System.out.println("\nSorted Array: ");
            System.out.print(printArray[0]);
        } else {
            System.out.println("\nSorted array: ");
            for (int i = 0; i < printArray.length; i++) System.out.print(printArray[i] + ", ");
        }
    }
}
