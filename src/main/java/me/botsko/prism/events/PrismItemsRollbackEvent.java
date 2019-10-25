package me.botsko.prism.events;

import me.botsko.prism.actionlibs.QueryParameters;
import me.botsko.prism.appliers.ApplierResult;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class PrismItemsRollbackEvent extends Event {

	/**
	 * Required by bukkit for proper event handling.
	 */
	private static final HandlerList handlers = new HandlerList();

	/**
	 *
	 */
	private final ArrayList<ItemStack> itemStacks;

	/**
	 *
	 */
	private final Player onBehalfOf;

	/**
	 *
	 */
	private final QueryParameters parameters;

	/**
	 *
	 */
	private final ApplierResult result;

	/**
	 *
	 * @param itemStacks
	 * @param onBehalfOf
	 * @param parameters
	 * @param result
	 */
	public PrismItemsRollbackEvent(ArrayList<ItemStack> itemStacks, Player onBehalfOf,
                                   QueryParameters parameters, ApplierResult result) {
		this.itemStacks = itemStacks;
		this.onBehalfOf = onBehalfOf;
		this.parameters = parameters;
		this.result = result;
	}

	/**
	 * @return the originalBlock
	 */
	public ArrayList<ItemStack> getItemStacks() {
		return itemStacks;
	}

	/**
	 * @return the onBehalfOf
	 */
	public Player onBehalfOf() {
		return onBehalfOf;
	}

	/**
	 * 
	 * @return
	 */
	public QueryParameters getQueryParameters() {
		return parameters;
	}

	/**
	 * 
	 * @return
	 */
	public ApplierResult getResult() {
		return result;
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
