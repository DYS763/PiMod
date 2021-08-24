package Pimod.card.working;


import Pimod.patches.AbstractCardEnum;
import Pimod.powers.skilledPower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
//挖矿

public class skilledForm extends AbstractCard {
    public static final String ID = "skilledForm";
    private static final CardStrings cardStrings;
    private static final int COST = 3;

    public skilledForm() {
        super(ID, cardStrings.NAME, "red/power/demon_form", COST, cardStrings.DESCRIPTION, CardType.POWER, AbstractCardEnum.PI_COLOR, CardRarity.RARE, CardTarget.SELF);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new skilledPower(p)));

    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(2);
        }

    }

    public AbstractCard makeCopy() {
        return new skilledForm();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    }
}
