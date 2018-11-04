/**
 * 
 */
package com.anil.recipe.repositories;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.anil.recipe.domain.UnitOfMeasure;

/**
 * @author Anil_Ramesh
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Test method for
	 * {@link com.anil.recipe.repositories.UnitOfMeasureRepository#findByDescription(java.lang.String)}.
	 */
	@Test
	//@DirtiesContext
	public void testFindByDescription() {
		Optional<UnitOfMeasure> findByDescription = unitOfMeasureRepository.findByDescription("Teaspoon");
		assertEquals("Teaspoon", findByDescription.get().getDescription());
	}
	
	@Test
	public void testFindByDescriptionCup() {
		Optional<UnitOfMeasure> findByDescription = unitOfMeasureRepository.findByDescription("Cup");
		assertEquals("Cup", findByDescription.get().getDescription());
	}

}
