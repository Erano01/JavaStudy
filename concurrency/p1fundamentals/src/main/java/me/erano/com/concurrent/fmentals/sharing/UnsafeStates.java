package me.erano.com.concurrent.fmentals.sharing;

// Listing 3.6. Allowing Internal Mutable State to Escape. Don't Do this.
public class UnsafeStates {
    private String[] states = new String[]{
            "AK", "AL"};

    public String[] getStates() {
        return states;
    }
}
