package me.erano.com.example1;

//Caretaker
public class CaretakerThread extends Thread{

    //memento
    private SolverState solverState;

    public CaretakerThread(SolverState solverState) {
        this.solverState = solverState;
    }

    public void run() {
        for(int i = 0; i < 11; i++) {
            if(i != 0 && i % 5 == 0)
                solverState.undo();
            else
                solverState.save();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
