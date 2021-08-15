package Pimod.powers;


import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.*;

import java.util.Iterator;

public class wellPreparedPower extends AbstractPower {
    public  static final String POWER_ID="wellPreparedPower";
    private  static  final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;

    public wellPreparedPower(AbstractCreature owner, int amount){
        this.name = powerStrings.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.BUFF;
        this.amount= amount;
        this.updateDescription();
        this.img = new Texture("img/powers/generator.png");
        updateDescription();
    }


    @Override
    public void onPlayCard(AbstractCard card, AbstractMonster m) {
        AbstractPlayer p =AbstractDungeon.player;
        this.addToBot(new ApplyPowerAction(p, p, new experiencePower(p, this.amount), this.amount));
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);
        AbstractPlayer p =AbstractDungeon.player;
        this.addToBot(new RemoveSpecificPowerAction(p,p,this.ID));
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
