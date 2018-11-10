/**
 * 
 */
package com.anil.recipe.domain.commands;

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
public class UnitOfMeasureCommand {
	private Long id;
	private String description;

}
