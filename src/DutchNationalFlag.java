import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] input = { 1, 4, 3, 3, 1, 4, 3, 1, 4, 3, 1, 3, 4, 4, 3, 1 };
        dutchNationalFlagSortingAlgorithm(input);
        Arrays.stream(input).forEach(System.out::println);
    }

    public static void dutchNationalFlagSortingAlgorithm(int[] input) {
        int lowPtr = 0, midPtr = 0, highPtr = input.length - 1;
        while (midPtr < highPtr) {
            int c = input[midPtr];
            switch (c) {
                case 1:
                    swapArrayEmements(input, lowPtr, midPtr);
                    lowPtr++;
                    midPtr++;
                    break;
                case 3:
                    midPtr++;
                    break;
                case 4:
                    swapArrayEmements(input, highPtr, midPtr);
                    highPtr--;
                    break;
            }
        }
    }

    public static void swapArrayEmements(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
