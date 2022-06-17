package com.saveManager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * A save entity. Each save has a name associated with it, which will be used to find it.<br>
 * 
 * 
 * @author darkm
 *
 */
@Entity
@Data
public class Save {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
}
