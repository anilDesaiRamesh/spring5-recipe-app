/**
 * 
 */
package com.anil.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anil.recipe.repositories.CategoryRepository;
import com.anil.recipe.repositories.UnitOfMeasureRepository;
import com.anil.recipe.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Anil_Ramesh
 *
 */
@Slf4j
@Controller
public class IndexController {

	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		log.debug("Inside IndexController-- getIndexPage");
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}

}
