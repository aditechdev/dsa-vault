import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100); // 0 to 99
        System.out.println("Random generated number (0-99): " + randomNumber);
    }
}
