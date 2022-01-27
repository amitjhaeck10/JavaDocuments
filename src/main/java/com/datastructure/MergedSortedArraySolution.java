package main.java.com.datastructure;


//https://www.geeksforgeeks.org/merge-two-sorted-arrays/
public class MergedSortedArraySolution {

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        int[] arr = mergedSortedArray(arr1, arr2);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    private static int[] mergedSortedArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0, j = 0, k = 0;
        int[] finalArr = new int[n1 + n2];

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                finalArr[k++] = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                finalArr[k++] = arr2[j++];
            } else if (arr1[i] == arr2[j]) {
                finalArr[k++] = arr1[i++];
                finalArr[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            finalArr[k++] = arr1[i++];
        }
        while (j < n2) {
            finalArr[k++] = arr2[j++];
        }

        return finalArr;
    }
}
