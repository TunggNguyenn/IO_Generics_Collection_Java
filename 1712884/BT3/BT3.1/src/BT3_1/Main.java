package BT3_1;


import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        integerArrayList.add(1);
        integerArrayList.add(3);
        integerArrayList.add(5);
        integerArrayList.add(8);
        integerArrayList.add(1);
        integerArrayList.add(2);

        System.out.println("Before sorting: " + integerArrayList.toString());
        Collections.sort(integerArrayList);
        System.out.println("After sorting: " + integerArrayList.toString());

    }
}
