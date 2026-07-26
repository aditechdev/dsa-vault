package basic.problems;

public class LittlePonyProblem {
    /*
     * Little Pony Mobile Phone Buying Problem:
     * Given an array A of size N denoting prices of mobile models sorted in increasing order.
     * Given an array B of size Q denoting queries where B[i] is available money.
     * For each query, return the maximum distinct mobile phone models buyable with B[i] money.
     */
    public static int maxModelsBuyable(int[] prices, int money) {
        int count = 0;
        int sum = 0;
        for (int price : prices) {
            if (sum + price <= money) {
                sum += price;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 5, 10, 20};
        int money = 8;
        System.out.println("Maximum distinct models buyable with $" + money + ": " + maxModelsBuyable(prices, money));
    }
}
