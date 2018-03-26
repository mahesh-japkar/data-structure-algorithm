package com.test.dynamicprograming;

public class MaximumSubSquareMatrix {

	public static void main(String[] args) {
		int rowCount = 4;
		int colCount = 5;

		int[][] arr = { { 0, 0, 1, 1, 1 }, { 1, 0, 1, 1, 1 }, { 0, 1, 1, 1, 1 }, { 1, 0, 1, 1 } };
		System.out.print("Area of maximum square is " + maxSqaure(rowCount, colCount, arr));
	}

	private static int maxSqaure(int rowCount, int colCount, int[][] arr) {
		int result[][] = new int[arr.length][arr[0].length];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			result[i][0] = arr[i][0];
			if (result[i][0] == 1) {
				max = 1;
			}
		}
		for (int i = 0; i < arr[0].length; i++) {
			result[0][i] = arr[0][i];
			if (result[0][i] == 1) {
				max = 1;
			}

		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					continue;
				}
				int t = min(result[i - 1][j], result[i - 1][j - 1], result[i][j - 1]);
				result[i][j] = t + 1;
				if (result[i][j] > max) {
					max = result[i][j];
				}
			}
		}
		return max;
	}

	private static int min(int a, int b, int c) {
		int l = Math.min(a, b);
		return Math.min(l, c);
	}
}
