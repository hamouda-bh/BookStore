package com.example.Gestion.des.taches.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Gestion.des.taches.project.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
