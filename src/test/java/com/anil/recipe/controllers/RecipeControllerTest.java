/**
 * 
 */
package com.anil.recipe.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.anil.recipe.domain.Recipe;
import com.anil.recipe.domain.commands.RecipeCommand;
import com.anil.recipe.services.RecipeService;

/**
 * @author Anil_Ramesh
 *
 */
public class RecipeControllerTest {

	RecipeController recipeController;

	@Mock
	RecipeService recipeService;

	Long Id_1 = 1l;

	MockMvc mockMvc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeController = new RecipeController(recipeService);
		mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
	}

	@Test
	public void testGetRecipe() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(Id_1);

		when(recipeService.findById(ArgumentMatchers.anyLong())).thenReturn(recipe);

		mockMvc.perform(MockMvcRequestBuilders.get("/recipe/1/show")).andExpect(status().isOk())
				.andExpect(view().name("recipe/show")).andExpect(model().attributeExists("recipe"));

	}

	@Test
	public void testNewRecipe() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/recipe/new")).andExpect(status().isOk())
				.andExpect(view().name("recipe/recipeform")).andExpect(model().attributeExists("recipe"));

	}

	@Test
	public void testSaveOrUpdate() throws Exception {

		RecipeCommand saveRecipeCommand = new RecipeCommand();
		saveRecipeCommand.setId(Id_1);

		when(recipeService.saveRecipeCommand(ArgumentMatchers.any())).thenReturn(saveRecipeCommand);

		mockMvc.perform(MockMvcRequestBuilders.post("/recipe").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("id", "").param("description", "some string")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/recipe/1/show/"));

	}

	@Test
	public void testUpdateRecipe() throws Exception {

		RecipeCommand recipeCommand = new RecipeCommand();
		recipeCommand.setId(Id_1);

		when(recipeService.findCommandById(ArgumentMatchers.any())).thenReturn(recipeCommand);

		mockMvc.perform(MockMvcRequestBuilders.post("/recipe/1/update")).andExpect(status().isOk())
				.andExpect(view().name("recipe/recipeform")).andExpect(model().attributeExists("recipe"));
	}

}
