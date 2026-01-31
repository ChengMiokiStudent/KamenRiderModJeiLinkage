package cheng.kamen_rider_mod_jei_linkage.recipe.jei.build;

import cheng.kamen_rider_mod_jei_linkage.KamenRiderModJeiLinkage;
import cheng.kamen_rider_mod_jei_linkage.recipe.ModUtil;
import cheng.kamen_rider_mod_jei_linkage.recipe.build.FullbottlePurifierJeiRecipe;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class FullbottleJeiRecipeCategory implements IRecipeCategory<FullbottlePurifierJeiRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(KamenRiderModJeiLinkage.MODID, "fullbottle_purifier");
    public static final ResourceLocation TEXTURE = new ResourceLocation(KamenRiderModJeiLinkage.MODID, "textures/jei/fullbottle_purifier.png");
    private final IDrawable background;
    private final IDrawable icon;

    public FullbottleJeiRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 196, 89);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, ModUtil.item("kamen_rider_exvs_over_build:full_bottle_purification_machine"));
    }

    @Override
    public @NotNull Component getTitle() {
        return new TranslatableComponent("build.jei.fullbottle_purifier");
    }

    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    public void setRecipe(IRecipeLayoutBuilder builder, FullbottlePurifierJeiRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 124, 35).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 34, 17).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 34, 53).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 34).addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(FullbottlePurifierJeiRecipe recipe, @NotNull IRecipeSlotsView slots, @NotNull PoseStack stack, double mouseX, double mouseY) {
        int levelGuiH = 15;
        int levelGuiK = 56;
        // 绘制自定义信息
        Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.build.draw"), levelGuiK, levelGuiH, 0x404040);
        Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.build.draw1"), 56, 66, 0x404040);
    }

    public ResourceLocation getUid() {
        return UID;
    }

    public @NotNull RecipeType<FullbottlePurifierJeiRecipe> getRecipeType(){
        return new RecipeType<>(UID, FullbottlePurifierJeiRecipe.class);
    }

    public Class<? extends FullbottlePurifierJeiRecipe> getRecipeClass() {
        return FullbottlePurifierJeiRecipe.class;
    }
}