package me.erano.com;

import me.erano.com.example1.CaretakerThread;
import me.erano.com.example1.ConstraintSolver;
import me.erano.com.example1.Location;
import me.erano.com.example1.SolverState;

public class Application {

    public static void main(String[] args) {
        //example1 -> GoF implementation way
        /*
        ConstraintSolver originator1 = new ConstraintSolver(new Location(0,0,0));
        SolverState memento1 = originator1.getMemento();

        CaretakerThread caretaker1 = new CaretakerThread(memento1);
        caretaker1.start();*/

        //example2 -> java inner class way (memento is inner class inside Originator)
        me.erano.com.example2.ConstraintSolver originator2 = new me.erano.com.example2.ConstraintSolver(new Location(1,1,1));
        me.erano.com.example2.ConstraintSolver.SolverState memento2 = originator2.getMemento();

        me.erano.com.example2.CaretakerThread caretaker2 = new me.erano.com.example2.CaretakerThread(memento2);
        caretaker2.start();


    }
}
