package com.nomenclatureapps.exercise.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "nomenclatures")
@NoArgsConstructor
@AllArgsConstructor
public class Nomenclatures implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name ="orderId")
	private long orderId;
	
	@Column(name ="level")
	private int level;
	
	@Column(name ="code")
	private String code;
	
	@Column(name ="parent")
	private String parent;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="itemIncludes")
	private String itemIncludes;
	
	@Column(name ="itemAlsoIncludes")
	private String itemAlsoIncludes;
	
	@Column(name ="rulings")
	private String rulings;
	
	@Column(name ="itemExcludes")
	private String itemExcludes;
	
	@Column(name ="referenceToISIC")
	private String referenceToISIC;
	
	
	
	@Override
	public String toString() {
		return "Nomenclatures [id=" + id + ", orderId=" + orderId + ", level=" + level + ", code=" + code + ", parent="
				+ parent + ", description=" + description + ", itemIncludes=" + itemIncludes + ", itemAlsoIncludes="
				+ itemAlsoIncludes + ", rulings=" + rulings + ", itemExcludes=" + itemExcludes + ", referenceToISIC="
				+ referenceToISIC + "]";
	}

	

}
