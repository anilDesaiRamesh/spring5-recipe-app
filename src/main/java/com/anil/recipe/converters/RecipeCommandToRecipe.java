/**
 * 
 */
package com.anil.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.anil.recipe.domain.Recipe;
import com.anil.recipe.domain.commands.RecipeCommand;

import lombok.Synchronized;

/**
 * @author Anil_Ramesh
 *
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

	IngredientCommandToIngredient iCToI;
	CategoryCommandToCategory cCToC;
	NotesCommandToNotes nCToN;

	public RecipeCommandToRecipe(IngredientCommandToIngredient iCToI, CategoryCommandToCategory cCToC,
			NotesCommandToNotes nCToN) {
		super();
		this.iCToI = iCToI;
		this.cCToC = cCToC;
		this.nCToN = nCToN;
	}

	@Nullable
	@Synchronized
	@Override
	public Recipe convert(RecipeCommand source) {
		// TODO Auto-generated method stub

		if (source == null)
			return null;

		final Recipe recipe = new Recipe();
		recipe.setId(source.getId());
		recipe.setCookTime(source.getCookTime());
		recipe.setPrepTime(source.getPrepTime());
		recipe.setDescription(source.getDescription());
		recipe.setDifficulty(source.getDifficulty());
		recipe.setDirections(source.getDirections());
		recipe.setServings(source.getServings());
		recipe.setSource(source.getSource());
		recipe.setUrl(source.getUrl());
		recipe.setNotes(nCToN.convert(source.getNotes()));

		if (source.getCategories() != null && source.getCategories().size() > 0) {
			source.getCategories().forEach(category -> recipe.getCategories().add(cCToC.convert(category)));
		}

		if (source.getIngredients() != null && source.getIngredients().size() > 0) {
			source.getIngredients().forEach(ingredient -> recipe.getIngredients().add(iCToI.convert(ingredient)));
		}

		return recipe;

	}

}
