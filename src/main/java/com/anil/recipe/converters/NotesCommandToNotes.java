/**
 * 
 */
package com.anil.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.anil.recipe.domain.Notes;
import com.anil.recipe.domain.commands.NotesCommand;

import lombok.Synchronized;

/**
 * @author Anil_Ramesh
 *
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

	@Synchronized
	@Nullable
	@Override
	public Notes convert(NotesCommand source) {
		// TODO Auto-generated method stub

		if (source == null)
			return null;

		final Notes notes = new Notes();
		notes.setId(source.getId());
		notes.setRecipeNotes(source.getRecipeNotes());
		return notes;
	}

}
