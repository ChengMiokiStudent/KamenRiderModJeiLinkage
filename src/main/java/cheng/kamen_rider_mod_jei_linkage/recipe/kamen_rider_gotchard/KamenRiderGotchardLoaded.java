package cheng.kamen_rider_mod_jei_linkage.recipe.kamen_rider_gotchard;

import net.minecraftforge.fml.ModList;

public enum KamenRiderGotchardLoaded {
    KamenRiderGotchard("kamen_rider_gotchard");
    private final boolean loaded;

    KamenRiderGotchardLoaded(String modid) {
        this.loaded = ModList.get() != null && ModList.get().getModContainerById(modid).isPresent();
    }

    public boolean isLoaded() {
        return this.loaded;
    }
}
