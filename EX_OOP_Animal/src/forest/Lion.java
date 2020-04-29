package forest;

public class Lion 
{
    String id;
    String name;
    int age;
    int cost;

    public Lion(String id,String name,int age, int cost) 
    {
        this.id = id;
        this.name = name;
        this.age=age;
        this.cost = cost;
    }
   
    
    @Override
    public String toString() 
    {
        return "Lion[Name='"+name+"', Age=" + age + ", Cost=$" + cost+"]";
    }

}