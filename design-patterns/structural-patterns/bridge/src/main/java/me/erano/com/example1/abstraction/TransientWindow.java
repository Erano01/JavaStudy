package me.erano.com.example1.abstraction;

import me.erano.com.example1.implementor.WindowImp;

//RefinedAbstraction
public class TransientWindow extends Window{

	public TransientWindow(WindowImp windowImp) {
		super(windowImp);
	}

	@Override
	public void drawText() {
		windowImp.devDrawText();
		
	}

	@Override
	public void drawRect() {
		windowImp.devDrawLine();
	}
	
}
