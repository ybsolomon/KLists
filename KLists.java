public class KLists {

	public double[] get_left(double[] arr) { //finds the values on the left half of the given array
		int size = arr.length/2;
		double [] left = new double[size];
		for (int i = 0; i < size; i++) {
			left[i] = arr[i];
		}
		return left;
	} 

	public double[] get_right(double[] arr) { //finds the values on the right half of the given array
		int size = arr.length/2;
		double [] right = new double[size];
		for (int i = size, j = 0; i < arr.length && j < size; i++, j++) {
			right[j] = arr[i];
		}
		return right;
	} 

	public void merge(double[] arr, double[] left, double[] right) { //merges two arrays into a target array that fits all values of the given arrays
		int l = 0;
		int r = 0;
		int i = 0;

		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				arr[i] = left[l++];
			} else {
				arr[i] = right[r++];
			}
			i++;
		}

		while (l < left.length) {
			arr[i++] = left[l++];
		}

		while (r < right.length) {
			arr[i++] = right[r++];
		}
	}

	public double[] mergeKLists(double[][] outerarray) { //takes a double[][] and merges each array element with the arrays that came before
		double[] sorted = {};
		if (outerarray.length > 0) {
			sorted = outerarray[0];
			for (int i = 1; i < outerarray.length; i++) {
				double[] temp = new double[sorted.length + outerarray[i].length];
				merge(temp, sorted, outerarray[i]);
				sorted = temp;
			}
		}
		return sorted;
	}

	public void print_array(double[] arr) { //prints all elements of given array
		if (arr.length == 0) {
			System.out.println("[ ]");
		} else {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		double[][] arr = {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6}};//{}; //{{9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27}};
		KLists list = new KLists();

		double[] output = list.mergeKLists(arr);
		list.print_array(output);
	}
}