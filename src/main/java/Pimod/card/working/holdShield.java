package Pimod.card.working;

import Pimod.patches.AbstractCardEnum;
import Pimod.powers.experiencePower;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;


public class holdShield extends CustomCard{

    public static final String ID = "holdShield";
    public static final String IMG_PATH = "cards/fangyu.png";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 1;

    public holdShield() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_COLOR, CardRarity.COMMON, CardTarget.SELF);
        this.tags.add(CardTags.STARTER_DEFEND);
        this.baseBlock = 5;
        this.baseMagicNumber=6;
        this.magicNumber=this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p, p, this.block));
        this.addToBot(new ApplyPowerAction(p, p, new experiencePower(p, this.magicNumber), this.magicNumber));
    }

    public AbstractCard makeCopy() {
        return new holdShield();
    }

    public boolean isDefend() {
        return true;
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(3);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
