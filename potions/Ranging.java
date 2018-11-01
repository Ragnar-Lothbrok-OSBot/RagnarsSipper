package potions;

import org.osbot.rs07.script.MethodProvider;

import static org.osbot.rs07.api.ui.Skill.RANGED;

public class Ranging extends Potion {

    public Ranging(MethodProvider api, int priority) {
        super(api,"Ranging", RANGED, priority);
    }

    @Override
    public boolean shouldSip() {
        return getSkillDynamicLevel() == getSkillStaticLevel();
    }

}
