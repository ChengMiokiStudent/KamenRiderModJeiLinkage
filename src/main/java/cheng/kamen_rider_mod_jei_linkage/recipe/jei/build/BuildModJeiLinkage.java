package cheng.kamen_rider_mod_jei_linkage.recipe.jei.build;

import cheng.kamen_rider_mod_jei_linkage.KamenRiderModJeiLinkage;
import cheng.kamen_rider_mod_jei_linkage.recipe.ModUtil;
import cheng.kamen_rider_mod_jei_linkage.recipe.build.BuildLoaded;
import cheng.kamen_rider_mod_jei_linkage.recipe.build.FullbottlePurifierJeiRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class BuildModJeiLinkage implements IModPlugin {
    public static RecipeType<FullbottlePurifierJeiRecipe> FullbottlePurifier_JEI;

    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(KamenRiderModJeiLinkage.MODID,"build_linkage");
    }

    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = (Objects.requireNonNull(Minecraft.getInstance().level)).getRecipeManager();
        if (BuildLoaded.KamenRiderBuild.isLoaded()) {
            List<FullbottlePurifierJeiRecipe> this1 = recipeManager.getAllRecipesFor(FullbottlePurifierJeiRecipe.Type.INSTANCE);
            registration.addRecipes(FullbottlePurifier_JEI, this1);
        }
    }
    public void registerCategories(IRecipeCategoryRegistration registration) {
        if (BuildLoaded.KamenRiderBuild.isLoaded()) {
            registration.addRecipeCategories(
                    new FullbottleJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper())
            );
        }
    }
    // 添加催化剂
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        if (BuildLoaded.KamenRiderBuild.isLoaded()) {
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_exvs_over_build:full_bottle_purification_machine"), FullbottlePurifier_JEI);
        }
    }

    static {
        FullbottlePurifier_JEI = new RecipeType<>(FullbottleJeiRecipeCategory.UID, FullbottlePurifierJeiRecipe.class);
    }
}