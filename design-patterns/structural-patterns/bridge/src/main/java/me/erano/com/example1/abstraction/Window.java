package me.erano.com.example1.abstraction;

import me.erano.com.example1.implementor.WindowImp;

//Abstraction
public abstract class Window {

	//maintains a reference to an object oftype Implementor.
	protected WindowImp windowImp;
	
	protected Window(WindowImp windowImp) {
		this.windowImp = windowImp;
	}
	
	public abstract void drawText();
	public abstract void drawRect();
}
