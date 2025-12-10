package cheng.kamen_rider_mod_jei_linkage.recipe.jei;

import cheng.kamen_rider_mod_jei_linkage.KamenRiderModJeiLinkage;
import cheng.kamen_rider_mod_jei_linkage.config.KamenriderModJeiLinkageConfig;
import cheng.kamen_rider_mod_jei_linkage.recipe.ModUtil;
import cheng.kamen_rider_mod_jei_linkage.recipe.jei.gotchard.AlchemistableJeiRecipeCategory;
import cheng.kamen_rider_mod_jei_linkage.recipe.jei.gotchard.GotchardHenshinCardJeiRecipeCategory;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.AlchemistableJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.GotchardHenshinCardJeiRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class KamenriderModJeiPlugin implements IModPlugin {

    public static RecipeType<AlchemistableJeiRecipe> AlchemistableRecipe_Jei;
    public static RecipeType<GotchardHenshinCardJeiRecipe> GotchardHenshinCard_Type;

    private static final ResourceLocation ID = new ResourceLocation(KamenRiderModJeiLinkage.MODID, "jei_plugin");

    // 注册JEI配方类型
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new IRecipeCategory[]{
                new AlchemistableJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()),
                new GotchardHenshinCardJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper())}
        );
    }

    // 注册绑定目标配方
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = (Objects.requireNonNull(Minecraft.getInstance().level)).getRecipeManager();
        // 炼金术桌
        List<AlchemistableJeiRecipe> AlchemistableJeiRecipes = recipeManager.getAllRecipesFor(AlchemistableJeiRecipe.Type.INSTANCE);
        registration.addRecipes(AlchemistableRecipe_Jei, AlchemistableJeiRecipes);

        List<GotchardHenshinCardJeiRecipe> WizardJeiRecipes = recipeManager.getAllRecipesFor(GotchardHenshinCardJeiRecipe.Type.INSTANCE);
        registration.addRecipes(GotchardHenshinCard_Type, WizardJeiRecipes);
    }


    // 添加催化剂
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
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

    // 转移物品的接口方法
    //@Override
    //public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {}

    public ResourceLocation getPluginUid() {
        return ID;
    }

    // 初始化
    static {
        AlchemistableRecipe_Jei = new RecipeType(AlchemistableJeiRecipeCategory.UID, AlchemistableJeiRecipe.class);
        GotchardHenshinCard_Type = new RecipeType(GotchardHenshinCardJeiRecipeCategory.UID, GotchardHenshinCardJeiRecipe.class);
    }
}