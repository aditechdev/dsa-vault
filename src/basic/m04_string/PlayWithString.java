package basic.string;

public class PlayWithString {

    static void findAllUsingWhileLoop(String paragraph, String word) {
        int index = paragraph.indexOf(word);
        while (index != -1) {
            System.out.println("Found at index: " + index);
            index = paragraph.indexOf(word, index + 1);
        }
    }

    static void findAllUsingForLoop(String para, String word) {
        int index = para.indexOf(word);
        for (int i = index; i != -1; i = index) {
            System.out.println("Found at index: " + index);
            index = para.indexOf(word, index + 1);
        }
    }

    public static void main(String[] args) {
        String para = "We are learning Java. Java is an awesome language. Lets have fun with Java!";
        String word = "Java";

        System.out.println("--- Search using For Loop ---");
        findAllUsingForLoop(para, word);

        System.out.println("--- Search using While Loop ---");
        findAllUsingWhileLoop(para, word);
    }
}
