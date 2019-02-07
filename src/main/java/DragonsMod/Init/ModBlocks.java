package DragonsMod.Init;

import DragonsMod.references;
import DragonsMod.blocks.BlockBasic;
import DragonsMod.blocks.BlockOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=references.MODID)
public class ModBlocks {

	static Block drakeblock;
	public static Block drakeore;
	
	public static void init() {
		drakeblock = new BlockBasic("drakeblock", Material.ROCK).setHardness(15f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setLightLevel(1.0f);
		drakeblock.setHarvestLevel("pickaxe", 3);
		drakeore = new BlockOre("drakeore", Material.ROCK, ModItems.drake_essence, 1, 5).setHardness(10f).setResistance(5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		drakeore.setHarvestLevel("pickaxe", 3);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(drakeblock, drakeore);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(drakeblock).setRegistryName(drakeblock.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(drakeore).setRegistryName(drakeore.getRegistryName()));
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(drakeblock));
		registerRender(Item.getItemFromBlock(drakeore));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}