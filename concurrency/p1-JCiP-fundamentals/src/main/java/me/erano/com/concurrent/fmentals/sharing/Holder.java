package me.erano.com.concurrent.fmentals.sharing;

// Listing 3.15. Class at Risk of Failure if Not Properly Published.
public class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n)
            throw new AssertionError("This statement is false.");
    }
}
