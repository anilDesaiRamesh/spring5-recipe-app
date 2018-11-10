/**
 * 
 */
package com.anil.recipe.commands;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.anil.recipe.converters.IngredientCommandToIngredient;
import com.anil.recipe.converters.UnitOfMeasureCommandToUnitOfMeasure;
import com.anil.recipe.domain.Ingredient;
import com.anil.recipe.domain.Recipe;
import com.anil.recipe.domain.commands.CategoryCommand;
import com.anil.recipe.domain.commands.IngredientCommand;
import com.anil.recipe.domain.commands.UnitOfMeasureCommand;

/**
 * @author Anil_Ramesh
 *
 */
public class IngredientCommandToIngredientTest {

	IngredientCommandToIngredient ingredientCommandToIngredient;

	UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

	public static final Recipe RECIPE = new Recipe();
	public static final BigDecimal AMOUNT = new BigDecimal("1");
	public static final String DESCRIPTION = "Cheeseburger";
	public static final Long ID_VALUE = new Long(1L);
	public static final Long UOM_ID = new Long(2L);

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		unitOfMeasureCommandToUnitOfMeasure = new UnitOfMeasureCommandToUnitOfMeasure();
		ingredientCommandToIngredient = new IngredientCommandToIngredient(unitOfMeasureCommandToUnitOfMeasure);
	}

	/**
	 * Test method for
	 * {@link com.anil.recipe.converters.IngredientCommandToIngredient#convert(com.anil.recipe.domain.commands.IngredientCommand)}.
	 */
	@Test
	public void testConvert() {

		// given
		UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
		unitOfMeasureCommand.setId(UOM_ID);
		unitOfMeasureCommand.setDescription(DESCRIPTION);
		IngredientCommand ingredientCommand = new IngredientCommand();
		ingredientCommand.setId(ID_VALUE);
		ingredientCommand.setAmount(AMOUNT);
		ingredientCommand.setDescription(DESCRIPTION);
		ingredientCommand.setUom(unitOfMeasureCommand);

		// when
		Ingredient ingredient = ingredientCommandToIngredient.convert(ingredientCommand);

		// then
		assertNotNull(ingredient);
		assertNotNull(ingredient.getUom());
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(DESCRIPTION, ingredient.getDescription());
		assertEquals(UOM_ID, ingredient.getUom().getId());

	}

	@Test
	public void testNullObject() {
		assertNull(ingredientCommandToIngredient.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(ingredientCommandToIngredient.convert(new IngredientCommand()));
	}

	@Test
	public void convertWithNullUOM() throws Exception {
		// given
		IngredientCommand command = new IngredientCommand();
		command.setId(ID_VALUE);
		command.setAmount(AMOUNT);
		command.setDescription(DESCRIPTION);
		UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();

		// when
		Ingredient ingredient = ingredientCommandToIngredient.convert(command);

		// then
		assertNotNull(ingredient);
		assertNull(ingredient.getUom());
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(DESCRIPTION, ingredient.getDescription());

	}

}
