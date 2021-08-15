package Pimod.card.finish;

import Pimod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.EnergizedPower;
/*已完成   煤
 * */

public class coal extends CustomCard{

    public static final String ID = "coal";
    public static final String IMG_PATH = "cards/fangyu.png";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 0;
    private static final boolean isMine = true;
    public coal() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_MINERAL, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber=1;
        this.magicNumber=this.baseMagicNumber;
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new EnergizedPower(p, this.magicNumber), this.magicNumber));
    }

    public AbstractCard makeCopy() {
        return new coal();
    }

    public void upgrade() {
        upgradeName();
        this.upgradeMagicNumber(1);
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("coal");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
