package BT2;

public class Fraction implements TopObject {
    private int numerator;
    private int denominator;

    Fraction(int n, int d){
        this.numerator = n;
        this.denominator = d;
    }

    @Override
    public int compareTo(TopObject topObject) {
        Fraction f = (Fraction)topObject;

        if(this.numerator*f.denominator > f.numerator*this.denominator){
            return 1;
        }
        else if(this.numerator*f.denominator < f.numerator*this.denominator){
            return -1;
        }
        return 0;
    }

    public String toString(){
        return String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
    }
}
