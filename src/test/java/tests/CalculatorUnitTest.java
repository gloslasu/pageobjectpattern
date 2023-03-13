package tests;

public class CalculatorUnitTest {


    // dodawanie: metoda sum która będzie nam zwracała inta i na wejściu przyjmuje dwa inty
    // nasze metody muszą być statyczne żeby używać ich w statycznym mainie
    public static int sum(int a, int b) {
        int c = a + b;
        return c; // na koniec zwraca nam c
    }
    // odejmowanie:
    public static int subtract(int a, int b) {
        int c = a - b;
        return c;
    }
    // dzielenie
    public static int divide(int a, int b) {
        int c = a / b;
        return c;
    }
    // mnożenie
    public static int multiply(int a, int b) {
        int c = a * b;
        return c;
    }


    public static void main(String[] args) {
        System.out.println(sum(1,2));       // 1+2=3
        System.out.println(subtract(8,4));  // 8/4=2
        System.out.println(divide(30,6));   // 30/6=5
        System.out.println(multiply(5,5));  // 5*5=25
    }


}

