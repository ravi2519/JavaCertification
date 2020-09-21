package streams;

public interface NoLoops {

	// Iterative version, requires constant space
	public static int arraySum(int[] array) {
		int sum = 0;
		for (int i=0; i<array.length; i++)
			sum += array[i];
		return sum;
	}
	
	// Recursive version, requires linear space
	public static int arraySum2(final int[] array, final int start) {
		if (start >= array.length)
			return 0;
		else
			return array[start] + arraySum2(array, start + 1);
	}

	
	public static void main(String[] args) {
		int a[] = { 42, 18, 5, 5, 30 };
		System.out.println(arraySum(a));
		System.out.println(arraySum2(a, 0));
	}

}
