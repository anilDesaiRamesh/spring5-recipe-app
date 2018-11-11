/**
 * 
 */
package com.anil.recipe.services;

import java.util.Set;

import com.anil.recipe.domain.Recipe;
import com.anil.recipe.domain.commands.RecipeCommand;

/**
 * @author Anil_Ramesh
 *
 */
public interface RecipeService {

	Set<Recipe> getRecipes();
	
	Recipe findById(Long Id);
	
	RecipeCommand saveRecipeCommand(RecipeCommand command);

	RecipeCommand findCommandById(Long Id);
	
	void deleteById(Long Id);
}
