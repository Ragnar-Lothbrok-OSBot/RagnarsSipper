package potions;

import org.osbot.rs07.script.MethodProvider;

import static org.osbot.rs07.api.ui.Skill.MAGIC;

public class Magic extends Potion {

    public Magic(MethodProvider api, int priority) {
        super(api,"Magic", MAGIC, priority);
    }

    @Override
    public boolean shouldSip() {
        return getSkillDynamicLevel() == getSkillStaticLevel();
    }

}
