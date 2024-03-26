import java.util.ArrayList;
import java.util.List;

public class Czas {
    // Metoda do pomiaru czasu wykonania innej metody
    public static long measureExecutionTime(Runnable methodToMeasure) {
        long startTime = System.nanoTime();

        // Wywołanie metody do pomiaru
        methodToMeasure.run();

        long endTime = System.nanoTime();

        // Obliczenie czasu trwania w nanosekundach
        return endTime - startTime;
    }

    // Przykładowa metoda, którą chcemy zmierzyć
    public static void exampleMethod() {
        Tablica tab = new Tablica();

        // Tutaj umieść kod, który chcesz zmierzyć czas wykonania
        for (int i = 0; i < 100; i++) {
            // Przykładowe operacje
            tab.addElement(i,i);
        }
    }

    public static void exampleMethod2() {
        int[] test = new int[100];

        // Tutaj umieść kod, który chcesz zmierzyć czas wykonania
        for (int i = 0; i < 100; i++) {
            // Przykładowe operacje
            test[i]=i;
        }
    }


    public static void exampleMethod3() {
        ListaJednokierunkowa l = new ListaJednokierunkowa();

        // Tutaj umieść kod, który chcesz zmierzyć czas wykonania
        for (int i = 0; i < 100; i++) {
            // Przykładowe operacje
            l.addElement(i);
        }
    }

    public static void exampleMethod4() {
        List<Integer> l = new ArrayList<>();

        // Tutaj umieść kod, który chcesz zmierzyć czas wykonania
        for (int i = 0; i < 100; i++) {
            // Przykładowe operacje
            l.add(i);
        }
    }
}
