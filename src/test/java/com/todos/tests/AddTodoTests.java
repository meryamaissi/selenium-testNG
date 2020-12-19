package com.todos.tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.todos.pages.TodoPage;
import com.todos.utils.Setup;

public class AddTodoTests extends Setup {

	public AddTodoTests() throws IOException {
		super();

	}

	TodoPage todopage; 

	@Test()
	public void iCanAddTodo() throws IOException {
		todopage = new TodoPage();
		
		boolean elementText = todopage.isElementDisplayed(TodoPage.inputText);
		Assert.assertTrue(elementText);
		
		todopage.submitTodo(prop.getProperty("todo1"));
		todopage.submitTodo(prop.getProperty("todo2"));

		String elementTodo = todopage.checkElementContains(TodoPage.element1);
		Assert.assertTrue(elementTodo.contains(prop.getProperty("todo1")));
		
		boolean checkbox = todopage.isCheckboxSelected(TodoPage.checkbox);
		Assert.assertFalse(checkbox);
	}


}
