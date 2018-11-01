package potions;

import org.osbot.rs07.script.MethodProvider;

import static org.osbot.rs07.api.ui.Skill.ATTACK;

public class SuperAttack extends Potion {

    public SuperAttack(MethodProvider api, int priority) {
        super(api,"Super attack", ATTACK, priority);
    }

    @Override
    public boolean shouldSip() {
        return getSkillDynamicLevel() == getSkillStaticLevel();
    }

}
