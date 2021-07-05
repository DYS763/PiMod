package Pimod.powers;


import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class beatBackPower extends AbstractPower {
    private static final Logger logger = LogManager.getLogger(com.megacrit.cardcrawl.powers.ThornsPower.class.getName());
    public static final String POWER_ID = "beatBack";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;

    public beatBackPower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = "beatBack";
        this.owner = owner;
        this.amount = -1;

        this.updateDescription();
        this.loadRegion("beatBack");
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.type != DamageType.THORNS && info.type != DamageType.HP_LOSS && info.owner != null && info.owner != this.owner) {
            this.flash();
            this.addToTop(new DamageAction(info.owner, new DamageInfo(this.owner, 20 , DamageType.THORNS),
                    AttackEffect.SLASH_HORIZONTAL, true));

            this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, "beatBack"));
        }

        return damageAmount;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("beatBack");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}