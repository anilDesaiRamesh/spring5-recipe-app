/**
 * 
 */
package com.anil.recipe.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.recipe.converters.RecipeCommandToRecipe;
import com.anil.recipe.converters.RecipeToRecipeCommand;
import com.anil.recipe.domain.Recipe;
import com.anil.recipe.domain.commands.RecipeCommand;
import com.anil.recipe.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Anil_Ramesh
 *
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
	private final RecipeToRecipeCommand recipeToRecipeCommand;

	@Autowired
	public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe,
			RecipeToRecipeCommand recipeToRecipeCommand) {
		super();
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anil.recipe.services.RecipeService#getRecipes()
	 */
	@Override
	public Set<Recipe> getRecipes() {
		// TODO Auto-generated method stub
		log.debug("Inside RecipeServiceImpl--getRecipes");
		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}

	@Override
	public Recipe findById(Long Id) {
		// TODO Auto-generated method stub
		Optional<Recipe> findById = recipeRepository.findById(Id);
		if (!findById.isPresent())
			throw new RuntimeException("Recipe Not Found");

		return findById.get();
	}

	@Override
	@Transactional
	public RecipeCommand saveRecipeCommand(RecipeCommand command) {
		// TODO Auto-generated method stub
		Recipe convert = recipeCommandToRecipe.convert(command);
		Recipe save = recipeRepository.save(convert);
		log.debug("Saved RecipeId:" + save.getId());
		return recipeToRecipeCommand.convert(save);
	}

	@Override
	@Transactional
	public RecipeCommand findCommandById(Long Id) {
		// TODO Auto-generated method stub
		return recipeToRecipeCommand.convert(findById(Id));
	}

	@Override
	public void deleteById(Long Id) {
		// TODO Auto-generated method stub
		recipeRepository.deleteById(Id);
	}

}
