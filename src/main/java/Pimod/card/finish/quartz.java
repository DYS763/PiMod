package Pimod.card.finish;

import Pimod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*已完成 石英
 * */

public class quartz extends CustomCard{

    public static final String ID = "quartz";
    public static final String IMG_PATH = "cards/fangyu.png";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 0;
    private static final boolean isMine = true;
    public quartz() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_MINERAL, CardRarity.COMMON, CardTarget.SELF);
        this.baseMagicNumber = 1;
        this.magicNumber= this.baseMagicNumber;
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DrawCardAction(p,this.magicNumber));
    }

    public AbstractCard makeCopy() {
        return new quartz();
    }

    public boolean isDefend() {
        return true;
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("quartz");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
