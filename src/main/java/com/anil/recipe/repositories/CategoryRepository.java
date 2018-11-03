/**
 * 
 */
package com.anil.recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.anil.recipe.domain.Category;

/**
 * @author Anil_Ramesh
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);

}
