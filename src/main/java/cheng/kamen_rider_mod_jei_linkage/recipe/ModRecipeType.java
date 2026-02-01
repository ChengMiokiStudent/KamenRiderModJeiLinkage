package cheng.kamen_rider_mod_jei_linkage.recipe;

import cheng.kamen_rider_mod_jei_linkage.KamenRiderModJeiLinkage;
import cheng.kamen_rider_mod_jei_linkage.recipe.build.FullbottlePurifierJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.AlchemistableJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.GotchardHenshinCardJeiRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeType {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(
            Registry.RECIPE_TYPE.key(), KamenRiderModJeiLinkage.MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(
            ForgeRegistries.RECIPE_SERIALIZERS, KamenRiderModJeiLinkage.MODID);
    // 歌查德
    public static final RegistryObject<RecipeType<AlchemistableJeiRecipe>> Alchemistable = RECIPE_TYPES.register("alchemistable_jei", () -> registerRecipeType("alchemistable_jei"));
    public static final RegistryObject<RecipeType<GotchardHenshinCardJeiRecipe>> GotchardRecipe = RECIPE_TYPES.register("gotchard_henshin_card", () -> registerRecipeType("gotchard_henshin_card"));

    public static final RegistryObject<RecipeSerializer<?>> AlchemistableSerializer = RECIPE_SERIALIZERS.register("alchemistable_jei", AlchemistableJeiRecipe.Serializer::new);
    public static final RegistryObject<RecipeSerializer<?>> GotchardSerializer = RECIPE_SERIALIZERS.register("gotchard_henshin_card", GotchardHenshinCardJeiRecipe.Serializer::new);

    // 创骑
    public static final RegistryObject<RecipeType<FullbottlePurifierJeiRecipe>> FullbottlePurifier = RECIPE_TYPES.register("fullbottle_purifier", () -> registerRecipeType("fullbottle_purifier"));
    public static final RegistryObject<RecipeSerializer<?>> FullbottlePurifierSerializer = RECIPE_SERIALIZERS.register("fullbottle_purifier", FullbottlePurifierJeiRecipe.Serializer::new);

    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<>() {
            public String toString() {
                return KamenRiderModJeiLinkage.MODID + ":" + identifier;
            }
        };
    }
}
