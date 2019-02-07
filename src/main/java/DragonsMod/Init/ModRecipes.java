package DragonsMod.Init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void init() {
		GameRegistry.addSmelting(ModItems.drake_essence, new ItemStack(ModItems.drake, 1), 1.5f);
		GameRegistry.addSmelting(ModBlocks.drakeore, new ItemStack(ModItems.drake, 2), 0.2f);
	}

}
