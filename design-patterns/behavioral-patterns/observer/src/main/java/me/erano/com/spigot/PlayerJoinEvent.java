package me.erano.com.spigot;

public class PlayerJoinEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final String playerName;

    public PlayerJoinEvent(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
