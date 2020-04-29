package forest;

public class Fox  
{
    String id;
    String name;
    int age;
    int cost;

    public Fox(String id,String name,int age, int cost) 
    {
        this.id = id;
        this.name = name;
        this.age=age;
        this.cost = cost;
    }
   
    
    @Override
    public String toString() 
    {
        return "Fox[Name='"+name+"', Age=" + age + ", Cost=$" + cost+"]";
    }
}