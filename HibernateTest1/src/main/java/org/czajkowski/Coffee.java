package org.czajkowski;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="COFFEES")
public class Coffee {

	private Long id;
	private String name;
	private Country country;
	private Category category;
	private Set<Survey> surveys;

	public Coffee () {
	}

	public Coffee(String name, Country country, Category category, Set<Survey> surveys) {
		this.name = name;
		this.country = country;
		this.category = category;
		this.surveys = surveys;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="COFFEE_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="COFFEE_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="coffee")
	public Set<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(Set<Survey> surveys) {
		this.surveys = surveys;
	}
}
