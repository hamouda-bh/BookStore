package com.example.Gestion.des.taches.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// application.prop ligne 6 nous ^permet de creer la base de donnes automatiquement au nivea dee mysql grace a jpa
// si on veut changer le nom du colum @Column(name= " ?") 
// si on veut changer le nom du table @Entity(name="?") au niveau de model class

@SpringBootApplication
public class TaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

}
