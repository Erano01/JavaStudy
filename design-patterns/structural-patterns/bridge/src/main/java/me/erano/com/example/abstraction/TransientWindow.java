package me.erano.com.example.abstraction;

import me.erano.com.example.implementor.WindowImp;

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
