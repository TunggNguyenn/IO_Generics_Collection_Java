package BT2;

public class MyString implements TopObject{
    private String value;

    MyString(String v){
        this.value = v;
    }

    @Override
    public int compareTo(TopObject topObject) {
        MyString ms = (MyString) topObject;

        if(this.value.length() > ms.value.length()){
            return 1;
        }
        else if(this.value.length() < ms.value.length()){
            return -1;
        }
        if(this.value.compareTo(ms.value) > 0){
            return 1;
        }
        else if(this.value.compareTo(ms.value) < 0){
            return -1;
        }
        else{
            return 0;
        }
    }

    public String toString(){
        return this.value;
    }
}
