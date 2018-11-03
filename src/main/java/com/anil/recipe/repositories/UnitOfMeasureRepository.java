/**
 * 
 */
package com.anil.recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.anil.recipe.domain.UnitOfMeasure;

/**
 * @author Anil_Ramesh
 *
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);

}
