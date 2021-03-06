package openperipheral.core.adapter.thermalexpansion;

import dan200.computer.api.IComputerAccess;
import net.minecraft.tileentity.TileEntity;
import openperipheral.api.IPeripheralAdapter;
import openperipheral.api.LuaMethod;
import openperipheral.api.LuaType;
import openperipheral.api.Arg;
import openperipheral.core.util.ReflectionHelper;

public class AdapterTileLamp implements IPeripheralAdapter {

	private static final String[] SET_COLOR_METHOD_NAME = new String[]{"setColor"};
	private static final Class<?> CLAZZ = ReflectionHelper.getClass("thermalexpansion.block.lamp.TileLamp");
	
	@Override
	public Class<?> getTargetClass() {
		return CLAZZ;
	}
	
	@LuaMethod(description="Sets the colour of the lamp.", returnType=LuaType.BOOLEAN,onTick=false, args={
			@Arg(description="The colour you want to set to (in RGB hexadecimal 0xRRGGBB)", type=LuaType.NUMBER)
	})
	public boolean setColor(IComputerAccess computer, TileEntity tile, int colour) {
		try {
			return (Boolean) ReflectionHelper.callMethod(getTargetClass(), tile, SET_COLOR_METHOD_NAME, colour);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@LuaMethod(description="Sets the colour of the lamp.", returnType=LuaType.BOOLEAN,onTick=false, args={
			@Arg(description="The colour you want to set to (in RGB hexadecimal 0xRRGGBB)", type=LuaType.NUMBER)
	})
	public boolean setColour(IComputerAccess computer, TileEntity tile, int colour) {
		return setColor(computer,tile,colour);
	}

}
