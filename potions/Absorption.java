package potions;

import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.input.mouse.InventorySlotDestination;
import org.osbot.rs07.script.MethodProvider;
import utils.InventoryPattern;
import utils.Sleep;

import java.util.ArrayList;
import java.util.List;

public class Absorption extends Potion {

    private List<Integer> clickedSlots = new ArrayList<>();
    private int nextPotionAt = api.random(50, 500);

    public Absorption(MethodProvider api, int priority) {
        super(api,"Absorption", null, priority);
    }

    @Override
    public void drink() {
        while (getCurrentAbsorptionLevel() < 950 && getPotion() != null) {
            for (int clickSlot : InventoryPattern.CLICK_PATTERN.REGULAR.getPattern()) {
                Item item = api.getInventory().getItemInSlot(clickSlot);
                if (item != null) {
                    if (item.getName().contains(name) && !clickedSlots.contains(clickSlot) && getCurrentAbsorptionLevel() < 950) {
                        int absorptionLevel = getCurrentAbsorptionLevel();
                        InventorySlotDestination potSlot = new InventorySlotDestination(api.getBot(), clickSlot);
                        if (api.getMouse().move(potSlot)) {
                            if (api.getMouse().click(false)) {
                                Sleep.sleepUntil(() -> absorptionLevel < getCurrentAbsorptionLevel(), 5000);
                            }
                        }
                        clickedSlots.add(clickSlot);
                    }
                }
            }
            clickedSlots.clear();
        }
        nextPotionAt = api.random(50, 500);
    }

    @Override
    public boolean shouldSip() {
        return getCurrentAbsorptionLevel() <= nextPotionAt;
    }

    private int getCurrentAbsorptionLevel() {
        final RS2Widget widget = api.getWidgets().get(202, 3, 5);
        if (widget != null && widget.isVisible() && widget.getMessage() != null)
            return Integer.parseInt(widget.getMessage().replace(",", ""));
        return 0;
    }

}
