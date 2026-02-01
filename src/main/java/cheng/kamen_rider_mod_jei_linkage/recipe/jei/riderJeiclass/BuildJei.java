package cheng.kamen_rider_mod_jei_linkage.recipe.jei.riderJeiclass;

import cheng.kamen_rider_mod_jei_linkage.recipe.ModRecipeType;
import cheng.kamen_rider_mod_jei_linkage.recipe.ModUtil;
import cheng.kamen_rider_mod_jei_linkage.recipe.build.FullbottlePurifierJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.jei.ModJeiLinkage;
import cheng.kamen_rider_mod_jei_linkage.recipe.jei.build.FullbottleJeiRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

public class BuildJei {
    public static void build(IRecipeRegistration registration) {
        RecipeManager recipeManager = (Objects.requireNonNull(Minecraft.getInstance().level)).getRecipeManager();
        List<FullbottlePurifierJeiRecipe> fullbottle = recipeManager.getAllRecipesFor(ModRecipeType.FullbottlePurifier.get());
        registration.addRecipes(ModJeiLinkage.FullbottlePurifier_JEI, fullbottle);
    }
    public static void build(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new FullbottleJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }
    // 添加催化剂
    public static void build(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(ModUtil.item("kamen_rider_exvs_over_build:full_bottle_purification_machine"), ModJeiLinkage.FullbottlePurifier_JEI);
    }
}
