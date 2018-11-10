/**
 * 
 */
package com.anil.recipe.commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.anil.recipe.converters.CategoryCommandToCategory;
import com.anil.recipe.domain.Category;
import com.anil.recipe.domain.commands.CategoryCommand;

/**
 * @author Anil_Ramesh
 *
 */

public class CategoryCommandToCategoryTest {

	CategoryCommandToCategory categoryCommandToCategory;

	public static final Long ID_VALUE = new Long(1L);
	public static final String DESCRIPTION = "description";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		categoryCommandToCategory = new CategoryCommandToCategory();
	}

	/**
	 * Test method for
	 * {@link com.anil.recipe.converters.CategoryCommandToCategory#convert(com.anil.recipe.domain.commands.CategoryCommand)}.
	 */
	@Test
	public void testConvert() {
		// given
		CategoryCommand categoryCommand = new CategoryCommand();
		categoryCommand.setId(ID_VALUE);
		categoryCommand.setDescription(DESCRIPTION);

		// when
		Category category = categoryCommandToCategory.convert(categoryCommand);

		// then
		assertEquals(ID_VALUE, category.getId());
		assertEquals(DESCRIPTION, category.getDescription());

	}

	@Test
	public void testNullObject() {
		assertNull(categoryCommandToCategory.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(categoryCommandToCategory.convert(new CategoryCommand()));
	}

}
