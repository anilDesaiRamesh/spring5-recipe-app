/**
 * 
 */
package com.anil.recipe.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.anil.recipe.domain.Recipe;
import com.anil.recipe.services.RecipeService;

/**
 * @author Anil_Ramesh
 *
 */
public class RecipeControllerTest {
	
	RecipeController recipeController;
	
	@Mock
	RecipeService recipeService;
	
	Long Id_1=1l;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeController = new RecipeController(recipeService);
	}

	@Test
	public void test() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(Id_1);
		
		when(recipeService.findById(ArgumentMatchers.anyLong())).thenReturn(recipe);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/recipe/show/1")).andExpect(status().isOk()).andExpect(view().name("recipe/show"));
		
	}

}
