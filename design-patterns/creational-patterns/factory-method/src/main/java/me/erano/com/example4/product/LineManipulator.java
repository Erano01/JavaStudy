package me.erano.com.example4.product;

//concrete product
public class LineManipulator implements Manipulator{

	@Override
    public void downClick() {
        System.out.println("LineManipulator: down click");
    }

    @Override
    public void drag() {
        System.out.println("LineManipulator: drag");
    }

    @Override
    public void upClick() {
        System.out.println("LineManipulator: up click");
    }

	
}
