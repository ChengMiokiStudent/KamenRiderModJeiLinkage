package cheng.kamen_rider_gotchard_jei;

import cheng.kamen_rider_gotchard_jei.kamen_rider_gotchard.AlchemistableJeiRecipe;
import cheng.kamen_rider_gotchard_jei.kamen_rider_gotchard.AlchemistableJeiRecipeCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class KamenriderModJeiPlugin implements IModPlugin {
    // 注册未初始化常量
    public static RecipeType<AlchemistableJeiRecipe> AlchemistableJei_Type;

    public ResourceLocation getPluginUid() {
        return new ResourceLocation("kamen_rider_mod_jei_linkage:jei_plugin");
    }

    // 注册JEI配方类型
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new IRecipeCategory[]{
                new AlchemistableJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper())}
        );
    }

    // 注册绑定目标配方
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = (Objects.requireNonNull(Minecraft.getInstance().level)).getRecipeManager();
        // 炼金术桌
        List<AlchemistableJeiRecipe> AlchemistableJeiRecipes = recipeManager.getAllRecipesFor(AlchemistableJeiRecipe.Type.INSTANCE);
        registration.addRecipes(AlchemistableJei_Type, AlchemistableJeiRecipes);
    }
    // 注册多配方类型
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(
                new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("kamen_rider_gotchard:alchemistable"))),
                AlchemistableJei_Type);
    }

    // 初始化
    static {
        AlchemistableJei_Type = new RecipeType(AlchemistableJeiRecipeCategory.UID, AlchemistableJeiRecipe.class);
    }
}