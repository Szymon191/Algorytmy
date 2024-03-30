import java.util.ArrayList;
import java.util.Arrays;

public class Tablica {
    private int[] array;
    private int size;

    public Tablica() {
        array = new int[0];
        size = 0;
    }
    public Tablica(int rozmair) {
        array = new int[rozmair];
        size = 0;
    }
    public void addElement(int index, int value) {
        // Implementacja dodawania elementu do tablicy na podanym indeksie

        if (index < 0 || index > size) {
            System.out.println("Nieprawidłowy indeks.");
            return;
        }

        if (size == array.length) {
            // Zwiększanie rozmiaru tablicy
            int[] newArray = new int[array.length + 1];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

        // Przesunięcie elementów w tablicy
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = value;
        size++;
    }
    public void wyswietl(){
        //System.out.println(Arrays.toString(array));
        for(int i = 0; i < array.length;i++){
            System.out.print(array[i]+",");
        }
    }

    public void removeElement(int value) {
        // Implementacja usuwania elementu z tablicy po wartości
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                index = i;
                break;
            }
        }
        //System.out.println(index);

        if (index != -1) {
            // Przesunięcie elementów w lewo
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            // Zmniejszenie rozmiaru tablicy
            size--;
            int[] newArray = new int[array.length - 1];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;


        } else {
            System.out.println("Element nie istnieje w tablicy.");
        }
    }

    public boolean search(int value){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                index = i;
                if(index>-1){
                    return true;

                }
                break;
            }
        }
        return false;
    }

    // Pozostałe operacje na tablicy

    // Metody pomiaru czasu operacji

    // Metody analizy statystycznej

    // Metoda równoważenia drzewa BST

}
