package forest;

public class Animal 
{
    private String id;
    private String kind;
    private String name;
    private int age;
    private int cost;

    public Animal(String id,String kind, String name, int age, int cost) 
    {
        this.id = id;
        this.kind = kind;
        this.name = name;
        this.age = age;
        this.cost=cost;
    }

    public String getId() {
        return id;
    }
    public String getKind() {
        return kind;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public int getCost() {
        return cost;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
   

    @Override
    public String toString() 
    {
        return this.id +"\t " + this.kind +"\t " + this.name +"\t " + this.age+" \t$" + this.cost ;
    }
    
}
