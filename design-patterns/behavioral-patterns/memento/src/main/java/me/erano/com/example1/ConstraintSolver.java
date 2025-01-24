package me.erano.com.example1;

//Originator
public class ConstraintSolver {

    //State
    private volatile Location state;
    //Memento that handle our state
    private SolverState solverState = new SolverState();

    public ConstraintSolver(Location state) {
        this.state = state;
        solverState.setOriginator(this);
    }
    public Location getState() {
        return state;
    }

    public synchronized void setState(Location state) {
        System.out.println("\nX: " + state.getX()+" Y: "+ state.getY()+" Z: "+state.getZ());
        this.state = state;
    }

    public SolverState getMemento() {
        return solverState;
    }

    @Override
    public String toString() {
        return "Originator [state=" + state + "]";
    }

}
