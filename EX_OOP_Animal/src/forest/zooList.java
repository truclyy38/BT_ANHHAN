package forest;
import java.util.*;
import java.io.*;



public class zooList {

    GenericZoo<Animal> myzoo = new GenericZoo<>();

    static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    static final String alphaUpperCase = alpha.toUpperCase();
    private static final String digits = "0123456789";
    private static final String ALPHA_NUMERIC = alphaUpperCase + digits;
    private static Random generator = new Random();

    public zooList(){}
//==>CAC HAM CHECK EXIST
// ham kiem tra id trong list
public int isExistId(String id) 
{
    for (int i = 0; i < myzoo.getCl().size(); i++) {
        if (myzoo.getCl().get(i).getId().equalsIgnoreCase(id)) 
        {
            return i;
        }
    }
    return -1;
}
//ham kiem tra type dong vat co trung lap trong danh sach
public int isExistKind(String Kind) 
{
    for (int i = 0; i < myzoo.getCl().size(); i++) {
        if (myzoo.getCl().get(i).getKind().equalsIgnoreCase(Kind)) 
        {
            return i;
        }
    }
    return -1;
}
//ham tra ve tong so luong va tong gia theo loai dong vat
    public int[] countKind(String kind) 
    {
            int num=-1,sumcost=0;
            for (int i = 0; i < myzoo.getCl().size(); i++) {
                if (myzoo.getCl().get(i).getKind().equalsIgnoreCase(kind)) 
                {
                    sumcost+=myzoo.getCl().get(i).getCost();
                    num++;
                }
        }
        return new int[] {num, sumcost};
    }
//ham doc file text
    public void transDataToList()
     {
        String id,kind,name;
        int age, cost;
   
        File text = new File("D:/dataAnimal.txt");
 
		Scanner scanner = null;
            try {
                scanner = new Scanner(text);
                } catch (FileNotFoundException e) 
                {e.printStackTrace();}

		while (scanner.hasNextLine()) {
          try{
            id= scanner.next();
            kind=scanner.next();
            name=scanner.next();
            age=scanner.nextInt();
            cost=scanner.nextInt();
            myzoo.getCl().add(new Animal(id,kind,name,age,cost));            
           }catch(Exception e){};
        }        
        scanner.close(); 
    }
    //============//
// BAI TAP 1 ==========================================

public void displayList1()
    {   GenericZoo<animalNum> myanimal= new GenericZoo<>();
        int i=0,totalNum=0,totalCost=0,max= myzoo.getCl().size();
        for ( i = 0; i < max; i++) 
        {  
            String kind= myzoo.getCl().get(i).getKind();
            int result[] = countKind(kind);
            int k=0;
            int num=result[0], sumcost=result[1];
            for(int j=0;j<i;j++)
            {
                if(myzoo.getCl().get(j).getKind().equalsIgnoreCase(kind)) k=-1;
            }
            if(k>=0)
            {  
                myanimal.getCl().add(new animalNum(kind, num+1, sumcost) );
            }
        }
        System.out.println("Animal	Number	Cost");
        System.out.println("====================");
        for(i=0;i<myanimal.getCl().size();i++)
        {
            System.out.println(myanimal.getCl().get(i));
            totalNum+=myanimal.getCl().get(i).getAnimalNumber();
            totalCost+=myanimal.getCl().get(i).getAnimalCost();
        }
        System.out.println("==========================");
        System.out.println("Total\t"+totalNum+"\t"+totalCost);
}

// ==========================.=============================================//

// BAI TAP 2================================================
    public void displayList() 
    {
        if (myzoo.getCl().isEmpty()) 
        {
            System.out.println("List is empty!");
        } else 
            {
                System.out.println("Zoo Information :");
                System.out.println("ID\tAnimal\tName\tAge\tCost");
                System.out.println("==================================");
                for (int i = 0; i < myzoo.getCl().size(); i++) 
                    {
                        System.out.println(myzoo.getCl().get(i));
                     }
        }
    }
//=============================================================================//

// BAI TAP 3============================
    public void sortList()
    {
		myzoo.getCl().sort(new AnimalComparator()) ;
        System.out.println("Sort Completed!");
    }

// BAI TAP 4============================
public void filterList()
{
    Set<randomAnimal> myelephant = new HashSet<randomAnimal>();
    Set<randomAnimal> myfox = new HashSet<randomAnimal>();
    Set<randomAnimal> mylion = new HashSet<randomAnimal>();
    String kindfilter, namefilter, agefilter, signfilter,costinput;
    int agelowest=0,agehighest=0, costfilter;
    String[] words;
    //nhap vao noi dung loc
    System.out.print("Input Type Filter: ");
        kindfilter = Validation.checkInputString().toUpperCase();
    System.out.print("Input name: ");
        namefilter = Validation.checkInputString();
    System.out.print("Input age: ");
        agefilter = Validation.checkInputString();
    System.out.print("Input cost: ");
        costinput = Validation.checkInputString();
    System.out.println("the animals filtered :");
    // tach tuoi
    agefilter=agefilter.replaceAll("[^\\w\\s]"," ");
    try
    {words=agefilter.split("\\s");
        agelowest= Integer.parseInt(words[0]);
        agehighest= Integer.parseInt(words[1]);
    }catch(Exception e) {};
    // tach gia
    signfilter= costinput.substring(0,1);
    costfilter= Integer.parseInt(costinput.substring(1));

    switch(kindfilter)
    {
        case "FOX":
            specifyAnimaltoSet(myfox, kindfilter);
            for( randomAnimal one : myfox ) 
            {if(checkFilter(one, namefilter, agelowest, agehighest, costfilter, signfilter)) 
                System.out.println(kindfilter+"["+one+"]"); }
            break;
        case "LION":
            specifyAnimaltoSet(mylion, kindfilter);
            for( randomAnimal one : mylion ) 
            {if(checkFilter(one, namefilter, agelowest, agehighest, costfilter, signfilter)) 
                System.out.println(kindfilter+"["+one+"]"); }
            break;
        case "ELEPHANT":
            specifyAnimaltoSet(myelephant, kindfilter);
            for( randomAnimal one : myelephant ) 
            {if(checkFilter(one, namefilter, agelowest, agehighest, costfilter, signfilter)) 
                System.out.println(kindfilter+"["+one+"]"); }
            break;
        default: System.out.println("We don't have this kind of animal");
    }
    
}
public void specifyAnimaltoSet(Set<randomAnimal> myone, String kind)
{   
    int max=myzoo.getCl().size();
    
    for (int i = 0; i < max; i++) 
    { 
    String id=myzoo.getCl().get(i).getId();
    String name=myzoo.getCl().get(i).getName();
    int age=myzoo.getCl().get(i).getAge();
    int cost=myzoo.getCl().get(i).getCost();
    String type=myzoo.getCl().get(i).getKind();

    try{
    if (type.equalsIgnoreCase(kind)) 
        {   
            randomAnimal item = new randomAnimal(id,name, age, cost);
            myone.add(item);
        }
    } catch(Exception e){}
    }
}
public boolean checkFilter(randomAnimal one, String nameFilter, int agelowest, int agebiggest, int costflter, String sign)
    {int k=0; nameFilter=nameFilter.toUpperCase();
            if(!one.name.startsWith(nameFilter)) k=-1;//check name
            if(one.age<agelowest || one.age>agebiggest) k=-1;// check tuoi
            if(sign.equals("+")) {if (one.cost<=costflter) k=-1;} // check dau
            else if(sign.equals("-")){if(one.cost>costflter) k=-1;}
                else k=-1; 
        if(k==-1) return false;
        return true;
    }
//========================================================================//

//BAI TAP 5 =============================================================
    
