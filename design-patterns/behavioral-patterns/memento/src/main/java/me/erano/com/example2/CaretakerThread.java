package me.erano.com.example2;

public class CaretakerThread extends Thread{
    private ConstraintSolver.SolverState memento;

    public CaretakerThread(ConstraintSolver.SolverState memento) {
        this.memento = memento;
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            if(i != 0 && i % 5 == 0)
                memento.undo();
            else
                memento.save();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
