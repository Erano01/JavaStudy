package me.erano.com.example1.abstraction;

import me.erano.com.example1.implementor.WindowImp;

//RefinedAbstraction
public class IconWindow extends Window{

	public IconWindow(WindowImp windowImp) {
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
