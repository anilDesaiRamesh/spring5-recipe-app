/**
 * 
 */
package com.anil.recipe.services;

import static org.junit.Assert.*;

import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anil.recipe.converters.RecipeCommandToRecipe;
import com.anil.recipe.converters.RecipeToRecipeCommand;
import com.anil.recipe.domain.Recipe;
import com.anil.recipe.domain.commands.RecipeCommand;

/**
 * @author Anil_Ramesh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {

	private final String NEW_DESCRIPTION = "New Description";

	@Autowired
	RecipeService recipeService;

	@Autowired
	RecipeCommandToRecipe recipeCommandToRecipe;

	@Autowired
	RecipeToRecipeCommand recipeToRecipeCommand;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.anil.recipe.services.RecipeServiceImpl#saveRecipeCommand(com.anil.recipe.domain.commands.RecipeCommand)}.
	 */
	@Transactional
	@Test
	public void testSaveRecipeCommand() {

		// Given
		Set<Recipe> recipes = recipeService.getRecipes();
		Recipe next = recipes.iterator().next();
		next.setDescription(NEW_DESCRIPTION);

		// when
		RecipeCommand saveRecipeCommand = recipeService.saveRecipeCommand(recipeToRecipeCommand.convert(next));

		// then
		assertEquals(saveRecipeCommand.getDescription(), next.getDescription());
		assertEquals(next.getId(), saveRecipeCommand.getId());
		assertEquals(next.getCategories().size(), saveRecipeCommand.getCategories().size());
		assertEquals(next.getIngredients().size(), saveRecipeCommand.getIngredients().size());

	}

}
