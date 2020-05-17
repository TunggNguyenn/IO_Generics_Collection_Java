package BT2;

import java.util.ArrayList;

public class Generic <T extends TopObject> {
    private ArrayList<T> m;

    Generic(ArrayList<T> src){
        this.m = src;
    }

    public void set(ArrayList<T> src){
        this.m = src;
    }


    public T max(){
        T max = m.get(0);

        for(int i = 1; i < this.m.size(); i++){
            if(this.m.get(i).compareTo(max) == 1){
                max = this.m.get(i);
            }
        }
        return max;
    }
}
