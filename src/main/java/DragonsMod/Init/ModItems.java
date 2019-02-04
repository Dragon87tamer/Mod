package DragonsMod.Init;

import DragonsMod.references;
import DragonsMod.Items.ItemsBasic;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=references.MODID)
public class ModItems {
	
	static Item drake;
	
	public static void init() {
		drake = new DragonsMod.Items.ItemsBasic("drake");
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(drake);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(drake);
	}
	
	private static void registerRender(Item items) {
		ModelLoader.setCustomModelResourceLocation(items, 0, new ModelResourceLocation( items.getRegistryName(), "inventory"));
	}
}