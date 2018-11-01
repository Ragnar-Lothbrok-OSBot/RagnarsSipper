package potions;

import org.osbot.rs07.script.MethodProvider;

import static org.osbot.rs07.api.ui.Skill.ATTACK;

public class SuperCombat extends Potion {

    public SuperCombat(MethodProvider api, int priority) {
        super(api,"Super combat", ATTACK, priority);
    }

    @Override
    public boolean shouldSip() {
        return getSkillDynamicLevel() == getSkillStaticLevel();
    }

}
