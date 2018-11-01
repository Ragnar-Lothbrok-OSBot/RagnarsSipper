package potions;

import org.osbot.rs07.script.MethodProvider;

import static org.osbot.rs07.api.ui.Skill.STRENGTH;

public class Overload extends Potion {

    public Overload(MethodProvider api, int priority) {
        super(api,"Overload", STRENGTH, priority);
    }

    private int minToMs(int min) {
        return min * 60000;
    }

    @Override
    public boolean shouldSip() {
        return getSkillDynamicLevel() == getSkillStaticLevel();
    }
}
