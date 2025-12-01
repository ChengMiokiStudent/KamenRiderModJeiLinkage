package cheng.kamen_rider_gotchard_jei.kamen_rider_gotchard;

import cheng.kamen_rider_gotchard_jei.KamenRiderModJeiLinkage;
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
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class AlchemistableJeiRecipeCategory implements IRecipeCategory<AlchemistableJeiRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(KamenRiderModJeiLinkage.Assest, "alchemistable_jei");
    public static final ResourceLocation TEXTURE = new ResourceLocation(KamenRiderModJeiLinkage.Assest, "textures/jei/alchemistable.png");
    private final IDrawable background;
    private final IDrawable icon;

    public AlchemistableJeiRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 91);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("kamen_rider_gotchard:alchemistable"))));
    }

    @Override
    public @NotNull RecipeType<AlchemistableJeiRecipe> getRecipeType() {
        return new RecipeType<>(UID, AlchemistableJeiRecipe.class);
    }

    public @NotNull Component getTitle() {
        return new TranslatableComponent("gotchard.jei.alchemistable");
    }

    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    public void setRecipe(IRecipeLayoutBuilder builder, AlchemistableJeiRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 7, 7).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 25).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 43).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 61).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 43).addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 150, 7).addIngredients(recipe.getIngredients().get(5));
        builder.addSlot(RecipeIngredientRole.INPUT, 132, 25).addIngredients(recipe.getIngredients().get(6));
        builder.addSlot(RecipeIngredientRole.INPUT, 114, 43).addIngredients(recipe.getIngredients().get(7));
        builder.addSlot(RecipeIngredientRole.INPUT, 132, 61).addIngredients(recipe.getIngredients().get(8));
        builder.addSlot(RecipeIngredientRole.INPUT, 150, 42).addIngredients(recipe.getIngredients().get(9));
        builder.addSlot(RecipeIngredientRole.INPUT, 78, 31).addIngredients(recipe.getIngredients().get(10));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 78, 0).addItemStack(recipe.getResultItem());
    }
    @Override
    public void draw(AlchemistableJeiRecipe recipe, @NotNull IRecipeSlotsView slots, @NotNull PoseStack stack, double mouseX, double mouseY) {
        int experinenceGuiH = 70;
        int experinenceGuiK = 45;
        int levelGuiH = 80;
        int levelGuiK = 2;
        // 绘制自定义信息
        switch (recipe.getLevel()){
            case 0: {
                Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard_jei.level0"), levelGuiK, levelGuiH, 0x404040);
                break;
            }
            case 1: {
                Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard_jei.level1"), levelGuiK, levelGuiH, 0x404040);
                if (recipe.getExperinence() != 0)
                    Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard_jei.experinence1").append(String.valueOf(recipe.getExperinence())).append(new TranslatableComponent("jei.kamen_rider_gotchard_jei.experinence11")) , experinenceGuiK, experinenceGuiH, 0x404040);
                break;
            }
            case 2: {
                Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard_jei.level2"), levelGuiK, levelGuiH, 0x404040);
                if (recipe.getExperinence() != 0)
                    Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard_jei.experinence2").append(String.valueOf(recipe.getExperinence())).append(new TranslatableComponent("jei.kamen_rider_gotchard_jei.experinence22")) , experinenceGuiK, experinenceGuiH, 0x404040);
                break;
            }
            case 3: {
                Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard_jei.level3"), levelGuiK, levelGuiH, 0x404040);
                if (recipe.getExperinence() != 0)
                    Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard_jei.experinence3").append(String.valueOf(recipe.getExperinence())).append(new TranslatableComponent("jei.kamen_rider_gotchard_jei.experinence33")) , experinenceGuiK, experinenceGuiH, 0x404040);
                break;
            }
            case 4: {
                Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard_jei.level4"), levelGuiK, levelGuiH, 0x404040);
                break;
            }
        }
    }

    public ResourceLocation getUid() {
        return UID;
    }

    public Class<? extends AlchemistableJeiRecipe> getRecipeClass() {
        return AlchemistableJeiRecipe.class;
    }
}