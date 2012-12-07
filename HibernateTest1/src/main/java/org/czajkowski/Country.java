package org.czajkowski;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRIES")
public class Country {

	private Long id;
	private String name;
	private Integer population;

	public Country () {
	}

	public Country(String name, Integer population) {
		this.name = name;
		this.population = population;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="COUNTRY_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="COUNTRY_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="COUNTRY_POPULATION")
	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}
}
