package testJava;

public class Test {
    public static void main(String[] args) {
        String s = "$1,350";

        float f = Float.valueOf(s).floatValue();
        // Integer.parseInt()s

        System.out.println(f);
    }
}
