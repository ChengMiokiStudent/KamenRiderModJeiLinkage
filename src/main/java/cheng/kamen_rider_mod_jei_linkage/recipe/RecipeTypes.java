package cheng.kamen_rider_mod_jei_linkage.recipe;

import cheng.kamen_rider_mod_jei_linkage.KamenRiderModJeiLinkage;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.AlchemistableJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.GotchardHenshinCardJeiRecipe;
import mezz.jei.api.recipe.RecipeType;

public class RecipeTypes {

    public static final RecipeType<AlchemistableJeiRecipe> ALCHEMISTABLEJEI_RECIPE = RecipeType.create(KamenRiderModJeiLinkage.MODID, "alchemistable_jei", AlchemistableJeiRecipe.class);
    public static final RecipeType<GotchardHenshinCardJeiRecipe> GOTCHARDHENSHINCARDJEI_RECIPE = RecipeType.create(KamenRiderModJeiLinkage.MODID, "gotchard_henshin_card", GotchardHenshinCardJeiRecipe.class);

}
