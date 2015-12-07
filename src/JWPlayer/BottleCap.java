package JWPlayer;
import java.util.Scanner;
public class BottleCap {
public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
		int count = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < count; i++) {
			String input = scanner.nextLine();
			String[] array = input.split("\\s+");
			int cash = Integer.valueOf(array[0]);
			int cost = Integer.valueOf(array[1]);
			int caps = Integer.valueOf(array[2]);
			int beersFromCash = cash / cost;
			int total = beersFromCash + calculateFreeBeers(beersFromCash, caps);
			System.out.println(total);
		}
}
    
    private static int calculateFreeBeers(int boughtBeers, int exchangeOffer) {
		if (boughtBeers < exchangeOffer) return 0;
		int extra = boughtBeers / exchangeOffer;
		int remaining = boughtBeers % exchangeOffer;
		return extra + calculateFreeBeers(extra + remaining, exchangeOffer);
	}
}

/**
 * select e1.name, e2.name from Employees e1, Employees e2 where e1.salary < e2.salary order by e1.id, e2.id;
 */
