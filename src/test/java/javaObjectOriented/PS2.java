package javaObjectOriented;

public class PS2 extends PS3{

    private int a = 0;

    public PS2(int a){
        super(a);
        this.a = a;
    }

    public int increment(){
        a++;
        return a;
    }

    public int decrement(){
        a--;
        return  a;
    }
}
