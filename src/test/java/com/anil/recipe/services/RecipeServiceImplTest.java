/**
 * 
 */
package com.anil.recipe.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.anil.recipe.domain.Recipe;
import com.anil.recipe.repositories.RecipeRepository;
import com.anil.recipe.services.RecipeServiceImpl;

/**
 * @author Anil_Ramesh
 *
 */
public class RecipeServiceImplTest {

	RecipeServiceImpl recipeServiceImpl;

	@Mock
	RecipeRepository recipeRepository;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
	}

	/**
	 * Test method for
	 * {@link com.anil.recipe.services.RecipeServiceImpl#getRecipes()}.
	 */
	@Test
	public void testGetRecipes() {

		Recipe recipe = new Recipe();
		HashSet<Recipe> recipesData = new HashSet<>();
		recipesData.add(recipe);

		when(recipeServiceImpl.getRecipes()).thenReturn(recipesData);

		Set<Recipe> recipes = recipeServiceImpl.getRecipes();
		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();

	}

	@Test
	public void testGetRecipeById() {

		Recipe recipe = new Recipe();
		Long Id_1 = 1l;
		recipe.setId(Id_1);

		when(recipeRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(recipe));

		Recipe findById = recipeServiceImpl.findById(Id_1);
		assertNotNull(findById);
		assertEquals(findById.getId(), Id_1);
		verify(recipeRepository).findById(ArgumentMatchers.anyLong());
		verify(recipeRepository, never()).findAll();

	}

}
