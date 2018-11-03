/**
 * 
 */
package com.anil.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.anil.recipe.domain.Recipe;

/**
 * @author Anil_Ramesh
 *
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
