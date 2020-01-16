import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        binarySearch(arr, 5);
    }

    private static void binarySearch(int[] arr, int search) {
        if (arr.length == 0) {
            System.out.println("Need to fill of the array");
            return;
        }
        int pivot = arr.length / 2;
        if (arr[pivot] == search) {
            System.out.println("Number " + search + " found!");;
        }
        else if (pivot == 0) {
            System.out.println("Number " + search + " not found");
        }
        else if (search < arr[pivot]) {
            arr = Arrays.copyOfRange(arr, 0, pivot);
            binarySearch(arr, search);
        }
        else if (search > arr[pivot]) {
            arr = Arrays.copyOfRange(arr, pivot, arr.length);
            binarySearch(arr, search);
        }
    }
}
