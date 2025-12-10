package cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard;

import cheng.kamen_rider_mod_jei_linkage.KamenRiderModJeiLinkage;
import cheng.kamen_rider_mod_jei_linkage.recipe.ModUtil;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JeiPlugin
public class GotchardModJeiLinkage implements IModPlugin {

    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(KamenRiderModJeiLinkage.MODID,"gotchard_linkage");
    }

    public void registerRecipes(IRecipeRegistration registration) {
        // 注册物品JEI界面描述
        // 彩虹蛋重要消息
        if (ModList.get().isLoaded("kamen_rider_gotchard"))
            registration.addIngredientInfo(ModUtil.item(rainboweggcard),
                    VanillaTypes.ITEM_STACK,
                    new TranslatableComponent("jei.kamen_rider_gotchard.rainboweggcard_jei"));
    }

    private static final String rainboweggcard = "kamen_rider_gotchard:rainboweggcard";
}