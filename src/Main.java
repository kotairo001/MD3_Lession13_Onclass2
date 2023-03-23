import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Input the size of array");
        size = input.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Input the " + (i + 1) + " number of array");
            array[i] = input.nextInt();
        }
        System.out.println("Your array-->" + Arrays.toString(array));
        int temp = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        System.out.println("Sorted array-->" + Arrays.toString(array));
        System.out.println("Input the number your want to find");
        int value = input.nextInt();
        int result = binarySearch(array, 0, size - 1, value);
        System.out.println(result == -1 ? "Not Found" : ("Element found at index " + result));
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        int middle;
        while (right >= left) {
            middle = (right + left) / 2;
            if (value < array[middle]) {
                return binarySearch(array, left, middle - 1, value);
            } else if (value == array[middle]) {
                return middle;
            } else {
                return binarySearch(array, middle + 1, right, value);
            }
        }
        return -1;
    }

}
