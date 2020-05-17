package BT2;

public class MyFloat implements TopObject{
    private float value;

    MyFloat(float v){
        this.value = v;
    }

    @Override
    public int compareTo(TopObject topObject) {
        MyFloat mf = (MyFloat) topObject;

        if(this.value > mf.value){
            return 1;
        }
        else if(this.value < mf.value){
            return -1;
        }
        return 0;
    }

    public String toString(){
        return String.valueOf(this.value);
    }
}
