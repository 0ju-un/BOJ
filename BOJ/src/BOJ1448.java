import java.util.*;

public class BOJ1448 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int result = -1;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);
	

		for (int i = N - 1; i > 1; i--) {
			if (arr[i] < (arr[i - 1] + arr[i - 2])) {
				result= arr[i] + arr[i - 1] + arr[i - 2];
				break;
			}
		}
		System.out.println(result);
	}
	

}
