/**
 * 
 */
package com.anil.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.anil.recipe.domain.Category;
import com.anil.recipe.domain.commands.CategoryCommand;

import lombok.Synchronized;

/**
 * @author Anil_Ramesh
 *
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

	@Synchronized
	@Nullable
	@Override
	public Category convert(CategoryCommand source) {
		// TODO Auto-generated method stub
		if (source == null)
			return null;

		final Category category = new Category();
		category.setId(source.getId());
		category.setDescription(source.getDescription());
		return category;
	}

}
