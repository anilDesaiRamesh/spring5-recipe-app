/**
 * 
 */
package com.anil.recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anil.recipe.domain.commands.RecipeCommand;
import com.anil.recipe.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Anil_Ramesh
 *
 */
@Slf4j
@Controller
public class IngredientController {

	RecipeService recipeService;

	@Autowired
	public IngredientController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@GetMapping
	@RequestMapping("recipe/{recipeId}/ingredients")
	public String listIngredients(@PathVariable String recipeId, Model model) {
		log.debug("Getting ingredient list for recipe id: " + recipeId);
		RecipeCommand findCommandById = recipeService.findCommandById(new Long(recipeId));
		model.addAttribute("recipe", findCommandById);
		return "recipe/ingredient/list";

	}

}
