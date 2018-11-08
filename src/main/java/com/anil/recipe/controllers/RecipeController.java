/**
 * 
 */
package com.anil.recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anil.recipe.domain.Recipe;
import com.anil.recipe.services.RecipeService;

/**
 * @author Anil_Ramesh
 *
 */
@Controller
public class RecipeController {

	RecipeService recipeService;

	@Autowired
	public RecipeController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@RequestMapping("/recipe/show/{id}")
	public String showById(@PathVariable String id, Model model) {

		Recipe findById = recipeService.findById(new Long(id));
		model.addAttribute("recipe", findById);
		return "recipe/show";

	}

}
