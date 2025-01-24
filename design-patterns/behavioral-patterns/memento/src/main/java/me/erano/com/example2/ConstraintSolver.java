package me.erano.com.example2;

import me.erano.com.example1.Location;

import java.util.ArrayList;
import java.util.List;

public class ConstraintSolver {

    private volatile Location state;
    private ConstraintSolver.SolverState memento = new ConstraintSolver.SolverState();

    public ConstraintSolver(Location state) {
        this.state = state;
        memento.setOriginator(this);
    }

    public synchronized void setState(Location state) {
        System.out.println("\nX: " + state.getX()+" Y: "+ state.getY()+" Z: "+state.getZ());
        this.state = state;
    }

    public ConstraintSolver.SolverState getMemento() {
        return memento;
    }

    @Override
    public String toString() {
        return "Originator [state=" + state + "]";
    }

    public class SolverState {
        private ConstraintSolver originator;
        private List<Location> states;
        private int position = 0;

        public SolverState() {
//			states = Collections.synchronizedList(new ArrayList<String>());
            states = new ArrayList<Location>();
        }

        public void setOriginator(ConstraintSolver originator) {
            this.originator = originator;
        }

        public synchronized void save() {
            Location state = originator.state;
            System.out.println("Memento: Saving state: " + state);
            states.add(state);
            position++;
        }

        public synchronized void undo() {
            int currentPosition = position;
            currentPosition -= 2;
            Location previousState = states.get(currentPosition);
            originator.setState(previousState);
            System.err.println("Memento: Undoing to: " + previousState);
        }
    }
}
