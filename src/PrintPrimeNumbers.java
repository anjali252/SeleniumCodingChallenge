
public class PrintPrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int terms = 100, flag = 0;
		for (int i = 1; i <= terms; i++) {
			flag = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					flag += 1;
			}
			if (flag == 0)
				System.out.println(i);

		}
	}

}
