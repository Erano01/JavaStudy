package me.erano.com;

import me.erano.com.example1.BusinessCardDesigner;
import me.erano.com.example1.Employee;
import me.erano.com.example1.EmployeeClassAdapter;
import me.erano.com.example2.EmployeeObjectAdapter;
import me.erano.com.example3.DrawingEditor;
import me.erano.com.example3.Line;
import me.erano.com.example3.Shape;
import me.erano.com.example3.TextShape;
import me.erano.com.example3.TextView;

public class Application {

	public static void main(String[] args) {
//		ex1
		EmployeeClassAdapter classAdapter = new EmployeeClassAdapter();
		Employee employee = populateEmployeeData(classAdapter); //this is util method, this is optional
		BusinessCardDesigner designer = new BusinessCardDesigner();
		String card1  = designer.designCardCustomer(classAdapter);
		System.out.println(card1);
		
		System.out.println("--------------------------");
		
//		ex2
		EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(employee);
		String card2 = designer.designCardCustomer(objectAdapter);
		System.out.println(card2);
		
		System.out.println("--------------------------");
//		ex3
		DrawingEditor editor = new DrawingEditor();
		String editorOperations = "";
		
		Shape line = new Line();
		editorOperations += editor.draw(line);
		
		TextView adaptee = new TextView();
		Shape adapter = new TextShape(adaptee);
		editorOperations += "\n" + editor.draw(adapter);
		System.out.println(editorOperations);
	}
	
	private static Employee populateEmployeeData(Employee employee) {
		employee.setFullName("Ali");
		employee.setJobTitle("Android Game Developer");
		employee.setOfficeLocation("Microsoft, LA");
		return employee;
	}

}
