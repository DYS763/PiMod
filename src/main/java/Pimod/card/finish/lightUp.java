package Pimod.card.finish;

import Pimod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Pimod.cardActions.returnRandomMineralCard.getRandomMineralCard;


public class lightUp extends CustomCard{

    public static final String ID = "lightUp";
    public static final String IMG_PATH = "cards/fangyu.png";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 1;

    public lightUp() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_COLOR, CardRarity.COMMON, CardTarget.SELF);
        this.tags.add(CardTags.STARTER_DEFEND);
        this.baseBlock = 7;
        this.baseMagicNumber=1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p, p, this.block));
        this.addToBot(new MakeTempCardInHandAction(getRandomMineralCard(),baseMagicNumber));
    }

    public AbstractCard makeCopy() {
        return new lightUp();
    }

    public boolean isDefend() {
        return true;
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(3);
            this.upgradeMagicNumber(1);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("lightUp");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
