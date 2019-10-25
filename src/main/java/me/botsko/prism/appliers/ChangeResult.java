package me.botsko.prism.appliers;

import me.botsko.prism.events.BlockStateChange;
import me.botsko.prism.events.ItemStackChange;

public class ChangeResult {

	/**
	 * 
	 */
	protected BlockStateChange blockStateChange;

	/**
	 *
	 */
	protected ItemStackChange itemStackChange;

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
	 * @param itemStackChange
	 */
	public ChangeResult(ChangeResultType changeResultType, ItemStackChange itemStackChange) {
		this.itemStackChange = itemStackChange;
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
	public ItemStackChange getItemStackChange() {
		return itemStackChange;
	}

	/**
	 * 
	 * @return
	 */
	public ChangeResultType getType() {
		return changeResultType;
	}
}