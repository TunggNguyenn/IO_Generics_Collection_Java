package BT2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Fraction
        ArrayList<Fraction> fractionArrayList = new ArrayList<>();
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(45,2);
        Fraction f3 = new Fraction(12,4);
        Fraction f4 = new Fraction(7,4);
        Fraction f5 = new Fraction(25,3);

        fractionArrayList.add(f1);
        fractionArrayList.add(f2);
        fractionArrayList.add(f3);
        fractionArrayList.add(f4);
        fractionArrayList.add(f5);

        Generic<Fraction> fractionGeneric = new Generic<>(fractionArrayList);
        Fraction fractionMax = fractionGeneric.max();
        System.out.println("The max number of the fractionArrayList: " + fractionMax.toString());

        //Float
        ArrayList<MyFloat> floatArrayList = new ArrayList<>();

        MyFloat mf1 = new MyFloat((float) 4.5);
        MyFloat mf2 = new MyFloat((float) 3.2);
        MyFloat mf3 = new MyFloat((float) 35.123);
        MyFloat mf4 = new MyFloat((float) 43.12);
        MyFloat mf5 = new MyFloat((float) 12.34);

        floatArrayList.add(mf1);
        floatArrayList.add(mf2);
        floatArrayList.add(mf3);
        floatArrayList.add(mf4);
        floatArrayList.add(mf5);

        Generic<MyFloat> floatGeneric = new Generic<>(floatArrayList);
        MyFloat floatMax = floatGeneric.max();
        System.out.println("The max number of the floatArrayList: " + floatMax);

        //MyString
        ArrayList<MyString> stringArrayList = new ArrayList<>();

        MyString ms1 = new MyString("Lap");
        MyString ms2 = new MyString("Trinh");
        MyString ms3 = new MyString("Ung");
        MyString ms4 = new MyString("Dung");
        MyString ms5 = new MyString("Java");

        stringArrayList.add(ms1);
        stringArrayList.add(ms2);
        stringArrayList.add(ms3);
        stringArrayList.add(ms4);
        stringArrayList.add(ms5);

        Generic<MyString> stringGeneric = new Generic<>(stringArrayList);
        MyString stringMax = stringGeneric.max();
        System.out.println("The max number of the stringGeneric: " + stringMax);

        //MyComplexNumber
        ArrayList<MyComplexNumber> complexNumberArrayList = new ArrayList<>();

        MyComplexNumber mcn1 = new MyComplexNumber(2,-2);
        MyComplexNumber mcn2 = new MyComplexNumber(5,0);
        MyComplexNumber mcn3 = new MyComplexNumber(5,-1);
        MyComplexNumber mcn4 = new MyComplexNumber(6,4);
        MyComplexNumber mcn5 = new MyComplexNumber(0,2);

        complexNumberArrayList.add(mcn1);
        complexNumberArrayList.add(mcn2);
        complexNumberArrayList.add(mcn3);
        complexNumberArrayList.add(mcn4);
        complexNumberArrayList.add(mcn5);

        Generic<MyComplexNumber> complexNumberGeneric = new Generic<>(complexNumberArrayList);
        MyComplexNumber complexNumberMax = complexNumberGeneric.max();
        System.out.println("The max number of the complexNumberArrayList: " + complexNumberMax);
    }
}
