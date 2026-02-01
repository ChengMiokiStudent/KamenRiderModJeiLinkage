package cheng.kamen_rider_mod_jei_linkage.recipe.jei.gotchard;

import cheng.kamen_rider_mod_jei_linkage.KamenRiderModJeiLinkage;
import cheng.kamen_rider_mod_jei_linkage.config.KamenriderModJeiLinkageConfig;
import cheng.kamen_rider_mod_jei_linkage.recipe.ModRecipeType;
import cheng.kamen_rider_mod_jei_linkage.recipe.ModUtil;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.GotchardHenshinCardJeiRecipe;
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
import org.checkerframework.common.reflection.qual.UnknownMethod;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class GotchardHenshinCardJeiRecipeCategory implements IRecipeCategory<GotchardHenshinCardJeiRecipe> {
    public static final ResourceLocation UID = ModRecipeType.GotchardRecipe.getId();
    public static final ResourceLocation TEXTURE = new ResourceLocation(KamenRiderModJeiLinkage.MODID, "textures/jei/gotchard_henshin_card.png");
    private final IDrawable background;
    private final IDrawable icon;

    public GotchardHenshinCardJeiRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 82);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, ModUtil.item("kamen_rider_gotchard:gotcharddriver_leggings"));
    }

    @Override
    public @NotNull Component getTitle() {
        return new TranslatableComponent("gotchard.jei.gotchard_henshin_card");
    }

    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    public void setRecipe(IRecipeLayoutBuilder builder, GotchardHenshinCardJeiRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 38).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 12).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 128, 38).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 32, 38).addIngredients(recipe.getIngredients().get(3));
    }

    @Override
    public void draw(GotchardHenshinCardJeiRecipe recipe, @NotNull IRecipeSlotsView slots, @NotNull PoseStack stack, double mouseX, double mouseY) {
        int experinenceGuiH = 70;
        int experinenceGuiK = 45;
        int currentRiderH = 1;
        int currentRiderK = 1;
        int currentFormH = currentRiderH;
        int currentFormK = currentRiderK + 8;
        int levelGuiH = 65;
        int levelGuiK = 2;
        // 绘制自定义信息
        switch (recipe.getHenshinlevel()){
            case 1: {
                Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard.henshinlevel1"), levelGuiK, levelGuiH, 0x404040);
                break;
            }
            case 2: {
                Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard.henshinlevel2"), levelGuiK, levelGuiH, 0x404040);
                break;
            }
            case 3: {
                Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard.henshinlevel3"), levelGuiK, levelGuiH, 0x404040);
                break;
            }
            case 4: {
                Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard.henshinlevel4"), levelGuiK, levelGuiH, 0x404040);
                break;
            }
            default: {
                Minecraft.getInstance().font.draw(stack, new TranslatableComponent("jei.kamen_rider_gotchard.level0"), levelGuiK, levelGuiH, 0x404040);
                break;
            }
        }
        putRiderName(recipe,stack,currentRiderH,currentRiderK);
        putFormName(recipe,stack,currentFormH,currentFormK);
    }
    @SuppressWarnings("removal")
    @NotNull
    public ResourceLocation getUid() {
        return UID;
    }

    @SuppressWarnings("removal")
    @NotNull
    public Class<? extends GotchardHenshinCardJeiRecipe> getRecipeClass() {
        return GotchardHenshinCardJeiRecipe.class;
    }

    public void putRiderName(GotchardHenshinCardJeiRecipe recipe, PoseStack stack, int levelGuiK, int levelGuiH){
        if (getCurRider(recipe).equals(recipe.getRidername())) {
            Minecraft.getInstance().font.draw(stack,
                    new TranslatableComponent("jei.kamen_rider_gotchard.henshin.rider.current")
                            .append(new TranslatableComponent("jei.kamen_rider_gotchard.henshin.rider." + getCurRider(recipe))),
                    levelGuiK, levelGuiH, 0x404040);
        }
    }

    public void putFormName(GotchardHenshinCardJeiRecipe recipe, PoseStack stack, int levelGuiK, int levelGuiH){

        if (getCurForm(recipe).equals(recipe.getFromname())) {
            Minecraft.getInstance().font.draw(stack,
                    new TranslatableComponent("jei.kamen_rider_gotchard.henshin.form.current")
                            .append(new TranslatableComponent("jei.kamen_rider_gotchard.henshin.form." + getCurForm(recipe))),
                    levelGuiK, levelGuiH, 0x404040);
        }
    }

    public String getCurRider(GotchardHenshinCardJeiRecipe recipe){
        String currider = recipe.getRidername();
        if (KamenriderModJeiLinkageConfig.WUXIANZHIQISHI.get()) {
            return currider;
        }else {
            if (Objects.equals(currider, "gotchard")) return currider;
            if (Objects.equals(currider, "special_warrior_valvarad")) return currider;
            if (Objects.equals(currider, "valvarad")) return currider;
            if (Objects.equals(currider, "majade")) return currider;
            if (Objects.equals(currider, "wind")) return currider;
            if (Objects.equals(currider, "dread")) return currider;
            if (Objects.equals(currider, "legend")) return currider;
            if (Objects.equals(currider, "eldorado")) return currider;
            else return "default";
        }
    }

    public String getCurForm(GotchardHenshinCardJeiRecipe recipe){
        String curform = recipe.getFromname();
        if (KamenriderModJeiLinkageConfig.WUXIANZHIQISHI.get()) {
            return curform;
        }else {
            if (Objects.equals(curform, "steamhopper")) return curform;
            if (Objects.equals(curform, "appareskebow")) return curform;
            if (Objects.equals(curform, "venommariner")) return curform;
            if (Objects.equals(curform, "antwrestler")) return curform;
            if (Objects.equals(curform, "burninggorilla")) return curform;
            if (Objects.equals(curform, "needlehawk")) return curform;
            // 十级
            if (Objects.equals(curform, "cross_ufox")) return curform;
            if (Objects.equals(curform, "cross_xrex")) return curform;
            if (Objects.equals(curform, "icerex")) return curform;
            if (Objects.equals(curform, "exceedfighter")) return curform;
            if (Objects.equals(curform, "xwizard")) return curform;
            if (Objects.equals(curform, "star_gotchard")) return curform;
            // 火焰
            if (Objects.equals(curform, "fire_steamhopper")) return curform;
            if (Objects.equals(curform, "fire_appareskebow")) return curform;
            // 钢铁、白金和彩虹
            if (Objects.equals(curform, "iron_gotchard")) return curform;
            if (Objects.equals(curform, "platina_gotchard")) return curform;
            if (Objects.equals(curform, "rainbow_gotchard")) return curform;
            // 究极和奇迹
            if (Objects.equals(curform, "ultima_steamhopper")) return curform;
            if (Objects.equals(curform, "miracle_gotchard")) return curform;
            // 黎明
            if (Objects.equals(curform, "daybreak_steamhopper")) return curform;
            if (Objects.equals(curform, "shining_daybreak")) return curform;

            if (Objects.equals(curform, "gutsshovel_custom")) return curform;
            if (Objects.equals(curform, "gekiocopter_custom")) return curform;
            if (Objects.equals(curform, "valvarad")) return curform;
            if (Objects.equals(curform, "valvarad_kurogane")) return curform;

            if (Objects.equals(curform, "sununicorn")) return curform;
            if (Objects.equals(curform, "mooncerberus ")) return curform;
            if (Objects.equals(curform, "twilight_majade")) return curform;

            if (Objects.equals(curform, "blackbahamut_wind")) return curform;

            if (Objects.equals(curform, "dread_0")) return curform;
            if (Objects.equals(curform, "dread_1")) return curform;
            if (Objects.equals(curform, "dread_2")) return curform;
            if (Objects.equals(curform, "dread_3")) return curform;

            if (Objects.equals(curform, "legend")) return curform;
            if (Objects.equals(curform, "legendary_legend")) return curform;
            if (Objects.equals(curform, "gorgeous_kuuga")) return curform;
            if (Objects.equals(curform, "gorgeous_faiz")) return curform;
            if (Objects.equals(curform, "gorgeous_decade")) return curform;

            if (Objects.equals(curform, "gorgeous_zero_two")) return curform;
            if (Objects.equals(curform, "gorgeous_grand_zi_o")) return curform;

            if (Objects.equals(curform, "eld")) return curform;

            else return "default";
        }
    }
}