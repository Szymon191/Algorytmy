import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // rzeczy do tablicy

        // Inicjalizacja struktur danych
        Tablica tablica = new Tablica();
        //ListaJednokierunkowa listaJednokierunkowa = new ListaJednokierunkowa();
        //BST bst = new BST();
        tablica.addElement(0,4);
        tablica.addElement(1,5);
        //tablica.addElement(7,1);
        tablica.addElement(2,9);
        Tablica tab2 = new Tablica(5);
        tab2.addElement(0,1);
        tab2.addElement(1,2);
        tab2.addElement(2,3);
        tab2.addElement(3,4);
        tablica.wyswietl();

        //tablica.wyswietl();
//        long executionTime = Czas.measureExecutionTime(Czas::exampleMethod);
//        System.out.println("Czas wykonania metody exampleMethod: " + executionTime + " nanosekund.");
//
//        long executionTime2 = Czas.measureExecutionTime(Czas::exampleMethod2);
//        System.out.println("Czas wykonania metody exampleMethod2: " + executionTime2 + " nanosekund.");

        //tablica.removeElement(5);
        //tablica.wyswietl();

        tablica.search(9);



        // rzeczy do listy jendokierunkowej
        ListaJednokierunkowa lista = new ListaJednokierunkowa();
        lista.addElement(5);
        lista.addElement(6);
        lista.addElement(1);
        lista.addElement(7);
        lista.addElement(312);
        lista.removeElement(6);
        System.out.println(lista.search(32));
        lista.displayList();
//        long executionTime = Czas.measureExecutionTime(Czas::exampleMethod3);
//        System.out.println("Czas wykonania metody exampleMethod: " + executionTime + " nanosekund.");
//        long executionTime2 = Czas.measureExecutionTime(Czas::exampleMethod4);
//        System.out.println("Czas wykonania metody exampleMethod: " + executionTime2 + " nanosekund.");





        // Menu programu
//        int choice;
//        do {
//            System.out.println("1. Dodaj do tablicy, listy i drzewa");
//            System.out.println("2. Usuń z tablicy i listy");
//            System.out.println("3. Usuń z drzewa");
//            System.out.println("4. Wyszukaj");
//            System.out.println("5. Wyświetl struktury");
//            System.out.println("6. Wykonaj pomiar czasu");
//            System.out.println("7. Wyjście");
//            System.out.print("Wybierz opcję: ");
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    // Implementacja dodawania do tablicy, listy i drzewa
//                    break;
//                case 2:
//                    // Implementacja usuwania z tablicy i listy
//                    break;
//                case 3:
//                    // Implementacja usuwania z drzewa
//                    break;
//                case 4:
//                    // Implementacja wyszukiwania
//                    break;
//                case 5:
//                    // Implementacja wyświetlania struktur
//                    break;
//                case 6:
//                    // Implementacja pomiaru czasu
//                    break;
//                case 7:
//                    System.out.println("Koniec programu.");
//                    break;
//                default:
//                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
//            }
//
//        } while (choice != 7);

        scanner.close();
    }
}