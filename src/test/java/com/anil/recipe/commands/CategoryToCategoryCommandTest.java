/**
 * 
 */
package com.anil.recipe.commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.anil.recipe.converters.CategoryToCategoryCommand;
import com.anil.recipe.domain.Category;
import com.anil.recipe.domain.commands.CategoryCommand;

/**
 * @author Anil_Ramesh
 *
 */
public class CategoryToCategoryCommandTest {

	CategoryToCategoryCommand categoryToCategoryCommand;
	public static final Long ID_VALUE = new Long(1L);
	public static final String DESCRIPTION = "description";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		categoryToCategoryCommand = new CategoryToCategoryCommand();
	}

	/**
	 * Test method for
	 * {@link com.anil.recipe.converters.CategoryToCategoryCommand#convert(com.anil.recipe.domain.Category)}.
	 */
	@Test
	public void testConvert() {
		Category category = new Category();
		category.setId(ID_VALUE);
		category.setDescription(DESCRIPTION);
		CategoryCommand convert = categoryToCategoryCommand.convert(category);
		assertEquals(ID_VALUE, convert.getId());
		assertEquals(DESCRIPTION, convert.getDescription());
	}

	@Test
	public void testNullObject() {
		assertNull(categoryToCategoryCommand.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(categoryToCategoryCommand.convert(new Category()));
	}

}
