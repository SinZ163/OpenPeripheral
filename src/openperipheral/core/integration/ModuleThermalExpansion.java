package openperipheral.core.integration;

import java.util.Map;

import cofh.api.energy.IEnergyContainerItem;
import cofh.api.item.IInventoryContainerItem;
import cofh.api.item.ISecureItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import openperipheral.core.AdapterManager;
import openperipheral.core.adapter.thermalexpansion.AdapterEnderAttuned;
import openperipheral.core.adapter.thermalexpansion.AdapterEnergyHandler;
import openperipheral.core.adapter.thermalexpansion.AdapterEnergyInfo;
import openperipheral.core.adapter.thermalexpansion.AdapterSecureTile;
import openperipheral.core.adapter.thermalexpansion.AdapterTileLamp;

public class ModuleThermalExpansion {
	public static void init() {
		AdapterManager.addPeripheralAdapter(new AdapterEnergyHandler());
		AdapterManager.addPeripheralAdapter(new AdapterEnderAttuned());
		AdapterManager.addPeripheralAdapter(new AdapterEnergyInfo());
		AdapterManager.addPeripheralAdapter(new AdapterTileLamp());
		AdapterManager.addPeripheralAdapter(new AdapterSecureTile());
	}
	
	public static void appendTEInfo(Map map, ItemStack stack) {
		if (stack != null) {
			Item item = stack.getItem();		
			if (item instanceof IEnergyContainerItem) {
				IEnergyContainerItem energyItem = (IEnergyContainerItem)item;
				map.put("energyStored", energyItem.getEnergyStored(stack));
				map.put("maxEnergyStored", energyItem.getMaxEnergyStored(stack));
			}
			if (item instanceof IInventoryContainerItem) {
				IInventoryContainerItem itemItem = (IInventoryContainerItem)item;
				map.put("sizeInventory", itemItem.getSizeInventory(stack));
				map.put("inventoryContents", itemItem.getInventoryContents(stack));
			}
			if (item instanceof ISecureItem) {
				ISecureItem secureItem = (ISecureItem)item;
				map.put("owner", secureItem.getOwnerString());
			}
		}
	}
}
