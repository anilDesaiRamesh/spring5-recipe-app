/**
 * 
 */
package com.anil.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.anil.recipe.domain.UnitOfMeasure;
import com.anil.recipe.domain.commands.UnitOfMeasureCommand;

import lombok.Synchronized;

/**
 * @author Anil_Ramesh
 *
 */
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasure convert(UnitOfMeasureCommand source) {
		// TODO Auto-generated method stub
		if (source == null)
			return null;

		final UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
		unitOfMeasure.setId(source.getId());
		unitOfMeasure.setDescription(source.getDescription());
		return unitOfMeasure;
	}

}