    // ham random ID
public String randomAlphaNumeric(int numberOfCharactor) 
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

public static int randomNumber(int min, int max)
    {
        return generator.nextInt((max - min) + 1) + min;
    }

    
    //  ham add
public void addList() 
{
    String id,kind,name;int age, cost, index=0;

       do{  System.out.println("Please choose the type of animal: Fox, Lion or Elephant?");
            System.out.print("Input Type: ");
            kind = Validation.checkInputString();
            kind = CapitalFirstLetter(kind);
            if(isExistKind(kind)<0) System.out.println("Kind is invalid, enter again please!!");
        }   while(isExistKind(kind)<0);

        do{ id=randomAlphaNumeric(4);
            
            // check id co trung ko
            index=isExistId(id);
            if ( index<0) 
            {   
                System.out.print("Input name: ");
                name = Validation.checkInputString();
                name = CapitalFirstLetter(name);
                System.out.print("Input age: ");
                age = Validation.checkInputInt();
                System.out.print("Input cost: ");
                cost = Validation.checkInputInt();
                myzoo.getCl().add(new Animal(id,kind,name,age,cost));
                System.out.println("Add new animal successful!");
            } 
            } while (index >=0);
}
//--
public String CapitalFirstLetter(String Str)
{
    Str = Str.toLowerCase(); 
    return Str = Character.toString(Str.charAt(0)).toUpperCase()+Str.substring(1);
}
//BAI TAP 6===================================

public void viewAnimal()
{   
    Set<randomAnimal> randomAnimals = new HashSet<randomAnimal>();
        
    String idFind, kind; int index;
    // chuyen du lieu sang class con
    specifyAnimal(randomAnimals);
   
    do {System.out.print("Input ID :");
        idFind = Validation.checkInputString().toUpperCase();
        index= isExistId(idFind);
        if (index<0) System.out.print("Empty!");} while(index<0);

        kind=myzoo.getCl().get(index).getKind();
        for( randomAnimal one :randomAnimals ) {if(one.id.contains(idFind)) System.out.println(kind+"["+one+"]");}
}
//ham tach rieng dong vat
public void specifyAnimal(Set<randomAnimal> randomAnimals)
{   int max=myzoo.getCl().size();
    String id, name; int age, cost;
    
    for (int i = 0; i < max; i++) 
    {   
        id=myzoo.getCl().get(i).getId();
        name=myzoo.getCl().get(i).getName();
        age=myzoo.getCl().get(i).getAge();
        cost=myzoo.getCl().get(i).getCost();
        
        randomAnimal item = new randomAnimal(id,name, age, cost);
                randomAnimals.add(item);
    }
}
//=============================================================================//

//BAI TAP 7==========================
public void editList()
{
    String id,kind,name;int age, cost, index=0;

     do{ 
        System.out.print("Input ID :");
        id = Validation.checkInputString().toUpperCase();
         // check id co trung ko
         index=isExistId(id);
         if ( index>=0) 
         {   
             System.out.print("Input name: ");
             name = Validation.checkInputString();
             name = CapitalFirstLetter(name);
             System.out.print("Input age: ");
             age = Validation.checkInputInt();
             System.out.print("Input cost: ");
             cost = Validation.checkInputInt();
             kind=myzoo.getCl().get(index).getKind();
             Animal one = new Animal(id,kind,name,age,cost);
             myzoo.getCl().set(index,one);
             System.out.println("Edit animal successful!");
         } else System.out.println("This ID is not exist!");
         } while (index <0);
}

//BAI TAP 8=============
 public void deleteAnimal()
{   
    if(myzoo.getCl().isEmpty())  System.out.println("List is empty!");
    else
    {   displayList();
        System.out.print("Enter ID to delete: ");
        String id = Validation.checkInputString().toUpperCase();
        int index= isExistId(id);
        int max = myzoo.getCl().size();
        if(index>=max || index<0)
            {
            System.err.println("There is no animal to remove. Enter again!");
            deleteAnimal();
            }
        else{
        myzoo.getCl().remove(index);
        System.out.println("Delete successful!");}
    }   
 }
 //========================================================================================//

 //BAI TAP 9=========================
public void saveFile()
    {   int max=myzoo.getCl().size();
        String id,kind,name;int age, cost;
        AnimalFile myanimalfile;
        
    try{    FileOutputStream f = new FileOutputStream("D:/outdataAnimal.dat");
            ObjectOutputStream ooT = new ObjectOutputStream(f);
            
            for(int i=0;i<max;i++)
                {
                    id=myzoo.getCl().get(i).getId();
                    name=myzoo.getCl().get(i).getName();
                    kind=myzoo.getCl().get(i).getKind();
                    age=myzoo.getCl().get(i).getAge();
                    cost=myzoo.getCl().get(i).getCost();
                    myanimalfile= new AnimalFile(id, kind, name, age, cost);
                    ooT.writeObject(myanimalfile);
                }
			    System.out.println("Save File!");
                ooT.close();
                f.close();
            } catch (IOException ex) {System.out.println("Loi ghi file: "+ex);}        
                
    }
}
