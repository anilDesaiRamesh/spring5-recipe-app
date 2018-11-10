/**
 * 
 */
package com.anil.recipe.domain.commands;

import com.anil.recipe.domain.Notes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Anil_Ramesh
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

	private Long id;
	private String recipeNotes;

}
