package diet;

import java.util.LinkedList;
import java.util.List;

import diet.Recipe.Ingredient;

/**
 * Represents a complete menu.
 * 
 * It can be made up of both packaged products and servings of given recipes.
 *
 */
public class Menu implements NutritionalElement {
	
	/**
	 * Adds a given serving size of a recipe.
	 * 
	 * The recipe is a name of a recipe defined in the
	 * {@Link Food} in which this menu has been defined.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 * @return the same Menu to allow method chaining
	 */
	private List< NutritionalElement> things= new LinkedList< NutritionalElement>();
	
	private String name;
	
	private Food food;
	
	private double calories = 0.0;
	private double proteins = 0.0;
	private double carbs = 0.0;
	private double fat = 0.0;
	
	
	
	
	public Menu(String name, Food food) {
		super();
		this.name = name;
		this.food = food;
	}

	public Menu addRecipe(String recipe, double quantity) {
		NutritionalElement e= food.getRecipe(recipe);		
		things.add(e);
		
		this.calories += e.getCalories(quantity);
		this.proteins += e.getProteins(quantity);
		this.carbs += e.getCarbs(quantity);
		this.fat += e.getFat(quantity);
		
		
		return this;
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the
	 * {@Link Food} in which this menu has been defined.
	 * 
	 * @param product the name of the product to be used as ingredient
	 * @return the same Menu to allow method chaining
	 */
	public Menu addProduct(String product) {
		NutritionalElement e= food.getProduct(product);		
		things.add(e);
		this.calories += e.getCalories();
		this.proteins += e.getProteins();
		this.carbs += e.getCarbs();
		this.fat += e.getFat();
		
		
		return this;
	}

	/**
	 * Name of the menu
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Total KCal in the menu
	 */
	@Override
	public double getCalories() {
		return this.calories;
	}

	/**
	 * Total proteins in the menu
	 */
	@Override
	public double getProteins() {
		return this.proteins;
	}

	/**
	 * Total carbs in the menu
	 */
	@Override
	public double getCarbs() {
		return this.carbs;
	}

	/**
	 * Total fats in the menu
	 */
	@Override
	public double getFat() {
		return this.fat;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Menu} class it must always return {@code false}:
	 * nutritional values are provided for the whole menu.
	 * 
	 * @return boolean 	indicator
	 */
	@Override
	public boolean per100g() {
		// nutritional values are provided for the whole menu.
		return false;
	}
}
