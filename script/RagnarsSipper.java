package script;

import gui.Gui;
import org.osbot.rs07.script.Script;

import org.osbot.rs07.script.ScriptManifest;
import potions.Potion;
import settings.Settings;

import java.awt.*;

@ScriptManifest(name = "Ragnar's Sipper", author = "Ragnar Lothbrok", version = 1.0, info = "Maintains Potion boost/effects", logo = "")

public class RagnarsSipper extends Script {

    private Settings settings = new Settings();
    private Gui gui = new Gui(settings, this);

    @Override
    public void onStart() {
        gui.main();
    }

    @Override
    public void onExit() {
        //Code here will execute after the script ends
    }

    @Override
    public int onLoop() {
        if (settings.isStarted()) {
            for (Potion potion : settings.getPotionsToManage()) {
                log(potion.getPriority());
                if (potion.shouldSip()) {
                    potion.drink();
                } else {
                    getMouse().moveOutsideScreen();
                }
            }
        }
        return 100; //The amount of time in milliseconds before the loop starts over
    }

    @Override
    public void onPaint(Graphics2D g) {
        //This is where you will put your code for paint(s)
    }

}