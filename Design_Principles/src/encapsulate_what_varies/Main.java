package encapsulate_what_varies;

import java.lang.Thread;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("---- Chose You Pitzza ----");
        System.out.print("--> ");
        String type = scanner.next();
        Pitzza pitzza = Pitzza.oreder(type);
        System.out.println(pitzza);
    }
}

class Pitzza {
    protected static String titel = "Pizza";
    protected static float price = 10;

    private static void prepare() {

        try {
            System.out.print("Preparing ...");
            Thread.sleep(500);
            System.out.println(" Completed !!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void cook() {

        try {
            System.out.print("Cooking ...");
            Thread.sleep(500);
            System.out.println(" Completed !!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void cut() {

        try {
            System.out.print("Cutting and Boxing ...");
            Thread.sleep(500);
            System.out.println(" Completed !!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Pitzza check(String type) {
        Pitzza pitzza;

        if (type.equalsIgnoreCase("CHEESE"))
        {
            pitzza = new Cheese();
        }
        else
        {
            pitzza = new Chiken();
        }
        return pitzza;
    }

    public static Pitzza oreder(String type) {
        Pitzza pitzza = check(type);

        prepare();

        cook();

        cut();

        return pitzza;
    }

    @Override
    public String toString() {
        return "\n" + titel
                + "\nPrice : " + price;
    }
}

class Cheese extends Pitzza {
    public String titel = Pitzza.titel + " Cheese";
    public float price = 100;

    @Override
    public String toString() {
        return "\n" + titel
               + "\nPrice : " + price;
    }
}

class Chiken extends Pitzza {
    public String titel = Pitzza.titel + " Chiken";
    public float price = 150;

    @Override
    public String toString() {
        return "\n" + titel
               + "\nPrice : " + price;
    }
}


