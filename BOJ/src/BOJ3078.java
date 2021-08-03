/* 시간초과  */
import java.util.Scanner;

public class BOJ3078 {
	static int N, k, result=0;
	static int[] names;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		k = sc.nextInt();
		visited = new boolean[N+1];
		names = new int[N+1];
		/*input*/
		for(int i=1 ;i<=N; i++)
			names[i] = sc.next().length();
		solve(1, 0);
		System.out.println(result);
	}
	
	static void solve(int idx, int n) {
		if (n==2) {
			isItGood();
			return;
		}
		for(int i=idx; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				solve(i+1,n+1);
				visited[i] = false;
			}
		}
	}
	
	static void isItGood() {
		for(int i=1 ;i<N; i++) {
			for(int j=i+1 ;j<=N; j++) {
				if(visited[i] && visited[j]) {
					if((j-i)<=k && names[i] == names[j]) {
						result ++;
						return;
					}
				}
			}
		}
	}
}
