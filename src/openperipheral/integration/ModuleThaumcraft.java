package openperipheral.integration;

import java.util.HashMap;

import openperipheral.AdapterManager;
import openperipheral.adapter.thaumcraft.AdapterAspectContainer;
import openperipheral.adapter.thaumcraft.AdapterNode;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

public class ModuleThaumcraft {
	public static void init() {
		AdapterManager.addPeripheralAdapter(new AdapterAspectContainer());
		AdapterManager.addPeripheralAdapter(new AdapterNode());
	}

	public static void entityToMap(Entity entity, HashMap map, Vec3 relativePos) {
		// TODO: Add whisps and that zombie thing
	}
}