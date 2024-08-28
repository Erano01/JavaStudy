package me.erano.com.example4.product;

//concrete product
public class TextManipulator implements Manipulator{

	@Override
    public void downClick() {
        System.out.println("TextManipulator: down click");
    }

    @Override
    public void drag() {
        System.out.println("TextManipulator: drag");
    }

    @Override
    public void upClick() {
        System.out.println("TextManipulator: up click");
    }
}
