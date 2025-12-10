package cheng.kamen_rider_mod_jei_linkage.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class KamenriderModJeiLinkageConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // 系统提示设置
    public static final ForgeConfigSpec.BooleanValue PLAYER_LOGIN_MESSAGE;     // 是否允许触发
    public static final ForgeConfigSpec.BooleanValue GOTCHARDHENSHINCARD;     // 是否允许触发
    public static final ForgeConfigSpec.BooleanValue WUXIANZHIQISHI;     // 是否允许触发

    static {
        BUILDER.push("Player Login Messages");
        PLAYER_LOGIN_MESSAGE = BUILDER
                .comment("是否启用玩家进入时发出作者名称等消息(true为是,false为否)")
                .define("是否启用",true);

        BUILDER.push("JEI Gotchard Category");
        GOTCHARDHENSHINCARD = BUILDER
                .comment("是否启用歌查德变身的JEI界面的催化剂(配方左边的工作方块类似的)")
                .define("是否启用",false);

        BUILDER.push("Gotchard Recipe");
        WUXIANZHIQISHI = BUILDER
                .comment("是否启用歌查德变身的JEI界面的配方添加(界面依旧是原来的)")
                .define("是否启用",false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
    /**
     *  游戏内加载使用配置文件
     */
    public static void loadConfig(ForgeConfigSpec config, String path) {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path))
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();
        file.load();
        config.setConfig(file);
    }
}
