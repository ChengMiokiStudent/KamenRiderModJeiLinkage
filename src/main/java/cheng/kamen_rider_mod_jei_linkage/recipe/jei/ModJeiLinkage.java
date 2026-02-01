package cheng.kamen_rider_mod_jei_linkage.recipe.jei;

import cheng.kamen_rider_mod_jei_linkage.KamenRiderModJeiLinkage;
import cheng.kamen_rider_mod_jei_linkage.recipe.build.BuildLoaded;
import cheng.kamen_rider_mod_jei_linkage.recipe.build.FullbottlePurifierJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.jei.build.FullbottleJeiRecipeCategory;
import cheng.kamen_rider_mod_jei_linkage.recipe.jei.gotchard.AlchemistableJeiRecipeCategory;
import cheng.kamen_rider_mod_jei_linkage.recipe.jei.gotchard.GotchardHenshinCardJeiRecipeCategory;
import cheng.kamen_rider_mod_jei_linkage.recipe.jei.riderJeiclass.BuildJei;
import cheng.kamen_rider_mod_jei_linkage.recipe.jei.riderJeiclass.GotchardJei;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.AlchemistableJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.GotchardHenshinCardJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.KamenRiderGotchardLoaded;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class ModJeiLinkage implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(KamenRiderModJeiLinkage.MODID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        if (BuildLoaded.KamenRiderBuild.isLoaded())
            BuildJei.build(registration);
        if (KamenRiderGotchardLoaded.KamenRiderGotchard.isLoaded())
            GotchardJei.gotchard(registration);
    }

    public void registerCategories(IRecipeCategoryRegistration registration) {
        if (BuildLoaded.KamenRiderBuild.isLoaded())
            BuildJei.build(registration);
        if (KamenRiderGotchardLoaded.KamenRiderGotchard.isLoaded())
            GotchardJei.gotchard(registration);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        if (BuildLoaded.KamenRiderBuild.isLoaded())
            BuildJei.build(registration);
        if (KamenRiderGotchardLoaded.KamenRiderGotchard.isLoaded())
            GotchardJei.gotchard(registration);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
    }

    public static RecipeType<FullbottlePurifierJeiRecipe> FullbottlePurifier_JEI =
            new RecipeType<>(FullbottleJeiRecipeCategory.UID, FullbottlePurifierJeiRecipe.class);

    public static RecipeType<AlchemistableJeiRecipe> AlchemistableRecipe_Jei = new RecipeType<>(AlchemistableJeiRecipeCategory.UID, AlchemistableJeiRecipe.class);
    public static RecipeType<GotchardHenshinCardJeiRecipe> GotchardHenshinCard_Type = new RecipeType<>(GotchardHenshinCardJeiRecipeCategory.UID, GotchardHenshinCardJeiRecipe.class);
}
