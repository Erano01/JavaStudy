package me.erano.com.example1;

import java.util.List;
import java.util.ArrayList;

//Memento -> this class Originators friend class
//Unfortunately some programming languages doesn't support two levels of static protection in that way.
//If you want to adhere to the two levels of static protection when implementing the Memento design pattern according to book,
//create the Memento class as an private inner class within its own Originator or make this class package private.
public class SolverState {
    //Originator
    private ConstraintSolver constraintSolver;
    //States that we have to store. This states needs to be accessible from only its own Originator!
    // (in this implementation we make them package accessible)
    private List<Location> states;
    private int currentStateIndex;

    public SolverState() {
//		states = Collections.synchronizedList(new ArrayList<Location>());
        states = new ArrayList<Location>();
    }

    public void setOriginator(ConstraintSolver constraintSolver) {
        this.constraintSolver = constraintSolver;
    }

    public synchronized void save() {
        Location state = constraintSolver.getState();
        System.out.println("Memento: Saving state: " + state);
        states.add(state);
        currentStateIndex++;
    }

    public synchronized void undo() {
        int tmp = currentStateIndex;
        tmp -= 2;
        Location previousState = states.get(tmp);
        constraintSolver.setState(previousState);
        System.err.println("Memento: Undoing to: " + previousState);
    }


}
