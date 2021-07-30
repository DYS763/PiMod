package Pimod.powers.Exm;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.powers.AbstractPower;
import Pimod.others.HasOrb;

import java.util.Iterator;

import static Pimod.others.HasOrb.hasOrb;

public class NoAmoutPowerExm extends AbstractPower {
    public  static final String POWER_ID="name";
    private  static  final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    private static final int N=8;
    private AbstractCreature source;

    public NoAmoutPowerExm(AbstractCreature owner){
        this.name = powerStrings.NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.BUFF;
        this.amount= -1;
        this.updateDescription();
        this.img = new Texture("img/powers/generator.png");
        updateDescription();
    }






    public void update(int slot){
        if(hasOrb("batonOrb")){
        }else {
            this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, "allChoicePower"));
        }
    }

    public int onAttacked(DamageInfo info, int damageAmount) {

        return damageAmount;
    }


    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();
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
