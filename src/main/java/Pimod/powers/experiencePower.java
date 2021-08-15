package Pimod.powers;



import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.*;

import java.util.Iterator;

public class experiencePower extends AbstractPower {
    public  static final String POWER_ID="experiencePower";
    private  static  final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    public static int attackNum=6;
    public static int defendNum=5;
    public experiencePower(AbstractCreature owner, int amount){
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
        super.onPlayCard(card, m);

        if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && (AbstractDungeon.actionManager.cardsPlayedThisCombat.get(AbstractDungeon.actionManager.cardsPlayedThisCombat.size() - 1)).type == AbstractCard.CardType.ATTACK
        &&card.type==AbstractCard.CardType.ATTACK&&this.amount>=3) {
            this.flash();
            if(!AbstractDungeon.player.hasPower("turnOffPower")){
                this.amount-=3;
            }
            if(card.cardID.equals("oldOne")){
                if(card.upgraded){
                    this.addToBot(new DamageAction(m,new DamageInfo(this.owner,5*attackNum, DamageInfo.DamageType.NORMAL),AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
                }else {
                    this.addToBot(new DamageAction(m,new DamageInfo(this.owner,3*attackNum, DamageInfo.DamageType.NORMAL),AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
                }
            }else {
                this.addToBot(new DamageAction(m,new DamageInfo(this.owner,attackNum, DamageInfo.DamageType.NORMAL),AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
            }
        }
        if (AbstractDungeon.actionManager.cardsPlayedThisCombat.size() >= 2 && ((AbstractCard)AbstractDungeon.actionManager.cardsPlayedThisCombat.get(AbstractDungeon.actionManager.cardsPlayedThisCombat.size() - 1)).type == AbstractCard.CardType.SKILL
                &&card.type==AbstractCard.CardType.SKILL&&this.amount>=3) {
            this.flash();
            if(!AbstractDungeon.player.hasPower("turnOffPower")){
                this.amount-=3;
            }
            if(card.cardID.equals("oldOne")){
                if(card.upgraded){
                    this.addToBot(new GainBlockAction(this.owner, this.owner, 5*defendNum));
                }else {
                    this.addToBot(new GainBlockAction(this.owner, this.owner, 3*defendNum));
                }
            }else {
                this.addToBot(new GainBlockAction(this.owner, this.owner, defendNum));
            }

        }

    }
    public void update(int slot) {
        super.update(slot);
        if (this.amount <= 0) {
            this.addToBot(new RemoveSpecificPowerAction(AbstractDungeon.player,AbstractDungeon.player,this.ID));
        }
    }





    public void updateDescription() {
        this.description = DESCRIPTIONS[0]+DESCRIPTIONS[0];
    }
    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }


}
