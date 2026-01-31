package cheng.kamen_rider_mod_jei_linkage.recipe.build;

import net.minecraftforge.fml.ModList;

public enum BuildLoaded {
    KamenRiderBuild("kamen_rider_exvs_over_build");
    private final boolean loaded;

    BuildLoaded(String modid) {
        this.loaded = ModList.get() != null && ModList.get().getModContainerById(modid).isPresent();
    }

    public boolean isLoaded() {
        return this.loaded;
    }
}
