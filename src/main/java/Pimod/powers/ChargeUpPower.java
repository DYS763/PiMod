package Pimod.powers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower deco
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.AbstractPower.PowerType;
import java.util.Iterator;

public class ChargeUpPower extends AbstractPower {
    public static final String POWER_ID = "ChargeUpPower";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    private static final int ACT_STACK = 8;
    private static final int IMPR_STACK = 6;
    private int cnt;
    private int stc;

    public ChargeUpPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = "ChargeUpPower";
        this.owner = owner;
        if (this.ExhaustionCheck()) {
            this.amount = 0;
        } else {
            this.amount = amount;
        }

        this.type = PowerType.BUFF;
        this.updateDescription();
        this.img = new Texture("img/powers/generator.png");
        this.getDivider();
        this.cnt = this.amount / this.stc;
    }

    public void stackPower(int stackAmount) {
        if (stackAmount <= 0 || !this.ExhaustionCheck()) {
            this.fontScale = 8.0F;
            this.amount += stackAmount;
            if (this.amount <= 0) {
                this.amount = 0;
            }

            this.getDivider();
            this.cnt = this.amount / this.stc;
        }
    }

    public void updateDescription() {
        if (this.cnt > 0) {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1] + "," + DESCRIPTIONS[2] + (int)Math.pow(2.0D, (double)this.cnt) + DESCRIPTIONS[3];
        } else {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1] + ".";
        }

    }

    public void onAfterCardPlayed(AbstractCard card) {
        if (!this.owner.hasPower("OneTimeOffPlusPower") && !this.ExhaustionCheck()) {
            if (this.cnt > 0 && card.type == CardType.ATTACK) {
                this.flash();
                this.getDivider();
            }

        }
    }

    public float atDamageFinalGive(float damage, DamageType type) {
        if (!this.owner.hasPower("OneTimeOffPlusPower") && !this.ExhaustionCheck()) {
            return this.cnt > 0 && type == DamageType.NORMAL && this.amount >= 1 ? (float)((double)damage * Math.pow(2.0D, (double)this.cnt)) : damage;
        } else {
            return damage;
        }
    }

    private void getDivider() {
        if (AbstractDungeon.player.hasRelic("SimpleLauncher")) {
            this.stc = 6;
        } else {
            this.stc = 8;
        }

    }

    private boolean ExhaustionCheck() {
        boolean res = false;
        Iterator var2 = AbstractDungeon.player.hand.group.iterator();

        while(var2.hasNext()) {
            AbstractCard c = (AbstractCard)var2.next();
        }

        return res;
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("ChargeUpPower");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
