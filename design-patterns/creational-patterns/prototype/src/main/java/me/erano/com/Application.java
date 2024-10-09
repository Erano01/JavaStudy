package me.erano.com;

import me.erano.com.example1.GraphicTool;
import me.erano.com.example1.product.Graphic;
import me.erano.com.example1.product.HalfNote;
import me.erano.com.example1.product.MusicalNote;
import me.erano.com.example1.product.Staff;
import me.erano.com.example1.product.WholeNote;
import me.erano.com.example2.Point3D;
import me.erano.com.example2.Swordsman;

public class Application {

	
	public static void main(String[] args) throws CloneNotSupportedException {
        
//		ex1 -> createGraphic() is cloning
        MusicalNote wholeNotePrototype = new WholeNote();
        MusicalNote halfNotePrototype = new HalfNote();
        Graphic staffPrototype = new Staff();
        GraphicTool wholeNoteTool = new GraphicTool(wholeNotePrototype);
        GraphicTool halfNoteTool = new GraphicTool(halfNotePrototype);
        GraphicTool staffTool = new GraphicTool(staffPrototype);
        Graphic wholeNote1 = wholeNoteTool.createGraphic();
        Graphic wholeNote2 = wholeNoteTool.createGraphic();
        Graphic halfNote1 = halfNoteTool.createGraphic();
        Graphic staff1 = staffTool.createGraphic();
        System.out.println(wholeNote1);
        System.out.println(wholeNote2);
        System.out.println(halfNote1);
        System.out.println(staff1);
        
        
//		ex2
		Swordsman s1 = new Swordsman();
        s1.move(new Point3D(-10,0,0), 20);
        s1.attack();
        System.out.println(s1);
        Swordsman s2 = (Swordsman)s1.clone();
        System.out.println("Cloned swordsman"+s2);
        
//      ex3
        
//      ex?
//      Object.clone() method is an example of a prototype.
        
        
	}
}
