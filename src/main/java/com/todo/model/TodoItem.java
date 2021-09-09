package com.todo.model;

public class TodoItem {

	private int id;
	private String todoDesc;
	private boolean isCompleted;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTodoDesc() {
		return todoDesc;
	}
	public void setTodoDesc(String todoDesc) {
		this.todoDesc = todoDesc;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	public TodoItem() {
		
	}
	
	public TodoItem(int id, String todoDesc, boolean isCompleted) {
		super();
		this.id = id;
		this.todoDesc = todoDesc;
		this.isCompleted = isCompleted;
	}
	
	
	
	
	
	
}
