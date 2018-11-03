/**
 * 
 */
package com.anil.recipe.services;

import java.util.Set;

import com.anil.recipe.domain.Recipe;

/**
 * @author Anil_Ramesh
 *
 */
public interface RecipeService {

	Set<Recipe> getRecipes();
}
