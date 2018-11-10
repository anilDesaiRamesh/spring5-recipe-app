/**
 * 
 */
package com.anil.recipe.domain.commands;

import java.util.HashSet;
import java.util.Set;

import com.anil.recipe.domain.Difficulty;

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
public class RecipeCommand {
	private Long id;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	private String directions;
	private Difficulty difficulty;
	private Set<IngredientCommand> ingredients = new HashSet<>();
	private Byte[] image;
	private NotesCommand notes;
	private Set<CategoryCommand> categories = new HashSet<>();

}
