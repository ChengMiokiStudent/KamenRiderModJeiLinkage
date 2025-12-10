package cheng.kamen_rider_mod_jei_linkage.recipe;

import cheng.kamen_rider_mod_jei_linkage.KamenRiderModJeiLinkage;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.AlchemistableJeiRecipe;
import cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard.GotchardHenshinCardJeiRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
// 模组监听器总线
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JeiLinkageInit {
    // 监听器总线
    // 注册配方序列化器
    @SubscribeEvent
    public static void registerRecipeSerializers(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        event.getRegistry().register(AlchemistableJeiRecipe.Serializer.INSTANCE.setRegistryName(new ResourceLocation(KamenRiderModJeiLinkage.Assest, AlchemistableJeiRecipe.Type.ID)));
        event.getRegistry().register(GotchardHenshinCardJeiRecipe.Serializer.INSTANCE.setRegistryName(new ResourceLocation(KamenRiderModJeiLinkage.Assest, GotchardHenshinCardJeiRecipe.Type.ID)));
    }
}
