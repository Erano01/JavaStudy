package me.erano.com.example2;

public class HalloweenStationary implements Stationary{

    @Override
    public String getHeader() {
        return "It's Halloween!!";
    }

    @Override
    public String getFooter() {
        return "BUY MORE STUFF! It's Halloween, c'mon!!";
    }
}
