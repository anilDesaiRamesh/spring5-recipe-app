/**
 * 
 */
package com.anil.recipe.domain.commands;

import com.anil.recipe.domain.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Anil_Ramesh
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {

	private Long id;
	private String description;

}
