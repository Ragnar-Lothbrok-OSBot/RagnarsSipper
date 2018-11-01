package potions;

import org.osbot.rs07.script.MethodProvider;

import static org.osbot.rs07.api.ui.Skill.PRAYER;

public class Prayer extends Potion {

    private int nextPotionAt = api.random(5, (int) (getSkillStaticLevel() * 0.85));

    public Prayer(MethodProvider api, int priority) {
        super(api,"Prayer potion", PRAYER, priority);
    }

    @Override
    public boolean shouldSip() {
        int prayerPoints = getSkillDynamicLevel();
        return prayerPoints < nextPotionAt;
    }

}
