package forest;

public class randomAnimal 
{
    String id;
    String name;
    int age;
    int cost;

    public randomAnimal(String id,String name,int age, int cost) 
    {
        this.id = id;
        this.name = name;
        this.age=age;
        this.cost = cost;
    }
   
    
    @Override
    public String toString() 
    {
        return "Name='"+name+"', Age=" + age + ", Cost=$" + cost;
    }
}