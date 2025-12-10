package cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard;

import cheng.kamen_rider_mod_jei_linkage.KamenRiderModJeiLinkage;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javax.annotation.Nullable;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class GotchardHenshinCardJeiRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final int henshinlevel;
    private final String ridername;
    private final String fromname;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public GotchardHenshinCardJeiRecipe(ResourceLocation id, int henshinlevel, String ridername, String fromname, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.henshinlevel = henshinlevel;
        this.ridername = ridername;
        this.fromname = fromname;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return pLevel.isClientSide() ? false : false;
    }

    public int getHenshinlevel(){
        return this.henshinlevel;
    }

    public String getRidername(){
        return this.ridername;
    }

    public String getFromname(){
        return this.fromname;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return this.output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return this.output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Type implements RecipeType<GotchardHenshinCardJeiRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "gotchard_henshin_card";

        private Type() {
        }
    }

    public static class Serializer implements RecipeSerializer<GotchardHenshinCardJeiRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(KamenRiderModJeiLinkage.Assest, Type.ID);
        private ResourceLocation registryName = ID;

        @Override
        public GotchardHenshinCardJeiRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            int henshinlevel = GsonHelper.getAsInt(pSerializedRecipe,"level");
            String ridername = GsonHelper.getAsString(pSerializedRecipe,"rider","gotchard");
            String fromrname = GsonHelper.getAsString(pSerializedRecipe,"from","steamhopper");
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");

            /*NonNullList<Ingredient> inputs = NonNullList.withSize(4, Ingredient.EMPTY);
            for(int i = 0; i < inputs.size(); ++i) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }*/
            // 修复：动态创建列表，检查数组大小
            NonNullList<Ingredient> inputs = NonNullList.create();
            for(int i = 0; i < ingredients.size(); ++i) {
                if (i < 4) { // 只取前11个材料
                    inputs.add(Ingredient.fromJson(ingredients.get(i)));
                }
            }

            // 确保有11个槽位
            while (inputs.size() < 4) {
                inputs.add(Ingredient.EMPTY);
            }

            return new GotchardHenshinCardJeiRecipe(pRecipeId, henshinlevel, ridername, fromrname, output, inputs);
        }

        @Nullable
        @Override
        public GotchardHenshinCardJeiRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); ++i) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }
            int henshinlevel = buf.readInt();
            String ridername = buf.readUtf();
            String fromname = buf.readUtf();

            ItemStack output = buf.readItem();
            return new GotchardHenshinCardJeiRecipe(id, henshinlevel, ridername, fromname, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, GotchardHenshinCardJeiRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for(Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeInt(recipe.getHenshinlevel());
            buf.writeUtf(recipe.getRidername());

            buf.writeItemStack(recipe.getResultItem(), false);
        }

        // 保留并修复 setRegistryName 方法
        @SuppressWarnings("unchecked")
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            this.registryName = name;
            return this;
        }

        // 保留并修复 getRegistryName 方法
        @Nullable
        public ResourceLocation getRegistryName() {
            return this.registryName;
        }

        // 保留并修复 getRegistryType 方法 - 这是关键修复
        @SuppressWarnings("unchecked")
        public Class<RecipeSerializer<?>> getRegistryType() {
            // 使用原始类型转换，但添加了抑制警告
            return (Class<RecipeSerializer<?>>) (Class<?>) RecipeSerializer.class;
        }
    }
}