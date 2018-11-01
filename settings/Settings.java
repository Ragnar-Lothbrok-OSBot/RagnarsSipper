package settings;

import potions.Potion;

import java.util.ArrayList;

public class Settings {

    private boolean started = false;
    private boolean shouldTeleport = false;
    private ArrayList<Potion> potionsToManage = new ArrayList<>();

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isShouldTeleport() {
        return shouldTeleport;
    }

    public void setShouldTeleport(boolean shouldTeleport) {
        this.shouldTeleport = shouldTeleport;
    }

    public ArrayList<Potion> getPotionsToManage() {
        return potionsToManage;
    }

    public void setPotionsToManage(ArrayList<Potion> potionsToManage) {
        this.potionsToManage = potionsToManage;
    }
}
