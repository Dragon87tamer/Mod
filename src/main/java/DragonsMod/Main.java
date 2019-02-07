package DragonsMod;

import DragonsMod.Init.ModItems;
import DragonsMod.Init.ModBlocks;
import DragonsMod.Init.ModRecipes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = references.MODID, name=references.MODNAME, version=references.VERSION, acceptedMinecraftVersions=references.ACCEPTED_MINECRAFT_VERSIONS)
public class Main {
	
	@Instance
	public static Main instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(references.MODID + ":preInit");
		ModItems.init();
		ModBlocks.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(references.MODID + ":init");
		ModRecipes.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(references.MODID + ":postInit");
	}
	
}