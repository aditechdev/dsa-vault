package basic.string;

public class StringDemo {
    public static void main(String[] args) {
        String greetings = "HelloHello";
        System.out.println("String: " + greetings);
        
        for (int i = 0; i < greetings.length(); i++) {
            System.out.println("Char at index " + i + ": " + greetings.charAt(i));
        }

        // String Constant Pool vs New Object Comparison
        String name = "Aditya";
        String myName = "Aditya";
        String myNameShort = "aditya";

        System.out.println("Compare 'Aditya' == 'Aditya': " + (name == myName));
        System.out.println("Compare 'Aditya'.equals('Aditya'): " + (name.equals(myName)));

        System.out.println("Compare 'Aditya' == 'aditya': " + (name == myNameShort));
        System.out.println("Compare 'Aditya'.equals('aditya'): " + (name.equals(myNameShort)));

        String x = new String("Hi");
        String y = new String("Hi");
        System.out.println("New String object '==': " + (x == y)); // false (different references)
        System.out.println("New String object '.equals': " + (x.equals(y))); // true (same content)
    }
}
