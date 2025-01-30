import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc;
        Exception e = new Exception();
        System.out.println(e.getClass());
        System.out.println(Exception.class.getSuperclass());
        System.out.println(Throwable.class.getSuperclass());
        System.out.println(Object.class.getSuperclass());
        System.out.println(Exception.class.getModule());
        Orario ora = new Orario(-2, 60, 5);
    }
}