package guimodule;

public class Sort {

	/*
	 * SELECTION SORT
	 */
	public int[] selectionSort(int[] a) {
		int smallest;
		for (int i = 0; i <= a.length - 2; i++) {
			smallest = findSmallest(a, i, a.length - 1);
			if (smallest != i)
				a = swap(a, smallest, i);
		}
		return a;
	}

	public int findSmallest(int[] a, int low, int high) {
		int small = low;
		for (int i = low + 1; i <= high; i++) {
			if (a[small] > a[i])
				small = i;
		}
		return small;
	}

	public int[] swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

		return a;
	}

	public static void main(String[] args) {
		Sort s = new Sort();
		int[] a = { 23, 12, 54, 21, 67, 1 };
		int[] sorted = s.selectionSort(a);
		for (int i = 0; i <= sorted.length - 1; i++) {
			System.out.println(sorted[i]);
		}

	}
}
