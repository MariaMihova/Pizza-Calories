import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //{pizzaName} {numberOfToppings}
        String[] pizzaInfo = reader.readLine().split(" ");

            Pizza pizza = new Pizza(pizzaInfo[1], Integer.parseInt(pizzaInfo[2]));
            //{flourType} {bakingTechnique} {weightInGrams}
            String[] doughInfo = reader.readLine().split("\\s+");

                Dough dough = new Dough(doughInfo[1], doughInfo[2], Double.parseDouble(doughInfo[3]));
                pizza.setDough(dough);
                String command = reader.readLine();

                while (!command.equals("END")){
                    String[] toppingInfo = command.split("\\s+");
                    //o	Topping {toppingType} {weightInGrams
                        Topping topping = new Topping(toppingInfo[1], Double.parseDouble(toppingInfo[2]));
                        pizza.addTopping(topping);

                    command = reader.readLine();
                }
                    System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

    }

}