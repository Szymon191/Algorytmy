import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void StructureMenu(boolean isDoubleLinkedList){
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("1. Dodawanie");
        System.out.println("2. Usuwanie");
        System.out.println("3. Szukanie");

        if (isDoubleLinkedList) {
            System.out.println("4. Usuń pierwszy element");
            System.out.println("5. Usuń ostatni element");
            System.out.println("6. Cofnij się do menu głownego");
        } else {
            System.out.println("4. Cofnij się do menu głownego");
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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choiceStructure;
        int choice;

        Tablica tablica = new Tablica();
        ListaJednokierunkowa listaJednokierunkowa = new ListaJednokierunkowa();
        ListaDwukierunkowa listaDwukierunkowa = new ListaDwukierunkowa();


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

                        tablica.addElement(index, value);
                    } else if (choice == 2) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        tablica.removeElement(value);
                    } else if (choice == 3) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        if (tablica.search(value)){
                            System.out.println("Element " + value + " znajduje się w tablicy");
                        } else {
                            System.out.println("Element " + value + " nie znajduje się w tablicy");
                        }
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

                        listaJednokierunkowa.addElement(value, index);
                    } else if (choice == 2) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        listaJednokierunkowa.removeElement(value);
                    } else if (choice == 3) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        if (listaJednokierunkowa.search(value)){
                            System.out.println("Element " + value + " znajduje się w tablicy");
                        } else {
                            System.out.println("Element " + value + " nie znajduje się w tablicy");
                        }
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

                        listaDwukierunkowa.add(index, value);
                    } else if (choice == 2) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        listaDwukierunkowa.remove(value);
                    } else if (choice == 3) {
                        System.out.print("Podaj wartosc: ");
                        value = scanner.nextInt();

                        if (listaDwukierunkowa.search(value)){
                            System.out.println("Element " + value + " znajduje się w tablicy");
                        } else {
                            System.out.println("Element " + value + " nie znajduje się w tablicy");
                        }
                    } else if(choice == 4){
                        listaDwukierunkowa.removeFromBeginning();
                    } else if (choice == 5) {
                        listaDwukierunkowa.removeFromEnd();
                    }

                    System.out.println();
                    System.out.print("Obecny stan listy dwukierunkowej: ");
                    listaDwukierunkowa.display();
                }
            }
        } while (choiceStructure != 4);

        scanner.close();

//        long executionTime = Czas.measureExecutionTime(Czas::exampleMethod);
//        System.out.println("Czas wykonania metody exampleMethod: " + executionTime + " nanosekund.");
//
//        long executionTime2 = Czas.measureExecutionTime(Czas::exampleMethod2);
//        System.out.println("Czas wykonania metody exampleMethod2: " + executionTime2 + " nanosekund.");

    }
}