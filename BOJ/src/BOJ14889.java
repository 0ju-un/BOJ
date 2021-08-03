
//dfs로 가능한 팀 구성 탐색. N/2명까지 고른 후, visited=true인 팀과 visited=false인 팀 사이 점수차 구함
import java.util.Scanner;

public class BOJ14889 {
	static int N;
	static int[][] S;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N];
		S = new int[N][N];
		/* input */
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				S[i][j] = sc.nextInt();
		
		solve(0,0);
		System.out.println(result);

	}

	public static void solve(int idx, int num) {
		if (num == N / 2) {
			getResult();
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				solve(i + 1, num + 1);
				visited[i] = false;
			}
		}
	}

	public static void getResult() {
		int start = 0; // start팀의 능력치
		int link = 0; // link팀의 능력치

		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if (visited[i] && visited[j])
					start += S[i][j] + S[j][i];
				else if (!visited[i] && !visited[j])
					link += S[i][j] + S[j][i];
			}
		}

		int s = Math.abs(start - link);

		result = (s < result ? s : result);
	}

}
