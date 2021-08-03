
//dfs�� ������ �� ���� Ž��. N/2����� �� ��, visited=true�� ���� visited=false�� �� ���� ������ ����
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
		int start = 0; // start���� �ɷ�ġ
		int link = 0; // link���� �ɷ�ġ

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
