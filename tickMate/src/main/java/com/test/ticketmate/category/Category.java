package com.test.ticketmate.category;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
	@Id
	private String categoryId;
	
	private String categoryTitle;

}
