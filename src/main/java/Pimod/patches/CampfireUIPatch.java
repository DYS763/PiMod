package Pimod.patches;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Pimod.campfire.campfireOption.changeOption;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertLocator;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import java.util.ArrayList;
import javassist.CtBehavior;
import Pimod.campfire.*;

public class CampfireUIPatch {
    public CampfireUIPatch() {
    }

    public static void addChangeOption(ArrayList<AbstractCampfireOption> buttons) {
        buttons.add(new changeOption(true));
    }

    public static class InitializeButtonsPatchLocator extends SpireInsertLocator {
        public InitializeButtonsPatchLocator() {
        }

        public int[] Locate(CtBehavior methodToPatch) throws Exception {
            int[] retVal = new int[]{0};
            return retVal;
        }
    }

    @SpirePatch(
            clz = CampfireUI.class,
            method = "initializeButtons"
    )
    public static class InitializeButtonsPatch {
        public InitializeButtonsPatch() {
        }

        @SpireInsertPatch(
                locator = CampfireUIPatch.InitializeButtonsPatchLocator.class,
                localvars = {"buttons"}
        )
        public static void patch(CampfireUI thiz, ArrayList<AbstractCampfireOption> buttons) {
            CampfireUIPatch.addChangeOption(buttons);
        }
    }
}
