/**
 * 
 */
package com.anil.recipe.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Anil_Ramesh
 *
 */
@Data
@EqualsAndHashCode(exclude="uom")
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;

	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;
	@ManyToOne
	private Recipe recipe;

	public Ingredient(String descritpion, BigDecimal amount, UnitOfMeasure uom) {
		// TODO Auto-generated constructor stub
		this.description = description;
		this.amount = amount;
		this.uom = uom;

	}

	public Ingredient(String descritpion, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
		// TODO Auto-generated constructor stub
		this.description = description;
		this.amount = amount;
		this.uom = uom;
		this.recipe = recipe;

	}

	

}
