package me.erano.com.example.abstraction;

import me.erano.com.example.implementor.WindowImp;

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
