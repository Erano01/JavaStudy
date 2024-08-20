package me.erano.com.example1;

public class Director {

    public void buildFFPLeaderboards(Builder builder) {
        builder
        .setBaseUrl("https://freefoodparty.com")
        .setPath("/leaderboards")
        .addQueryParam("name", "JR_AIZAMK");
    }

}
