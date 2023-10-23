public class ZooManagment
{
    public static void main(String[] args)
    {
        Animal a = new Animal("Lion", "test",19, true);
        Animal katous = new Animal("aaa", "aaa",33, false);
        Animal kalb= new Animal("ssss", "ssss",33, false);

        Zoo z = new Zoo("yyy","xxx",2);

        z.displayZoo();

        System.out.println(z);
        //System.out.println(z.toString());

        System.out.println(a);
        System.out.println(kalb);
        System.out.println(katous);
        //System.out.println(a2.toString());


        for(int i = 0; i < 31; i++)
        {
            if(!z.addAnimal(a))
            {
                System.out.println("Animal Was not added!");
            }
            else
            {
                System.out.println("Animal Was added!");
            }
        }

        z.displayAnimals();

        int found = z.searchAnimal(a);
        System.out.println(found);

        boolean isDeleted = z.removeAniaml(a);
        System.out.println(isDeleted);
    }
}


////////////////////////////////////////////////////////////////////////////

class Animal
{
    String family;
    String name;
    int age;
    boolean isMammal;
    Animal()
    {
        //nothing here
    }
    Animal(String fam, String name, int a, boolean isMam)
    {
        this.family = fam;
        this.name = name;
        this.age = a;
        this.isMammal = isMam;
    }
    public void showAnimal()
    {
        System.out.println("Animal Family: " + family);
        System.out.println("Animal Name: " + name);
        System.out.println("Animal age: " + age);
        System.out.println("Animal Mamal? : " + isMammal);
    }

    public String toString()
    {
        return "Animal family=" + family + "//name=" + name + "//age: " + age + "//Is Mamal? : " + isMammal;
    }

    public void resetAnimal()
    {
        this.family = "";
        this.name = "";
        this.age = 0;
        this.isMammal = false;
    }
}

///////////////////////////////////////////////////////////////////////////////

class Zoo
{
    Animal[] animals;
    String name;
    String city;
    int nbrCages;
    int animalCount = 0;


    Zoo(String name, String city, int nbc)
    {
        animals = new Animal[3];
        this.name = name;
        this.city = city;
        this.nbrCages = nbc;
    }


    void displayAnimals()
    {
        if(animalCount == 0)
        {
            System.out.println("Zoo is empty!");
        }
        else
        {
            for(int i = 0; i < animalCount; i++)
            {
                animals[i].showAnimal();
            }
        }
    }
    @Override
    public String toString()
    {
        return "Zoo name=" + name + "//City=" + city + "//NbrCage: " + nbrCages;
    }

    public boolean addAnimal(Animal animal)
    {
        if(animalCount < animals.length)
        {
            if(searchAnimal(animal) == -1)
            {
                animals[animalCount] = animal;
                animalCount++;
            }
            else
            {
                System.out.println("Animal Already exists!");
            }
        }
        else
        {
            System.out.println("Max Capacity Reached!");
            return false;
        }
        return true;
    }
    public int searchAnimal(Animal animal)
    {
        if(animalCount == 0)
        {
            System.out.println("Zoo is empty!");
            return -1;
        }
        else
        {
            for(int i = 0; i < animalCount; i++) {
                if (animal.name == animals[i].name) {
                    System.out.println("Animal Found in Pos: " + i);
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean removeAniaml(Animal animal)
    {
        if(animalCount == 0)
        {
            System.out.println("Zoo is empty!");
            return false;
        }
        else
        {
            int indexPos = searchAnimal(animal);

            if(indexPos == -1)
            {
                System.out.println("Animal Doesn't exist");
                return false;
            }
            else
            {
                animals[indexPos].resetAnimal();
                animalCount --;
                System.out.println("Animal was removed.");
                return true;
            }
        }
    }
}
