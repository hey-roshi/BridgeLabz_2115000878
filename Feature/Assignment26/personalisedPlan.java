import java.util.*;

// MealPlan Interface
interface MealPlan {
    String getMealType();
    void mealDetails();
}

// Different Meal Types Implementing MealPlan
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian Meal";
    }

    @Override
    public void mealDetails() {
        System.out.println("Includes vegetables, grains, dairy, and eggs.");
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan Meal";
    }

    @Override
    public void mealDetails() {
        System.out.println("Includes plant-based foods, no dairy or animal products.");
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto Meal";
    }
    public void mealDetails() {
        System.out.println("Includes high fats, moderate proteins, and low carbs.");
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein Meal";
    }
    public void mealDetails() {
        System.out.println("Includes high-protein sources like chicken, eggs, and legumes.");
    }
}
class Meal<T extends MealPlan> {
    private String mealName;
    private T mealType;

    public Meal(String mealName, T mealType) {
        this.mealName = mealName;
        this.mealType = mealType;
    }

    public String getMealName() {
        return mealName;
    }

    public T getMealType() {
        return mealType;
    }

    public void displayMealDetails() {
        System.out.println("\nMeal: " + mealName + " - " + mealType.getMealType());
        mealType.mealDetails();
    }
}
class MealPlanGenerator {
    private List<Meal<? extends MealPlan>> mealPlans = new ArrayList<>();

    public void addMeal(Meal<? extends MealPlan> meal) {
        mealPlans.add(meal);
    }

    public void displayAllMeals() {
        System.out.println("\nPersonalized Meal Plans:");
        for (Meal<? extends MealPlan> meal : mealPlans) {
            meal.displayMealDetails();
        }
    }
    public static <T extends MealPlan> boolean isValidMeal(T meal) {
        return meal != null;
    }
}

public class personalisedPlan{
    public static void main(String[] args) {
        // Create Meal Type Instances
        VegetarianMeal vegMeal = new VegetarianMeal();
        VeganMeal veganMeal = new VeganMeal();
        KetoMeal ketoMeal = new KetoMeal();
        HighProteinMeal proteinMeal = new HighProteinMeal();

        // Create Meal Instances
        Meal<VegetarianMeal> pasta = new Meal<>("Vegetarian Pasta", vegMeal);
        Meal<VeganMeal> smoothie = new Meal<>("Vegan Smoothie", veganMeal);
        Meal<KetoMeal> grilledChicken = new Meal<>("Keto Grilled Chicken", ketoMeal);
        Meal<HighProteinMeal> proteinBowl = new Meal<>("High-Protein Bowl", proteinMeal);

        // Meal Plan Generator
        MealPlanGenerator generator = new MealPlanGenerator();
        generator.addMeal(pasta);
        generator.addMeal(smoothie);
        generator.addMeal(grilledChicken);
        generator.addMeal(proteinBowl);

        // Display Meals
        generator.displayAllMeals();

        // Validate Meal Plan
        System.out.println("\nMeal Plan Validity:");
        System.out.println("Is Keto Meal valid? " + MealPlanGenerator.isValidMeal(ketoMeal));
        System.out.println("Is Vegan Meal valid? " + MealPlanGenerator.isValidMeal(veganMeal));
    }
}
