package BT3_2;

import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>();

        stringLinkedList.add("Apple");
        stringLinkedList.add("Orange");
        stringLinkedList.add("Banana");
        stringLinkedList.add("Mandarine");

        System.out.println("Before swaping: " + stringLinkedList.toString());
        Collections.swap(stringLinkedList, 0 ,2);
        System.out.println("After swaping: " + stringLinkedList.toString());
    }
}
