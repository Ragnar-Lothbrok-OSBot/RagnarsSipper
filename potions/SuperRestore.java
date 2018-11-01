package potions;

import org.osbot.rs07.script.MethodProvider;

import static org.osbot.rs07.api.ui.Skill.PRAYER;

public class SuperRestore extends Potion {

    private int nextPotionAt = api.random(5, (int) (getSkillStaticLevel() * 0.85));

    public SuperRestore(MethodProvider api, int priority) {
        super(api,"Super restore", PRAYER, priority);
    }

    @Override
    public boolean shouldSip() {
        int prayerPoints = getSkillDynamicLevel();
        return prayerPoints < nextPotionAt;
    }

}
