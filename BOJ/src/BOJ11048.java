/* 이동하기 */
import java.util.Scanner;

public class BOJ11048 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] dp = new int[N][M];
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				arr[i][j] = sc.nextInt();
		
		// 초기값
		dp[0][0] = arr[0][0];
		for(int i=1; i<N; i++)
			dp[i][0] = arr[i][0] + dp[i-1][0];
		for(int j=1; j<M; j++)
			dp[0][j] = arr[0][j]+dp[0][j-1];
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				dp[i][j] = arr[i][j] + Math.max(dp[i-1][j],Math.max( dp[i][j-1], dp[i-1][j-1]));
			}
		}
		
		System.out.println(dp[N-1][M-1]);

	}
	

}
