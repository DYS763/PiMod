package Pimod.powers;

import Pimod.card.finish.diamond;
import Pimod.card.finish.emerald;
import Pimod.card.working.obsidian;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.*;

import java.util.Random;

public class cursedPower extends AbstractPower {
    public  static final String POWER_ID="cursedPower";
    private  static  final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;

    public cursedPower(AbstractCreature owner){
        this.name = powerStrings.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.BUFF;
        this.amount= -1;
        this.updateDescription();
        this.img = new Texture("img/powers/generator.png");
        updateDescription();
    }


    public void onUseCard(AbstractCard card, UseCardAction action){
        AbstractCreature p = AbstractDungeon.player;

        Random random = new Random();
        switch (random.nextInt(4)){
            case 0: this.addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p, 2, false), 2));
            break;
            case 1: this.addToBot(new ApplyPowerAction(p, p, new WeakPower(p, 2, false), 2));
            break;
            case 2: this.addToBot(new ApplyPowerAction(p, p, new FrailPower(p,2,false),2));
            break;
            case 3: this.addToBot(new LoseHPAction(p,p,6));
            break;
        }

    }
    public void atStartOfTurn() {
        super.atStartOfTurn();
        this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, "cursedPower"));
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }


}
