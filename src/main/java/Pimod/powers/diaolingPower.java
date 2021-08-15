package Pimod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.unique.PoisonLoseHpAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import java.util.Iterator;

public class diaolingPower extends AbstractPower {
    public  static final String POWER_ID="diaolingPower";
    private  static  final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    private AbstractCreature source;

    public diaolingPower(AbstractCreature owner,AbstractCreature source, int amount){
        this.name = powerStrings.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.BUFF;
        this.amount= amount;
        this.updateDescription();
        this.img = new Texture("img/powers/generator.png");
        this.source=source;
        updateDescription();
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);
        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT && !AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flashWithoutSound();
            this.addToBot(new PoisonLoseHpAction(this.owner, this.source, this.amount, AbstractGameAction.AttackEffect.POISON));
            this.addToBot(new HealAction(source,source,this.amount));
            this.amount-=1;
        }

    }

    public void update(int slot) {
        super.update(slot);
        if (this.amount == 0) {
            this.addToBot(new RemoveSpecificPowerAction(AbstractDungeon.player,AbstractDungeon.player,this.ID));
        }
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }


}
