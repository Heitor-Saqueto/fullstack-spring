package com.myfullstackproject.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	@Id //PK
	@GeneratedValue(strategy=GenerationType.IDENTITY) // db generate id
	private Long id;
	
	private String name;
	
	private String description;
	
}
