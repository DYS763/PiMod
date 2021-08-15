package Pimod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.unique.PoisonLoseHpAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class withered extends AbstractPower {
    public  static final String POWER_ID="withered";
    private  static  final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    private static final int N=8;
    private final AbstractCreature source;

    public withered(AbstractCreature owner,AbstractCreature source,int amount){
        this.name = powerStrings.NAME;
        this.ID = POWER_ID;
        this.source = source;
        this.owner = owner;
        this.type = PowerType.DEBUFF;
        this.amount= amount;
        this.updateDescription();
        this.img = new Texture("img/powers/generator.png");
        updateDescription();
    }

    public void stackPower(int stackAmount){
        this.amount += stackAmount;
        if(this.amount >= N ){
            this.addToTop(new PoisonLoseHpAction(this.owner, this.source,30, AbstractGameAction.AttackEffect.FIRE));
            this.amount -= N;
        }
        if(this.amount <= 0){
            this.addToTop(new RemoveSpecificPowerAction(this.owner,this.owner,POWER_ID));
        }
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
