/**
 * 
 */
package com.anil.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.anil.recipe.domain.Ingredient;
import com.anil.recipe.domain.commands.IngredientCommand;
import com.anil.recipe.domain.commands.UnitOfMeasureCommand;

import lombok.Synchronized;

/**
 * @author Anil_Ramesh
 *
 */
@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

	private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

	public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
		super();
		this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
	}

	@Synchronized
	@Nullable
	@Override
	public IngredientCommand convert(Ingredient source) {
		// TODO Auto-generated method stub

		if (source == null)
			return null;
		UnitOfMeasureCommand convert = unitOfMeasureToUnitOfMeasureCommand.convert(source.getUom());
		final IngredientCommand ingredientCommand = new IngredientCommand();
		ingredientCommand.setId(source.getId());
		ingredientCommand.setAmount(source.getAmount());
		ingredientCommand.setDescription(source.getDescription());
		ingredientCommand.setUom(convert);
		return ingredientCommand;
	}

}
