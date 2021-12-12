
public class IsPrimeNumber {

	public static void main(String[] args) {
		int n = 13, c = 0;
		if (n == 0 || n == 1)
			System.out.println(n + " is NOT a Prime Number");
		else {
			for (int i = 2; i <= n / 2; i++) {
				if (n % i != 0)
					c = 1;
				else
					c = 0;
			}
		}
		if (c == 0)
			System.out.println(n + " is NOT a Prime Number");
		else
			System.out.println(n + " is a Prime Number");
	}

}
