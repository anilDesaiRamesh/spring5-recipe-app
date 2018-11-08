/**
 * 
 */
package com.anil.recipe.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.anil.recipe.domain.Recipe;
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

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
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

}
