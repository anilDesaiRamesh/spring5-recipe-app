/**
 * 
 */
package com.anil.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.anil.recipe.domain.Ingredient;
import com.anil.recipe.domain.UnitOfMeasure;
import com.anil.recipe.domain.commands.IngredientCommand;
import com.anil.recipe.domain.commands.UnitOfMeasureCommand;

import lombok.Synchronized;

/**
 * @author Anil_Ramesh
 *
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

	private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

	public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure) {
		super();
		this.unitOfMeasureCommandToUnitOfMeasure = unitOfMeasureCommandToUnitOfMeasure;
	}

	@Synchronized
	@Nullable
	@Override
	public Ingredient convert(IngredientCommand source) {
		// TODO Auto-generated method stub
		if (source == null)
			return null;

		final Ingredient ingrdient = new Ingredient();
		ingrdient.setId(source.getId());
		ingrdient.setAmount(source.getAmount());
		ingrdient.setDescription(source.getDescription());
		ingrdient.setUom(unitOfMeasureCommandToUnitOfMeasure.convert(source.getUom()));
		return ingrdient;
	}

}
