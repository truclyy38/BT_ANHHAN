package forest;

public class Elephant 
{
    String id;
    String name;
    int age;
    int cost;

    public Elephant(String id,String name,int age, int cost) 
    {
        this.id = id;
        this.name = name;
        this.age=age;
        this.cost = cost;
    }
   
    
    @Override
    public String toString() 
    {
        return "Elephant[Name='"+name+"', Age=" + age + ", Cost=$" + cost+"]";
    }

}