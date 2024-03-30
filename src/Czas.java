import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Czas {
    private static String fileName = "liczby.txt"; // Wstaw nazwę swojego pliku

    // Metoda do pomiaru czasu wykonania innej metody
    public static long measureExecutionTime(Runnable methodToMeasure) {
        long startTime = System.nanoTime();

        // Wywołanie metody do pomiaru
        methodToMeasure.run();

        long endTime = System.nanoTime();

        // Obliczenie czasu trwania w nanosekundach
        return endTime - startTime;
    }


    //tablice
    // Przykładowa metoda, którą chcemy zmierzyć
    class Array {
        public static Tablica tab = new Tablica();
        public static void exampleMethod() {
            // Tutaj umieść kod, który chcesz zmierzyć czas wykonania
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                int i = 0;
                while ((line = br.readLine()) != null) {
                    tab.addElement(i, Integer.parseInt(line));
                    i++;
                }
            } catch (IOException e) {
                System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
            }
        }

        public static void exampleMethod2() {
            int[] test = new int[100000];
            // Tutaj umieść kod, który chcesz zmierzyć czas wykonania
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                int i = 0;
                while ((line = br.readLine()) != null) {
                    test[i] = Integer.parseInt(line);
                    i++;
                }
            } catch (IOException e) {
                System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
            }
        }

        public static void usuwanie(){
            tab.removeElement(10000);
        }

        public static void szukanie(){
            System.out.println(tab.search(6));
        }

    }


    class SigleLinkedList{
        public static ListaJednokierunkowa l = new ListaJednokierunkowa();
        public static void exampleMethod3() {
            // Tutaj umieść kod, który chcesz zmierzyć czas wykonania
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                int i = 0;
                while ((line = br.readLine()) != null) {
                    l.addElement(i,Integer.parseInt(line));
                    //i++;
                }
            } catch (IOException e) {
                System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
            }
        }

        public static void exampleMethod4() {
            List<Integer> l = new ArrayList<>();

            // Tutaj umieść kod, który chcesz zmierzyć czas wykonania
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                //int i = 0;
                while ((line = br.readLine()) != null) {
                    l.add(Integer.parseInt(line));
                    //i++;
                }
            } catch (IOException e) {
                System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
            }
        }

        public static void usuwanie(){
            l.removeElement(10000);
        }

        public static void szukanie(){
            System.out.println(l.search(66356452));
        }

    }



}
