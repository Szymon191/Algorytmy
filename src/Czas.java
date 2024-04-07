import java.io.*;
import java.util.ArrayList;

public class Czas {
    private static final String fileName = "liczby.txt";
    private static FileWriter writer = null;
    BufferedReader br = null;
    static long start_time = System.currentTimeMillis();
    static long end_time = System.currentTimeMillis();
    static double exc_time = 0;
    ArrayList<String> timers = new ArrayList<>();


    public Czas(Tablica tablica, ListaJednokierunkowa listaJednokierunkowa, ListaDwukierunkowa listaDwukierunkowa){
        arrayEnd(tablica);
        arrayStart(tablica);
        arrayMiddle(tablica);
        sigledlistEnd(listaJednokierunkowa);
        sigledlistStart(listaJednokierunkowa);
        sigledlistMiddle(listaJednokierunkowa);
        doublyLinkedListEnd(listaDwukierunkowa);
        doublyLinkedListStart(listaDwukierunkowa);
        doublyLinkedListMiddle(listaDwukierunkowa);
    }

        public static void savetoFile(ArrayList<String> timers, String operation){
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


    private void arrayEnd(Tablica tablica){
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
                System.out.println(end_time + " " + start_time + " " + exc_time);
                exc_time = exc_time / 1000000;
                timers.add(String.format("%2f", exc_time));
                //System.out.println("\nCzas operacji: "+exc_time+" ms");
                i++;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "ArrayDataEnd.csv");
    }

    private void arrayMiddle(Tablica tablica){
        timers.clear();
        try{
            br = new BufferedReader(new FileReader(fileName));
            String line;
            int i =0;
            while ((line = br.readLine()) != null) {
                i = tablica.lenght() / 2;
                start_time = System.nanoTime();
                tablica.addElement(i, Integer.parseInt(line));
                end_time = System.nanoTime();
                exc_time = (int)(end_time-start_time);
                exc_time = exc_time / 1000000;
                timers.add(String.format("%2f", exc_time));
                //System.out.println("\n" + i + "Czas operacji: "+exc_time+" ms" + "-" + Integer.parseInt(line));
                //System.out.println(i);
                //i++;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "ArrayDataMiddle.csv");
        //tablica.wyswietl();
    }

    private void arrayStart(Tablica tablica){
        timers.clear();
        try{
            br = new BufferedReader(new FileReader(fileName));
            String line;
            int i =0;
            while ((line = br.readLine()) != null) {
                start_time = System.nanoTime();
                tablica.addElement(i, Integer.parseInt(line));
                end_time = System.nanoTime();
                exc_time = (int)(end_time-start_time);
                exc_time = exc_time / 1000000;
                timers.add(String.format("%2f", exc_time));
                //System.out.println("\n" + i + "Czas operacji: "+exc_time+" ms" + "-" + Integer.parseInt(line));
                //System.out.println(i);
                //i--;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "ArrayDataStart.csv");
        //tablica.wyswietl();
    }

    private void sigledlistStart(ListaJednokierunkowa listaJednokierunkowa){
        timers.clear();
        try{
            br = new BufferedReader(new FileReader(fileName));
            String line;
            int i =0;
            while ((line = br.readLine()) != null) {
                start_time = System.nanoTime();
                listaJednokierunkowa.addElement(i, Integer.parseInt(line));
                end_time = System.nanoTime();
                exc_time = (int)(end_time-start_time);
                exc_time = exc_time / 1000000;
                timers.add(String.format("%2f", exc_time));
                //System.out.println("\n" + i + "Czas operacji: "+exc_time+" ms" + "-" + Integer.parseInt(line));
                //System.out.println(i);
                //i--;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "sigledlistStartData.csv");
        //tablica.wyswietl();
    }

    private void sigledlistMiddle(ListaJednokierunkowa listaJednokierunkowa){
        timers.clear();
        try{
            br = new BufferedReader(new FileReader(fileName));
            String line;
            int i =0;
            while ((line = br.readLine()) != null) {
                i = listaJednokierunkowa.length() / 2;
                start_time = System.nanoTime();
                listaJednokierunkowa.addElement(i, Integer.parseInt(line));
                end_time = System.nanoTime();
                exc_time = (int)(end_time-start_time);
                exc_time = exc_time / 1000000;
                timers.add(String.format("%2f", exc_time));
                //System.out.println("\n" + i + "Czas operacji: "+exc_time+" ms" + "-" + Integer.parseInt(line));
                //System.out.println(i);
                //i++;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "sigledlistMiddleData.csv");
        //tablica.wyswietl();
    }

    private void sigledlistEnd(ListaJednokierunkowa listaJednokierunkowa){
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
                System.out.println(exc_time);
                exc_time = exc_time / 1000000;
                System.out.println(exc_time);
                timers.add(String.format("%2f", exc_time));
                //System.out.println("\nCzas operacji: "+exc_time+" ms");

                i++;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "SingledListDataEnd.csv");
    }

    private void doublyLinkedListEnd(ListaDwukierunkowa listaDwukierunkowa){
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
                exc_time = exc_time / 1000000;
                timers.add(String.format("%2f", exc_time));
                //System.out.println("\nCzas operacji: "+exc_time+" ms");

                i++;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "doublyLinkedListEndData.csv");
    }

    private void doublyLinkedListMiddle(ListaDwukierunkowa listaDwukierunkowa){
        timers.clear();
        try{
            br = new BufferedReader(new FileReader(fileName));
            String line;
            int i =0;
            while ((line = br.readLine()) != null) {
                i = listaDwukierunkowa.length() / 2;
                start_time = System.nanoTime();
                listaDwukierunkowa.add(i, Integer.parseInt(line));
                end_time = System.nanoTime();
                exc_time = (int)(end_time-start_time);
                exc_time = exc_time / 1000000;
                timers.add(String.format("%2f", exc_time));
                //System.out.println("\n" + i + "Czas operacji: "+exc_time+" ms" + "-" + Integer.parseInt(line));
                //System.out.println(i);
                //i++;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "doublyLinkedListMiddleData.csv");
        //tablica.wyswietl();
    }

    private void doublyLinkedListStart(ListaDwukierunkowa listaDwukierunkowa){
        timers.clear();
        try{
            br = new BufferedReader(new FileReader(fileName));
            String line;
            int i =0;
            while ((line = br.readLine()) != null) {
                start_time = System.nanoTime();
                listaDwukierunkowa.add(i, Integer.parseInt(line));
                end_time = System.nanoTime();
                exc_time = (int)(end_time-start_time);
                exc_time = exc_time / 1000000;
                timers.add(String.format("%2f", exc_time));
                //System.out.println("\n" + i + "Czas operacji: "+exc_time+" ms" + "-" + Integer.parseInt(line));
                //System.out.println(i);
                //i--;
            }
        }catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        savetoFile(timers, "doublyLinkedListStartData.csv");
        //tablica.wyswietl();
    }
}
