package forest;

public class animalNum 
{
    private String animalName;
    private int animalNumber;
    private int animalCost;

    public animalNum(String animalName,int animalNumber, int animalCost) 
    {
        this.animalName = animalName;
        this.animalNumber = animalNumber;
        this.animalCost = animalCost;

    }

    public String getAnimalName() {
        return animalName;
    }
    public int getAnimalNumber() {
        return animalNumber;
    }
    public int getAnimalCost() {
        return animalCost;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    public void setAnimalNumber(int animalNumber) {
        this.animalNumber = animalNumber;
    }
    public void setAnimalCost(int animalCost) {
        this.animalCost = animalCost;
    }
    
    @Override
    public String toString() 
    {
        return  this.animalName +"\t" + this.animalNumber +"\t $" + this.animalCost ;
    }
    


}