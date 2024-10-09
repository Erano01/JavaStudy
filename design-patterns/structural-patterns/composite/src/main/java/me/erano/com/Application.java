package me.erano.com;

import me.erano.com.example.Graphic;
import me.erano.com.example.Line;
import me.erano.com.example.Picture;
import me.erano.com.example.Rectangle;
import me.erano.com.example.Text;
import me.erano.com.example2.BinaryFile;
import me.erano.com.example2.Directory;
import me.erano.com.example2.File;
import me.erano.com.example3.SimpleTask;
import me.erano.com.example3.Task;
import me.erano.com.example3.TaskList;

public class Application {

	public static void main(String[] args) {
		
//		ex1
		Graphic line = new Line();
		Graphic rectangle = new Rectangle();
		Graphic text = new Text();
		Graphic picture = new Picture();
		picture.add(line);
		picture.add(rectangle);
		picture.add(text);
		picture.draw();
		picture.getChild(1).draw();
	
//		ex2
		File file1 = new BinaryFile("File1", 1000);
		Directory dir1 = new Directory("dir1");
		dir1.addFile(file1);
		File file2 = new BinaryFile("file2", 2000);
		File file3 = new BinaryFile("file3", 150);
		Directory dir2 = new Directory("dir2");
		dir2.addFile(file2);
		dir2.addFile(file3);
		dir2.addFile(dir1);
		File root1 = dir2;
		root1.ls();
		System.out.println("***********************************");
		File root2 = new BinaryFile("Another file", 200);
		root2.ls();
		
//		ex3
        Task simpleTask1 = new SimpleTask("Complete Coding");
        Task simpleTask2 = new SimpleTask("Write Documentation");
        
        TaskList projectTasks = new TaskList("Project Tasks");
        projectTasks.addTask(simpleTask1);
        projectTasks.addTask(simpleTask2);
 
        TaskList phase1Tasks = new TaskList("Phase 1 Tasks");
        phase1Tasks.addTask(new SimpleTask("Design"));
        phase1Tasks.addTask(new SimpleTask("Implementation"));
 
        projectTasks.addTask(phase1Tasks);
        projectTasks.display();
		
	}
}
