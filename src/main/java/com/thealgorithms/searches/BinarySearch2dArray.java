package com.thealgorithms.searches;

import java.util.Arrays;

/*
To apply this method, the provided array must be strictly sorted. In this method, two pointers, one
at 0th row & the other at the last row are taken & the searching is done on the basis of the middle
element of the middle column. If that element is equal to target, its coordinates are returned, else
if it is smaller than the target, the rows above that element are ignored (because the elements
above it will also be smaller than the target), else that element is greater than the target, then
the rows below it are ignored.
 */
public class BinarySearch2dArray {

    static int[] BinarySearch(int[][] arr, int target) {
        int rowCount = arr.length, colCount = arr[0].length;

        int startRow = 0;
        int endRow = rowCount - 1;
        int midCol = colCount / 2;

        while (startRow <= endRow) {
            int midRow = (startRow + endRow) / 2;

            int col = Arrays.binarySearch(arr[midRow], target);
            if (col >= 0) {
                return new int[]{midRow, col};
            }

            if (arr[midRow][midCol] < target) {
                startRow = midRow + 1;
            } else {
                endRow = midRow - 1;
            }
        }

        return new int[]{-1, -1}; // Target not found
    }

    static int[] binarySearchRow(int[] row, int target, int colStart) {
        int col = Arrays.binarySearch(row, colStart, row.length, target);
        if (col >= 0) {
            return new int[]{row[col], col};
        }
        return new int[]{-1, -1};
    }

}
