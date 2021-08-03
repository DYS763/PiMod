package Pimod.card.working.armCards;

import Pimod.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class getMagnum extends AbstractCard {

    public static final String ID = "getMagnum";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String IMG_PATH = "cards/daji.png";
    private static final int COST = 1;
    private static final int ATTACK_DMG = 6;
    private static final int UPGRADE_PLUS_DMG = 3;

    public getMagnum() {
        super(ID, NAME, IMG_PATH, 1, DESCRIPTION, CardType.ATTACK, AbstractCardEnum.PI_COLOR, CardRarity.UNCOMMON, CardTarget.ENEMY);
        //this.tags.add(CardTags.STARTER_STRIKE);
        //this.tags.add(CardTagEnum.SPARK);   魔理沙mod的  暂时不清楚什么作用
        this.baseDamage = 17;
        this.baseMagicNumber = 2;
        this.damage = this.baseDamage;
        this.magicNumber = this.baseMagicNumber;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {

        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));

        this.addToBot(new ChannelAction(new magnumOrb()));
        if(!p.hasPower("magnumPower")){
            this.addToTop(new ApplyPowerAction(p,p,new magnumPower(p)));}



    }

    public AbstractCard makeCopy() {
        return new getMagnum();
    }

    public boolean isStrike() {
        return true;
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(5);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}

