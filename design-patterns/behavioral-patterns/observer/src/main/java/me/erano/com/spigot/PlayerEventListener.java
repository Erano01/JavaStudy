package me.erano.com.spigot;

public class PlayerEventListener implements Listener {

    public void onJoin(PlayerJoinEvent event) {
        System.out.println(event.getPlayerName() + " sunucuya katıldı!");
    }
}
