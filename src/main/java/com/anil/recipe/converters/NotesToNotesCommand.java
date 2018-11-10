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
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

	@Nullable
	@Synchronized
	@Override
	public NotesCommand convert(Notes source) {
		// TODO Auto-generated method stub

		if (source == null)
			return null;

		final NotesCommand notesCommand = new NotesCommand();
		notesCommand.setId(source.getId());
		notesCommand.setRecipeNotes(source.getRecipeNotes());
		return notesCommand;
	}

}
