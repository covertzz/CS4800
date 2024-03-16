public class MacrosDriver {
    public static void main(String[] args) {
        DietFactory df = DietFactory.getInstance();

        df.makeDiet("No Restriction");
        df.makeDiet("Paleo");
        df.makeDiet("Vegan");
        df.makeDiet("Nut Allergy");
    }
}
