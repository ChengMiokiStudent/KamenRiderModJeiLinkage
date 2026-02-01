package cheng.kamen_rider_mod_jei_linkage.recipe.jei.riderJeiclass;

import cheng.kamen_rider_mod_jei_linkage.config.KamenriderModJeiLinkageConfig;
import cheng.kamen_rider_mod_jei_linkage.recipe.ModRecipeType;
import cheng.kamen_rider_mod_jei_linkage.recipe.ModUtil;
import cheng.kamen_rider_mod_jei_linkage.recipe.jei.gotchard.AlchemistableJeiRecipeCategory;
import cheng.kamen_rider_mod_jei_linkage.recipe.jei.gotchard.GotchardHenshinCardJeiRecipeCategory;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.AlchemistableJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.GotchardHenshinCardJeiRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

import static cheng.kamen_rider_mod_jei_linkage.recipe.jei.ModJeiLinkage.AlchemistableRecipe_Jei;
import static cheng.kamen_rider_mod_jei_linkage.recipe.jei.ModJeiLinkage.GotchardHenshinCard_Type;

public class GotchardJei {
    private static final String rainboweggcard = "kamen_rider_gotchard:rainboweggcard";

    public static void gotchard(IRecipeRegistration registration) {
        RecipeManager recipeManager = (Objects.requireNonNull(Minecraft.getInstance().level)).getRecipeManager();


        List<AlchemistableJeiRecipe> AlchemistableJeiRecipes = recipeManager.getAllRecipesFor(ModRecipeType.Alchemistable.get());// 炼金术桌
        List<GotchardHenshinCardJeiRecipe> GotchardHenshin = recipeManager.getAllRecipesFor(ModRecipeType.GotchardRecipe.get());// 炼金术桌

        registration.addRecipes(AlchemistableRecipe_Jei, AlchemistableJeiRecipes);
        registration.addRecipes(GotchardHenshinCard_Type, GotchardHenshin);

        registration.addIngredientInfo(ModUtil.item(rainboweggcard), VanillaTypes.ITEM_STACK,
                new TranslatableComponent("jei.kamen_rider_gotchard.rainboweggcard_jei"));
        // 注册物品JEI界面描述
    }

    public static void gotchard(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new AlchemistableJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()),
                new GotchardHenshinCardJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

    }

    // 添加催化剂
    public static void gotchard(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:alchemistable"), AlchemistableRecipe_Jei);
        // 变身
        if (KamenriderModJeiLinkageConfig.GOTCHARDHENSHINCARD.get()) {
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:gotcharddriver_leggings"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:gotchardigniter"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:xsaberclosed"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:aichemisdriver_leggings"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:alchemisring"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:valvaradsword"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:valvaradbelt_leggings"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:legenddriver_leggings"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:dreaddriverblank_leggings"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:legendfinishgun"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:legendfinishblankbase"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:goldalchemisdriver_leggings"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:darkalchemisring"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:silvervbbelt_leggings"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:transformationdriver_leggings"), GotchardHenshinCard_Type);
            registration.addRecipeCatalyst(ModUtil.item("kamen_rider_gotchard:ultimagoldalchemisbelt_leggings"), GotchardHenshinCard_Type);
        }
    }
}
