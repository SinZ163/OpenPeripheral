package openperipheral.api;

import net.minecraft.inventory.IInventory;

public interface IInventoryCallback {
	public void onInventoryChanged(IInventory inventory);
}
