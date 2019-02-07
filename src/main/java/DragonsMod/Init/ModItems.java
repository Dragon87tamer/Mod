package DragonsMod.Init;

import DragonsMod.references;
import DragonsMod.Items.ItemsBasic;
import DragonsMod.Items.tools.drakepic;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=references.MODID)
public class ModItems {
	
	static Item drake;
	public static Item drake_essence;
	static Item drakepic;
	
	public static final ToolMaterial draco = EnumHelper.addToolMaterial("draco", 3, 3000, 30f, 2.0f, 30);
	
	static final CreativeTabs DrakeLand = (new CreativeTabs("Drake Land") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(drake);
		}

		
		@Override
		public boolean hasSearchBar() {
			return true;
		}
		
	}.setBackgroundImageName("item_search.png"));

		
	public static void init() {
		drake = new DragonsMod.Items.ItemsBasic("drake").setCreativeTab(DrakeLand);
		drake_essence = new DragonsMod.Items.ItemsBasic("drake_essence").setCreativeTab(DrakeLand);
	    drakepic = new DragonsMod.Items.ItemsBasic("drakepic").setCreativeTab(DrakeLand);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(drake,drake_essence,drakepic);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(drake);
		registerRender(drake_essence);
		registerRender(drakepic);
	}
	
	private static void registerRender(Item items) {
		ModelLoader.setCustomModelResourceLocation(items, 0, new ModelResourceLocation( items.getRegistryName(), "inventory"));
	}
}