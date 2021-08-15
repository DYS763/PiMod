package Pimod.campfire.campfireOption;

import Pimod.campfire.campfireEffect.changeEffect;
import basemod.ReflectionHacks;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.helpers.MathHelper;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.rooms.RestRoom;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import Pimod.tutorial.Tutorial;
public class changeOption extends AbstractCampfireOption {
    private static final UIStrings uiStrings;
    public static final String[] TEXT;
    private boolean used;
    private boolean hacked;
    public changeOption(boolean active){
        this.label = TEXT[0];
        this.description = TEXT[1];
        this.img = ImageMaster.CAMPFIRE_DIG_BUTTON;
        this.usable = active;
    }
    /*
    我觉得代码还是挺好懂的，都是英文 （mole）
    * */


    public void useOption() {
        if(usable){
            AbstractDungeon.effectList.add(new changeEffect());
            this.used = true;
            this.usable=false;
        }
    }

    public void update() {

        //用于实现不占篝火行动的代码，从崩坠扒下来的
        float hackScale = ReflectionHacks.getPrivate(this, AbstractCampfireOption.class, "scale");
        if (this.hb.hovered) {
            if (!this.hb.clickStarted) {
                ReflectionHacks.setPrivate(this, AbstractCampfireOption.class, "scale", MathHelper.scaleLerpSnap(hackScale, Settings.scale));
                ReflectionHacks.setPrivate(this, AbstractCampfireOption.class, "scale", MathHelper.scaleLerpSnap(hackScale, Settings.scale));
            } else {
                ReflectionHacks.setPrivate(this, AbstractCampfireOption.class, "scale", MathHelper.scaleLerpSnap(hackScale, 0.9F * Settings.scale));
            }
        } else {
            ReflectionHacks.setPrivate(this, AbstractCampfireOption.class, "scale", MathHelper.scaleLerpSnap(hackScale, 0.9F * Settings.scale));
        }

        super.update();
        CampfireUI campfire = ((RestRoom)AbstractDungeon.getCurrRoom()).campfireUI;
        if (this.used && !this.hacked) {
            this.hacked = true;
            campfire.somethingSelected = false;
            campfire.touchOption = null;
            campfire.confirmButton.hide();
            campfire.confirmButton.hideInstantly();
            campfire.confirmButton.isDisabled = true;
            AbstractDungeon.overlayMenu.proceedButton.hide();
            AbstractDungeon.overlayMenu.proceedButton.hideInstantly();
            AbstractDungeon.getCurrRoom().phase = AbstractRoom.RoomPhase.INCOMPLETE;
        }

    }



    static {
        uiStrings = CardCrawlGame.languagePack.getUIString("Change Option");
        TEXT = uiStrings.TEXT;
    }

}

