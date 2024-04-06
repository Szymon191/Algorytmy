import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String fileName = "liczby.txt"; // Nazwa pliku, do którego chcesz zapisać liczby
    static long start_time = System.nanoTime();
    static long end_time = System.nanoTime();
    static int exc_time = 0;

    public static void testData(int size){
        Random random = new Random();
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 1; i <= size; i++) {
                int randomNumber = random.nextInt(1000);
                writer.write(randomNumber + "\n");
            }
            System.out.println("Pomyślnie zapisano " + size + " liczb do pliku.");
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania do pliku: " + e.getMessage());
        }
    }

    public static void StructureMenu(boolean isDoubleLinkedList){
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("1. Dodawanie");
        System.out.println("2. Dodaj dane z pliku");
        System.out.println("3. Usuwanie");
        System.out.println("4. Szukanie");

        if (isDoubleLinkedList) {
            System.out.println("5. Usuń pierwszy element");
            System.out.println("6. Usuń ostatni element");
            System.out.println("7. Cofnij się do menu głownego");
        } else {
            System.out.println("5. Cofnij się do menu głownego");
        }


        System.out.print("Wybierz opcje: ");
    }

    public static void MainMenu(){
        System.out.println();
        System.out.println("===========================");
        System.out.println("1. Tablica");
        System.out.println("2. Lista Jednokierunkowa");
        System.out.println("3. Lista Dwukierunkowa");
        System.out.println("4. Zamknij program");
        System.out.print("Wybierz opcje: ");
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int choiceStructure;
        int choice;

        Tablica tablica = new Tablica();
        ListaJednokierunkowa listaJednokierunkowa = new ListaJednokierunkowa();
        ListaDwukierunkowa listaDwukierunkowa = new ListaDwukierunkowa();
        testData(1000);
        Czas czas = new Czas(tablica,listaJednokierunkowa, listaDwukierunkowa);
        do {
            MainMenu();
            choiceStructure = scanner.nextInt();

            switch (choiceStructure) {
                case 1 -> {
                    StructureMenu(false);
                    choice = scanner.nextInt();
                    int index;
                    int value;

                    if (choice == 1){

                        System.out.print("Podaj index: ");
                        index = scanner.nextInt();

                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();
                        start_time = System.nanoTime();
                        tablica.addElement(index, value);
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");


                    } else if (choice == 2) {
                        start_time = System.nanoTime();
                        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                            String line;
                            int i = 0;
                            while ((line = br.readLine()) != null) {
                                tablica.addElement(i, Integer.parseInt(line));
                                i++;
                            }
                        } catch (IOException e) {
                            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
                        }
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");

                    } else if (choice == 3) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        start_time = System.nanoTime();
                        tablica.removeElement(value);
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");

                    } else if (choice == 4) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        start_time = System.nanoTime();
                        if (tablica.search(value)){
                            System.out.println("Element " + value + " znajduje się w tablicy");
                        } else {
                            System.out.println("Element " + value + " nie znajduje się w tablicy");
                        }
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");
                    }

                    System.out.println();
                    System.out.print("Obecny stan tablicy: ");
                    tablica.wyswietl();
                }

                case 2 -> {
                    StructureMenu(false);
                    choice = scanner.nextInt();
                    int index;
                    int value;

                    if (choice == 1){
                        System.out.print("Podaj index: ");
                        index = scanner.nextInt();

                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();
                        start_time = System.nanoTime();
                        listaJednokierunkowa.addElement(index, value);
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");

                    } else if (choice == 2) {
                        start_time = System.nanoTime();
                        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                            String line;
                            int i = 0;
                            while ((line = br.readLine()) != null) {
                                listaJednokierunkowa.addElement(i,Integer.parseInt(line));
                                i++;
                            }
                        } catch (IOException e) {
                            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
                        }
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");

                    } else if (choice == 3) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        start_time = System.nanoTime();
                        listaJednokierunkowa.removeElement(value);
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");

                    } else if (choice == 4) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();
                        start_time = System.nanoTime();
                        if (listaJednokierunkowa.search(value)){
                            System.out.println("Element " + value + " znajduje się w tablicy");
                        } else {
                            System.out.println("Element " + value + " nie znajduje się w tablicy");
                        }
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");
                    }

                    System.out.println(" ");
                    System.out.print("Obecny stan listy jednokierunkowej: ");
                    listaJednokierunkowa.displayList();
                }

                case 3 -> {
                    StructureMenu(true);
                    choice = scanner.nextInt();
                    int index;
                    int value;

                    if (choice == 1){
                        System.out.print("Podaj index: ");
                        index = scanner.nextInt();

                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        start_time = System.nanoTime();
                        listaDwukierunkowa.add(index, value);
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");

                    } else if (choice == 2) {
                        start_time = System.nanoTime();
                        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                            String line;
                            int i = 0;
                            while ((line = br.readLine()) != null) {
                                listaDwukierunkowa.add(i,Integer.parseInt(line));
                                i++;
                            }
                        } catch (IOException e) {
                            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
                        }
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");
                    } else if (choice == 3) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        start_time = System.nanoTime();
                        listaDwukierunkowa.remove(value);
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");
                    } else if (choice == 4) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        start_time = System.nanoTime();
                        if (listaDwukierunkowa.search(value)){
                            System.out.println("Element " + value + " znajduje się w tablicy");
                        } else {
                            System.out.println("Element " + value + " nie znajduje się w tablicy");
                        }
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");
                    } else if(choice == 5){
                        start_time = System.nanoTime();
                        listaDwukierunkowa.removeFromBeginning();
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");
                    } else if (choice == 6) {
                        start_time = System.nanoTime();
                        listaDwukierunkowa.removeFromEnd();
                        end_time = System.nanoTime();
                        exc_time = (int)(end_time-start_time);
                        System.out.println("\nCzas operacji: "+exc_time+" nanosekund");
                    }

                    System.out.println();
                    System.out.print("Obecny stan listy dwukierunkowej: ");
                    listaDwukierunkowa.display();
                }
            }
        } while (choiceStructure != 4);

        scanner.close();

    }
}