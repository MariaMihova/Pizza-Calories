import java.util.Locale;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        //•	White – 1.5;
        //•	Wholegrain – 1.0;
        if(!flourType.equals("White") && !flourType.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public String getFlourType() {
        return this.flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        //•	Crispy – 0.9;
        //•	Chewy – 1.1;
        //•	Homemade – 1.0;
        if(!bakingTechnique.equals("Crispy")
        && !bakingTechnique.equals("Chewy")
        && !bakingTechnique.equals("Homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public String getBakingTechnique() {
        return this.bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public double calculateCalories() {
        FlourType flourType = FlourType.valueOf(this.getFlourType().toUpperCase(Locale.ROOT));
        BakingTechnique bakingTechnique = BakingTechnique.valueOf(this.getBakingTechnique().toUpperCase(Locale.ROOT));
        return (2 * getWeight()) * flourType.getModifier() * bakingTechnique.getModifier();
    }


}
