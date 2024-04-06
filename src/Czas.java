import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Czas {
    private static final String fileName = "liczby.txt";
    private static FileWriter writer = null;
    BufferedReader br = null;
    // Wstaw nazwę swojego pliku
    static long start_time = System.currentTimeMillis();
    static long end_time = System.currentTimeMillis();
    static int exc_time = 0;
    ArrayList<Integer> timers = new ArrayList<>();


    public Czas(Tablica tablica, ListaJednokierunkowa listaJednokierunkowa, ListaDwukierunkowa listaDwukierunkowa) throws IOException {
        array(tablica);
        sigledlist(listaJednokierunkowa);
        doublyLinkedList(listaDwukierunkowa);
    }

    public static void savetoFile(ArrayList<Integer> timers, String operation){
        String fileName = operation; // Nazwa pliku CSV
        try{
            writer = new FileWriter(fileName);
            // Zapisujemy dane do pliku CSV
            for(Object o : timers){
                writer.append(String.format("%s \n", o));
            }

            System.out.println("Pomyślnie zapisano dane do pliku CSV.");
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania do pliku CSV: " + e.getMessage());
        }
        finally {
            try {
                writer.close();
            }
            catch (IOException e) {
                System.err.println("Błąd zamykania pliku: " + e.getMessage());
            }
        }
    }


    private void array(Tablica tablica){
        timers.clear();
        try{
            br = new BufferedReader(new FileReader(fileName));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                start_time = System.nanoTime();
                tablica.addElement(i, Integer.parseInt(line));
                end_time = System.nanoTime();
                exc_time = (int)(end_time-start_time);
                timers.add(exc_time);
                //System.out.println("\nCzas operacji: "+exc_time+" ms");

                i++;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "ArrayData.csv");
    }

    private void sigledlist(ListaJednokierunkowa listaJednokierunkowa){
        timers.clear();
        try{
            br = new BufferedReader(new FileReader(fileName));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                start_time = System.nanoTime();
                listaJednokierunkowa.addElement(i, Integer.parseInt(line));
                end_time = System.nanoTime();
                exc_time = (int)(end_time-start_time);
                timers.add(exc_time);
                //System.out.println("\nCzas operacji: "+exc_time+" ms");

                i++;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "SingledListData.csv");
    }

    private void doublyLinkedList(ListaDwukierunkowa listaDwukierunkowa){
        timers.clear();
        try{
            br = new BufferedReader(new FileReader(fileName));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                start_time = System.nanoTime();
                listaDwukierunkowa.add(i, Integer.parseInt(line));
                end_time = System.nanoTime();
                exc_time = (int)(end_time-start_time);
                timers.add(exc_time);
                //System.out.println("\nCzas operacji: "+exc_time+" ms");

                i++;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "doubleLinkedListData.csv");
    }
}
