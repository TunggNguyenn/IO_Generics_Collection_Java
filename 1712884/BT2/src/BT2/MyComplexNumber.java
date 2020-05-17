package BT2;

public class MyComplexNumber implements TopObject{
    private int real;
    private int virtualUnit;

    MyComplexNumber(int r, int v){
        this.real = r;
        this.virtualUnit = v;
    }


    @Override
    public int compareTo(TopObject topObject) {
        MyComplexNumber mcn = (MyComplexNumber) topObject;

        if(this.real > mcn.real){
            return 1;
        }
        else if(this.real < mcn.real){
            return -1;
        }

        if(this.virtualUnit > mcn.virtualUnit){
            return 1;
        }
        else if(this.virtualUnit < mcn.virtualUnit){
            return -1;
        }

        return 0;
    }

    public String toString(){
        if(this.real == 0 && this.virtualUnit == 0){
            return String.valueOf(0);
        }
        else if(this.real == 0){
            return String.valueOf(this.virtualUnit) + "i";
        }
        else if(this.virtualUnit == 0){
            return String.valueOf(this.real);
        }

        if(this.virtualUnit > 0){
            return String.valueOf(this.real) + "+" + String.valueOf(this.virtualUnit) + "i";
        }
        return String.valueOf(this.real) + String.valueOf(this.virtualUnit) + "i";
    }
}
