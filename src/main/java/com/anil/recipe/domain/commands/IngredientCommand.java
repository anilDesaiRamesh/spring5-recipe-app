/**
 * 
 */
package com.anil.recipe.domain.commands;

import java.math.BigDecimal;

import com.anil.recipe.domain.Ingredient;
import com.anil.recipe.domain.Recipe;
import com.anil.recipe.domain.UnitOfMeasure;

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
public class IngredientCommand {

	private Long id;
	private String description;
	private BigDecimal amount;
	private UnitOfMeasureCommand uom;

}
