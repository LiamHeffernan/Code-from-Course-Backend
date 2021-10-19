package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	private static List<Todo> todos = new ArrayList();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "in28minutes", "Play Metroid Dread", new Date("10/8/2021"), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Watch JoJo's Bizarre Adventure: Stone Ocean", new Date("12/1/2021"), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Become SpringBoot and Angular God", new Date("11/20/1998"), true));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn Hungry Like The Wolf by Duran Duran on bass", new Date("10/10/2021"), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Finish Squid Game", new Date("10/4/2021"), true));
	}

	public static List<Todo> findAll() {
		return todos;
	}
	
	public Todo save(Todo todo) {
		if (todo.getId() == -1 || todo.getId() == 0) {
			todo.setId((long) ++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo==null) return null;
		todos.remove(todo);
		return todo;
	}

	public Todo findById(long id) {
		for (Todo todo:todos)
			if (todo.getId() == id)
				return todo;
		return null;
	}
	
	
}
