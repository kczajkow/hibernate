package org.czajkowski;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SURVEYS")
public class Survey {

	private Long id;
	private Customer customer;
	private Coffee coffee;
	private Integer stars;

	public Survey() {
	}

	public Survey(Customer customer, Coffee coffee, Integer stars) {
		this.customer = customer;
		this.coffee = coffee;
		this.stars = stars;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SURVEY_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne
	@JoinColumn(name="COFFEE_ID")
	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	@Column(name="SURVEY_STARS")
	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}
}
