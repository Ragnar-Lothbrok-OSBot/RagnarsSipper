package potions;

import org.osbot.rs07.script.MethodProvider;

import static org.osbot.rs07.api.ui.Skill.STRENGTH;

public class SuperStrength extends Potion {

    public SuperStrength(MethodProvider api, int priority) {
        super(api,"Super strength", STRENGTH, priority);
    }

    @Override
    public boolean shouldSip() {
        return getSkillDynamicLevel() == getSkillStaticLevel();
    }

}
