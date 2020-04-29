package forest;

import java.io.Serializable;

public class AnimalFile implements Serializable
   { 
	/**
	 *
	 */
	private static final long serialVersionUID = 4725942777918926070L;
	String id;
    String kind;
    String name;
    int age;
    int cost;

    public AnimalFile(String id,String kind, String name, int age, int cost) 
    {
        this.id = id;
        this.kind = kind;
        this.name = name;
        this.age = age;
        this.cost=cost;
    }

   @Override
    public String toString() 
    {
        return this.id +"\t " + this.kind +"\t " + this.name +"\t " + this.age+" \t" + this.cost ;
    }
    
}
