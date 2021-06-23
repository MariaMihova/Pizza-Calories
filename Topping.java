import java.util.Locale;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType){
        if(!toppingType.equals("Meat")
        && !toppingType.equals("Veggies")
        && !toppingType.equals("Cheese")
        && !toppingType.equals("Sauce")){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }
    public String getToppingType(){
        return this.toppingType;
    }


    private void setWeight(double weight){
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format(
                    "%s weight should be in the range [1..50].",
                    this.toppingType));
        }
        this.weight = weight;
    }

    public double getWeight(){
        return this.weight;
    }

    public double calculateCalories (){
        ToppingType toppingType = ToppingType.valueOf(this.toppingType.toUpperCase(Locale.ROOT));
        return 2 * getWeight() * toppingType.getModifier();
    }
}
