package me.botsko.prism.appliers;

import me.botsko.prism.events.BlockStateChange;
import org.bukkit.inventory.ItemStack;

public class ChangeResult {

	/**
	 * 
	 */
	protected BlockStateChange blockStateChange;

	/**
	 *
	 */
	protected ItemStack itemStack;

	/**
	 * 
	 */
	protected final ChangeResultType changeResultType;

	/**
	 * 
	 * @param changeResultType
	 */
	public ChangeResult(ChangeResultType changeResultType) {
		this.changeResultType = changeResultType;
	}

	/**
	 * 
	 * @param changeResultType
	 * @param blockStateChange
	 */
	public ChangeResult(ChangeResultType changeResultType, BlockStateChange blockStateChange) {
		this.blockStateChange = blockStateChange;
		this.changeResultType = changeResultType;
	}

	/**
	 *
	 * @param changeResultType
	 * @param itemStack
	 */
	public ChangeResult(ChangeResultType changeResultType, ItemStack itemStack) {
		this.itemStack = itemStack;
		this.changeResultType = changeResultType;
	}

	/**
	 * 
	 * @return
	 */
	public BlockStateChange getBlockStateChange() {
		return blockStateChange;
	}

	/**
	 *
	 * @return
	 */
	public ItemStack getItemStack() {
		return itemStack;
	}

	/**
	 * 
	 * @return
	 */
	public ChangeResultType getType() {
		return changeResultType;
	}
}