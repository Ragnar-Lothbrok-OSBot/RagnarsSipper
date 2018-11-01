package potions;

import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.MethodProvider;
import utils.Sleep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public abstract class Potion {

    MethodProvider api;
    String name;
    Skill skill;
    int priority;

    Potion(MethodProvider api, String name, Skill skill, int priority) {
        this.api = api;
        this.name = name;
        this.skill = skill;
        this.priority = priority;
    }

    public void drink() {
        Optional<Item> potion = getPotion();
        if (potion != null && potion.isPresent()) {
            if (potion.get().interact("Drink")) {
                Sleep.sleepUntil(() -> !shouldSip(), 5000);
            }
        }
    }

    Optional<Item> getPotion() {
        Optional<Item> potion = Arrays.stream(api.getInventory().getItems())
                .filter(item -> item != null && item.getName().startsWith(name))
                .min(Comparator.comparing(Item::getName));
        if (potion.isPresent()) {
            return potion;
        } else {
            return null;
        }
    }

    int getSkillDynamicLevel() {
        return api.getSkills().getDynamic(skill);
    }

    int getSkillStaticLevel() {
        return api.getSkills().getStatic(skill);
    }

    public abstract boolean shouldSip();

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
