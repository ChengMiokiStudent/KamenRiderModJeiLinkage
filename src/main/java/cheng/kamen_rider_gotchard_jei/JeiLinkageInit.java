package cheng.kamen_rider_gotchard_jei;

import cheng.kamen_rider_gotchard_jei.kamen_rider_gotchard.AlchemistableJeiRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
// 模组监听器总线
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JeiLinkageInit {
    // 监听器总线
    @SubscribeEvent
    public static void registerRecipeSerializers(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        event.getRegistry().register(AlchemistableJeiRecipe.Serializer.INSTANCE.setRegistryName(new ResourceLocation(KamenRiderModJeiLinkage.Assest, "alchemistable_jei")));
    }
}
