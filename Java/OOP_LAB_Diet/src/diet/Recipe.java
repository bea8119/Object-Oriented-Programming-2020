package diet;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {
    
	private String name;
	private Food food;
	
	private double calories = 0.0;
	private double proteins = 0.0;
	private double carbs = 0.0;
	private double fat = 0.0;
	private double weight = 0.0;
	
	
	private List<Ingredient> ingredients= new LinkedList<Ingredient>();
	
	protected static class Ingredient{
		final NutritionalElement ne;
		final double quantity;
		
		 Ingredient(NutritionalElement element,double  qty) {
			this.ne=element;
			this.quantity=qty;
		}		
	}
	
	public Recipe(String name, Food food) {
		this.name=name;
		this.food=food;
	}
	

	/**
	 * Adds a given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 * @return the same Recipe object, it allows method chaining.
	 */
	public Recipe addIngredient(String material, double quantity) {
		NutritionalElement e= food.getRawMaterial(material);
		Ingredient ingr= new Ingredient(e, quantity);
		ingredients.add(ingr);
		
		this.calories += e.getCalories(quantity);
		this.proteins += e.getProteins(quantity);
		this.carbs += e.getCarbs(quantity);
		this.fat += e.getFat(quantity);
		this.weight += quantity;
		return this;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public double getCalories() {
		/*double cal= 0.0;
		
		for(Ingredient i: ingredients) {
		cal += i.ne.getCalories(i.quantity);	
		}*/
		
		return calories*100/weight;
	}
	@Override
	public double getProteins() {

		return proteins*100/weight;
	}
	@Override
	public double getCarbs() {

		return carbs*100/weight;
	}
	@Override
	public double getFat() {

		return fat*100/weight;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}:
	 * a recipe expresses nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return true;
	}
	
	
	/**
	 * Returns the ingredients composing the recipe.
	 * 
	 * A string that contains all the ingredients, one per per line, 
	 * using the following format:
	 * {@code "Material : ###.#"} where <i>Material</i> is the name of the 
	 * raw material and <i>###.#</i> is the relative quantity. 
	 * 
	 * Lines are all terminated with character {@code '\n'} and the ingredients 
	 * must appear in the same order they have been added to the recipe.
	 */
	@Override
	public String toString() {
		String buffer="";
		for(Ingredient i: ingredients) {
			buffer +=i.ne.getName()+" : "+i.quantity+" \n";
		}
		
		return buffer;
	}
}
