package com.example.Gestion.des.taches.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.Gestion.des.taches.project.model.Task;
import com.example.Gestion.des.taches.project.service.StateService;
import com.example.Gestion.des.taches.project.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService ;
	@Autowired
	private StateService stateService;
	
	
	@GetMapping("list-tasks")
	public String listTasks(Model model) {
		model.addAttribute("tasks", taskService.findAll());
			
		return "views/list-tasks";
	}
	
	@GetMapping("add-tasks")
	public String addTasks(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("states", stateService.findAll());
		return "views/add-tasks";
	}
	
	@PostMapping("add-tasks")
	public String addTasks(Model model , Task task) {
		taskService.save(task);
		return "redirect:/add-tasks";
	}
	
	@GetMapping("delete-task")
	public String deleteTask(@RequestParam("idTask") Long id) {
		taskService.delete(id);
		
		return "redirect:/list-tasks";
	}
	@GetMapping("detail-tasks")
	public String detailTasks(@RequestParam("idTask") Long id, Model model) {
		model.addAttribute("taskDB", taskService.findOne(id).get());
		return "views/detail-tasks";
	}
	@GetMapping("edit-task")
	public String editTask(@RequestParam("idTask") Long id, Model model, Task task) {
		model.addAttribute("task", taskService.findOne(id).get());
		model.addAttribute("states", stateService.findAll());

		return "views/add-tasks";
	}

}
