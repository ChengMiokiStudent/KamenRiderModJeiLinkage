package cheng.kamen_rider_mod_jei_linkage;

import cheng.kamen_rider_mod_jei_linkage.config.KamenriderModJeiLinkageConfig;
import cheng.kamen_rider_mod_jei_linkage.recipe.ModRecipeType;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.slf4j.Logger;

@Mod(KamenRiderModJeiLinkage.MODID)
public class KamenRiderModJeiLinkage {

    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "kamen_rider_mod_jei_linkage";

    public KamenRiderModJeiLinkage() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModRecipeType.RECIPE_TYPES.register(modEventBus);
        ModRecipeType.RECIPE_SERIALIZERS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, KamenriderModJeiLinkageConfig.SPEC, "kamenrider_jei_linkage.toml");
        //游戏内重加载
        KamenriderModJeiLinkageConfig.loadConfig(KamenriderModJeiLinkageConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("kamenrider_jei_linkage.toml").toString());

    }
}
