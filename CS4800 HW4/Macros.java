import java.util.ArrayList;
import java.util.Random;

class DietFactory {
    private static DietFactory dietFactory = null;
    private DietFactory() {}
    public static DietFactory getInstance() {
        if(dietFactory == null) {
            dietFactory = new DietFactory();
        }
        return dietFactory;
    }

    public void makeDiet(String diet) {
        String carb;
        String protein;
        String fat; 

        CarbFactory carbFactory = CarbFactory.getInstance();
        ProteinFactory proteinFactory = ProteinFactory.getInstance();
        FatFactory fatFactory = FatFactory.getInstance();

        carb = carbFactory.getCarb(diet).getString();
        protein = proteinFactory.getProtein(diet).getString();
        fat = fatFactory.getFat(diet).getString();

        System.out.println("Your diet consists of: " + carb + " for your carbs, " +
                            protein + " for your protein, and " + fat + " for your fat");          
    }
}


abstract class MacroFactory {
    abstract String getFood(String diet);
}

class CarbFactory {
    private static CarbFactory carbFactory = null;
    private CarbFactory() {}
    public static CarbFactory getInstance() {
        if(carbFactory == null) {
            carbFactory = new CarbFactory();
        }
        return carbFactory;
    }
   
    ArrayList<String> carbList = new ArrayList<String>();

    public Carb getCarb(String diet) {
        carbList.clear();
        switch(diet) {
            case "No Restriction":
                carbList.add("Cheese");
                carbList.add("Bread");
                carbList.add("Lentils");
                carbList.add("Pistachio");
            case "Paleo":
                carbList.add("Pistachio");
            case "Vegan":
                carbList.add("Bread");
                carbList.add("Lentils");
                carbList.add("Pistachio");
            case "Nut Allergy":
                carbList.add("Cheese");
                carbList.add("Bread");
                carbList.add("Lentils");
        }

        int num = RandomGenerator.getInstance().getRandomNum(carbList.size());
        String carb = carbList.get(num);

        switch (carb) {
            case "Cheese":
                return new Cheese();
            case "Bread":
                return new Bread();
            case "Lentils":
                return new Lentils();
            case "Pistachio":
                return new Pistachio();
            default:
                return null;
        }
    }
}

class ProteinFactory {
    private static ProteinFactory proteinFactory = null;
    private ProteinFactory() {}
    public static ProteinFactory getInstance() {
        if(proteinFactory == null) {
            proteinFactory = new ProteinFactory();
        }
        return proteinFactory;
    }
   
    ArrayList<String> proteinList = new ArrayList<String>();

    public Protein getProtein(String diet) {
        proteinList.clear();
        switch(diet) {
            case "No Restriction":
                proteinList.add("Fish");
                proteinList.add("Chicken");
                proteinList.add("Beef");
                proteinList.add("Tofu");
            case "Paleo":
                proteinList.add("Fish");
                proteinList.add("Chicken");
                proteinList.add("Beef");
            case "Vegan":
                proteinList.add("Tofu");
            case "Nut Allergy":
                proteinList.add("Fish");
                proteinList.add("Chicken");
                proteinList.add("Beef");
                proteinList.add("Tofu");
        }
        
        int num = RandomGenerator.getInstance().getRandomNum(proteinList.size());
        String protein = proteinList.get(num);

        switch (protein) {
            case "Fish":
                return new Fish();
            case "Chicken":
                return new Chicken();
            case "Beef":
                return new Beef();
            case "Tofu":
                return new Tofu();
            default:
                return null;
        }
    }
}

class FatFactory {
    private static FatFactory fatFactory = null;
    private FatFactory() {}
    public static FatFactory getInstance() {
        if(fatFactory == null) {
            fatFactory = new FatFactory();
        }
        return fatFactory;
    }
   
    ArrayList<String> fatList = new ArrayList<String>();

    public Fat getFat(String diet) {
        fatList.clear();
        switch(diet) {
            case "No Restriction":
                fatList.add("Avocado");
                fatList.add("Sour Cream");
                fatList.add("Tuna");
                fatList.add("Peanuts");
            case "Paleo":
                fatList.add("Avocado");
                fatList.add("Tuna");
                fatList.add("Peanuts");
            case "Vegan":
                fatList.add("Avocado");
                fatList.add("Tuna");
                fatList.add("Peanuts");
            case "Nut Allergy":
                fatList.add("Avocado");
                fatList.add("Sour Cream");
                fatList.add("Tuna");                
        }
        
        int num = RandomGenerator.getInstance().getRandomNum(fatList.size());
        String fat = fatList.get(num);

        switch (fat) {
            case "Avocado":
                return new Avocado();
            case "Sour Cream":
                return new SourCream();
            case "Tuna":
                return new Tuna();
            case "Peanuts":
                return new Peanuts();
            default:
                return null;
        }
    }
}

interface Carb {
    abstract String getString();
}

class Cheese implements Carb {
    public String getString() {
        return "Cheese";
    }
}

class Bread implements Carb {
    public String getString() {
        return "Bread";
    }
}

class Lentils implements Carb {
    public String getString() {
        return "Lentils";
    }
}

class Pistachio implements Carb {
    public String getString() {
        return "Pistachio";
    }
}

interface Protein {
    abstract String getString();
}

class Fish implements Protein {
    public String getString() {
        return "Fish";
    }
}

class Chicken implements Protein {
    public String getString() {
        return "Chicken";
    }
}

class Beef implements Protein {
    public String getString() {
        return "Beef";
    }
}

class Tofu implements Protein {
    public String getString() {
        return "Tofu";
    }
}

interface Fat {
    abstract String getString();
}

class Avocado implements Fat {
    public String getString() {
        return "Avocado";
    }
}

class SourCream implements Fat {
    public String getString() {
        return "Sour Cream";
    }
}

class Tuna implements Fat {
    public String getString() {
        return "Tuna";
    }
}

class Peanuts implements Fat {
    public String getString() {
        return "Peanuts";
    }
}

class RandomGenerator {
    private static RandomGenerator rg= null;
    private RandomGenerator(){}
    public static RandomGenerator getInstance() {
        if (rg == null) {
            rg = new RandomGenerator();
        }
        return rg;
    }

    public int getRandomNum(int size) {
        Random rand = new Random();
        int num = rand.nextInt(size);
        return num;
    }
}
