package com.example.Gestion.des.taches.project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class UserTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private Date assignemetDate ;
	@ManyToOne
	private Task task;
	@ManyToOne
	private User user;
    
}
