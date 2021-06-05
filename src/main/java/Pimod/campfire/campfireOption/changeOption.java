package Pimod.campfire.campfireOption;

import Pimod.campfire.campfireEffect.changeEffect;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import Pimod.tutorial.Tutorial;
public class changeOption extends AbstractCampfireOption {
    private static final UIStrings uiStrings;
    public static final String[] TEXT;

    public changeOption(){
        this.label = TEXT[0];
        this.description = TEXT[1];
        this.img = ImageMaster.CAMPFIRE_DIG_BUTTON;
    }
    public void useOption() {
        AbstractDungeon.effectList.add(new changeEffect());
    }





    static {
        uiStrings = CardCrawlGame.languagePack.getUIString("Change Option");
        TEXT = uiStrings.TEXT;
    }

}

