package potions;

import org.osbot.rs07.script.MethodProvider;

import static org.osbot.rs07.api.ui.Skill.DEFENCE;

public class SuperDefence extends Potion {

    public SuperDefence(MethodProvider api, int priority) {
        super(api,"Super defence", DEFENCE, priority);
    }

    @Override
    public boolean shouldSip() {
        return getSkillDynamicLevel() == getSkillStaticLevel();
    }

}
