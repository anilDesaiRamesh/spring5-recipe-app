/**
 * 
 */
package com.anil.recipe.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.anil.recipe.controllers.IndexController;
import com.anil.recipe.domain.Recipe;
import com.anil.recipe.services.RecipeService;

/**
 * @author Anil_Ramesh
 *
 */
public class IndexControllerTest {

	IndexController indexController;

	@Mock
	RecipeService recipeService;

	@Mock
	Model model;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeService);
	}

	/**
	 * Test method for
	 * {@link com.anil.recipe.controllers.IndexController#getIndexPage(org.springframework.ui.Model)}.
	 */
	@Test
	public void testGetIndexPage() {

		// Given
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		recipes.add(recipe);

		when(recipeService.getRecipes()).thenReturn(recipes);

		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		// When
		String indexPage = indexController.getIndexPage(model);

		// Then
		assertEquals("index", indexPage);
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(Mockito.eq("recipes"), argumentCaptor.capture());
		Set<Recipe> finalRecipes = argumentCaptor.getValue();
		assertEquals(2, finalRecipes.size());

	}

	@Test
	public void testMockMVC() throws Exception {

		MockMvc mockMVC = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMVC.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk()).
		andExpect(view().name("index"));

	}

}
