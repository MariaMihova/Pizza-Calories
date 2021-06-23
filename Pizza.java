import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;


    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name){
        if(name.length() < 1 || name.length() > 15 || name.trim().isEmpty()){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    //-	setToppings(int) : void
    private void setToppings(int numberOfToppings){
        if(numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    //+	setDough(Dough) : void
    public void setDough(Dough dough){
        this.dough = dough;
    }

    //addTopping (Topping) : void
    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public double getOverallCalories(){
        return this.dough.calculateCalories() +
                toppings.stream()
                .mapToDouble(Topping::calculateCalories)
                .sum();
    }

}
