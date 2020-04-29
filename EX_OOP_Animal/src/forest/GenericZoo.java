package forest;

import java.util.ArrayList;

public class GenericZoo <T> {
	
	public GenericZoo() {}
    
    private T obj;
    private ArrayList<T> cl = new ArrayList<>();
    
   
    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public ArrayList<T> getCl() {
        return cl;
    }

    public void setCl(ArrayList<T> cl) {
        this.cl = cl;
    }
}
