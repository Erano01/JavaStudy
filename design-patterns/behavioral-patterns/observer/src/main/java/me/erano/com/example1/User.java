package me.erano.com.example1;

//Concrete Observer ≈ Listener ≈ Subscriber
public class User implements IObserver {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("(GoF) " + name + ", yeni video yüklendi: " + videoTitle);
    }

    public String getName() {
        return name;
    }
}
