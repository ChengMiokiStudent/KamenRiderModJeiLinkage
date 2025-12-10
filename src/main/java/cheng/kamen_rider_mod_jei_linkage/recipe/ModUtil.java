package cheng.kamen_rider_mod_jei_linkage.recipe;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class ModUtil {
    public static ItemStack item(String id) {
        return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(id)));
    }
}
