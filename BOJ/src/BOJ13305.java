/* ¡÷¿Øº“  */
import java.util.Scanner;

public class BOJ13305 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] fuel = new long[N];
		long[] distance = new long[N-1];
		long min, price;
		
		for(int i = 0; i<N-1; i++)
			distance[i] = sc.nextInt();
		for(int i=0; i<N; i++)
			fuel[i] = sc.nextInt();
		
		min = fuel[0];
		price = fuel[0] * distance[0];
		
		for(int i=1; i<N-1; i++) {
			if(min > fuel[i])
				min = fuel[i];
			price += min * distance[i];
		}
		
		System.out.println(price);
	}

}
