package me.botsko.prism.api;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class ItemStackChange {

	/**
	 *
	 */
	private final ItemStack itemStack;

	/**
	 *
	 */
	private final Block block;

	/**
	 *
	 * @param itemStack
	 * @param block
	 */
	public ItemStackChange(ItemStack itemStack, Block block) {
		this.itemStack = itemStack;
		this.block = block;
	}

	/**
	 * @return the originalBlock
	 */
	public ItemStack getItemStack() {
		return itemStack;
	}

	/**
	 * @return the newBlock
	 */
	public Block getBlock() {
		return block;
	}
}