package cheng.kamen_rider_mod_jei_linkage;

import cheng.kamen_rider_mod_jei_linkage.config.KamenriderModJeiLinkageConfig;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnPlayerLoggin {
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        execute(event.getPlayer());
    }

    private static void execute(Entity entity) {
        if (entity == null)
            return;
        if (KamenriderModJeiLinkageConfig.PLAYER_LOGIN_MESSAGE.get())
            if (entity instanceof Player _player && !_player.level.isClientSide())
                _player.displayClientMessage(new TextComponent(
                        """
                                歌查德JEI联动:目前只给骑士冒险整合包用，如果用了并且发了整合包或视频请在BiliBili@我\
                                主页：https://space.bilibili.com/1553817658?spm_id_from=333.1369.0.0\
                                B站UID 1553817658\
                                若想关闭请到config文件夹的kamenrider_jei_linkage.toml文件中修改
                                """)
                        , false);
    }
}
