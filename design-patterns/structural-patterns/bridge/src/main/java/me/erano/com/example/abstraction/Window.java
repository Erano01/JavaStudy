package me.erano.com.example.abstraction;

import me.erano.com.example.implementor.WindowImp;

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
