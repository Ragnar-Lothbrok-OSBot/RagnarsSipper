package potions;

import org.osbot.rs07.script.MethodProvider;

import static org.osbot.rs07.api.ui.Skill.ATTACK;

public class Combat extends Potion {

    public Combat(MethodProvider api, int priority) {
        super(api,"Combat", ATTACK, priority);
    }

    @Override
    public boolean shouldSip() {
        return getSkillDynamicLevel() == getSkillStaticLevel();
    }

}
