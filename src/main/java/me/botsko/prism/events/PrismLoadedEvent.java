package me.botsko.prism.events;

import me.botsko.prism.Prism;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PrismLoadedEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    /**
     *
     */
    private final Prism plugin;

    /**
     * @param plugin
     */
    public PrismLoadedEvent(Prism plugin) {
        this.plugin = plugin;
    }

    /**
     * Required by bukkit for proper event handling.
     */
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Required by bukkit for proper event handling.
     *
     * @return
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }
}