package cheng.kamen_rider_gotchard_jei;

import cheng.kamen_rider_gotchard_jei.config.KamenriderModJeiLinkageConfig;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import org.slf4j.Logger;

@Mod("kamen_rider_mod_jei_linkage")
public class KamenRiderModJeiLinkage {

    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String Assest = "kamen_rider_mod_jei_linkage";

    public KamenRiderModJeiLinkage() {
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, KamenriderModJeiLinkageConfig.SPEC, "kamenrider_jei_linkage.toml");
        //游戏内重加载
        KamenriderModJeiLinkageConfig.loadConfig(KamenriderModJeiLinkageConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("kamenrider_jei_linkage.toml").toString());

    }
}
