package Pimod.actions;

import Pimod.powers.experiencePower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.ActionType;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class doubleExperienceAction extends AbstractGameAction {
    private AbstractPlayer p;

    public doubleExperienceAction() {
        this.actionType = ActionType.WAIT;
        this.p = AbstractDungeon.player;
        this.duration = Settings.ACTION_DUR_XFAST;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_XFAST && this.p.hasPower("experiencePower")) {
            int strAmt = this.p.getPower("experiencePower").amount;
            this.addToTop(new ApplyPowerAction(this.p, this.p, new experiencePower(this.p, strAmt), strAmt));
        }

        this.tickDuration();
    }
}

