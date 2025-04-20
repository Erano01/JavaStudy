package me.erano.com.example3;

import java.beans.PropertyChangeListener;

public class BeanUser implements PropertyChangeListener {
    private String name;

    public BeanUser(String name) {
        this.name = name;
    }

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        System.out.println("(Bean) " + name + ", yeni video: " + evt.getNewValue());
    }
}
