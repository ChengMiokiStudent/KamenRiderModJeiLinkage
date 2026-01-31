package cheng.kamen_rider_mod_jei_linkage.recipe.jei.gotchard;

import cheng.kamen_rider_mod_jei_linkage.KamenRiderModJeiLinkage;
import cheng.kamen_rider_mod_jei_linkage.config.KamenriderModJeiLinkageConfig;
import cheng.kamen_rider_mod_jei_linkage.recipe.ModUtil;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.AlchemistableJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.GotchardHenshinCardJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.KamenRiderGotchardLoaded;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class GotchardModJeiLinkage implements IModPlugin {
    public static RecipeType<AlchemistableJeiRecipe> AlchemistableRecipe_Jei;
    public static RecipeType<GotchardHenshinCardJeiRecipe> GotchardHenshinCard_Type;
//    public static RecipeType<FullbottlePurifierJeiRecipe> FullbottlePurifier_JEI;

    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(KamenRiderModJeiLinkage.MODID,"gotchard_linkage");
    }

    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = (Objects.requireNonNull(Minecraft.getInstance().level)).getRecipeManager();
        if (KamenRiderGotchardLoaded.KamenRiderGotchard.isLoaded()) {
            // 炼金术桌
            List<AlchemistableJeiRecipe> AlchemistableJeiRecipes = recipeManager.getAllRecipesFor(AlchemistableJeiRecipe.Type.INSTANCE);
            registration.addRecipes(AlchemistableRecipe_Jei, AlchemistableJeiRecipes);

            List<GotchardHenshinCardJeiRecipe> WizardJeiRecipes = recipeManager.getAllRecipesFor(GotchardHenshinCardJeiRecipe.Type.INSTANCE);
            registration.addRecipes(GotchardHenshinCard_Type, WizardJeiRecipes);

            registration.addIngredientInfo(ModUtil.item(rainboweggcard),
                    VanillaTypes.ITEM_STACK,
                    new TranslatableComponent("jei.kamen_rider_gotchard.rainboweggcard_jei"));

        }
//        List<FullbottlePurifierJeiRecipe> this1 = recipeManager.getAllRecipesFor(FullbottlePurifierJeiRecipe.Type.INSTANCE);
//        registration.addRecipes(FullbottlePurifier_JEI, this1);
        // 注册物品JEI界面描述
    }
    public void registerCategories(IRecipeCategoryRegistration registration) {
        if (KamenRiderGotchardLoaded.KamenRiderGotchard.isLoaded()) {
            registration.addRecipeCategories(
                    new AlchemistableJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()),
                    new GotchardHenshinCardJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper())
            );
        }
//        registration.addRecipeCategories(
//                new FullbottleJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper())
//        );
    }
    // 添加催化剂
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
//        registration.addRecipeCatalyst(ModUtil.item("kamen_rider_exvs_over_build:full_bottle_purification_machine"), FullbottlePurifier_JEI);

        if (KamenRiderGotchardLoaded.KamenRiderGotchard.isLoaded()) {
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

    private final String rainboweggcard = "kamen_rider_gotchard:rainboweggcard";
    static {
//        FullbottlePurifier_JEI = new RecipeType<>(FullbottleJeiRecipeCategory.UID, FullbottlePurifierJeiRecipe.class);
        AlchemistableRecipe_Jei = new RecipeType<>(AlchemistableJeiRecipeCategory.UID, AlchemistableJeiRecipe.class);
        GotchardHenshinCard_Type = new RecipeType<>(GotchardHenshinCardJeiRecipeCategory.UID, GotchardHenshinCardJeiRecipe.class);
    }
}