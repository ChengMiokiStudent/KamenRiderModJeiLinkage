package cheng.kamen_rider_gotchard_jei;

import cheng.kamen_rider_gotchard_jei.config.KamenriderModJeiLinkageConfig;
import com.google.gson.JsonObject;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnPlayerLoggin {
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        execute(event, event.getPlayer());
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;
        if (KamenriderModJeiLinkageConfig.PLAYER_LOGIN_MESSAGE.get())
            if (entity instanceof Player _player && !_player.level.isClientSide())
                _player.displayClientMessage(new TextComponent("歌查德JEI联动:目前只给骑士冒险整合包用，如果用了并且发了整合包或视频请在BiliBili@我\n主页：https://space.bilibili.com/1553817658?spm_id_from=333.1369.0.0\nB站UID 1553817658"), false);

    }
}
