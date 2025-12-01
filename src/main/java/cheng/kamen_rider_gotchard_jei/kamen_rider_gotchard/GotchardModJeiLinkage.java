package cheng.kamen_rider_gotchard_jei.kamen_rider_gotchard;

import cheng.kamen_rider_gotchard_jei.KamenRiderModJeiLinkage;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class GotchardModJeiLinkage implements IModPlugin {

    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(":gotchard_linkage");
    }

    public void registerRecipes(IRecipeRegistration registration) {
        // 注册物品JEI界面描述
        // 彩虹蛋重要消息
        registration.addIngredientInfo(List.of(new ItemStack(
                ForgeRegistries.ITEMS.getValue(new ResourceLocation("kamen_rider_gotchard:rainboweggcard")))),
                VanillaTypes.ITEM_STACK, new TranslatableComponent("jei.kamen_rider_gotchard_jei.rainboweggcard_jei"));
    }
}