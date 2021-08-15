package Pimod.card.working;

import Pimod.patches.AbstractCardEnum;
import Pimod.powers.adaptabilityPower;
import Pimod.powers.minePower;
import Pimod.powers.sharpenBladePower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
//挖矿

public class adaptability extends AbstractCard {
    public static final String ID = "adaptability";
    private static final CardStrings cardStrings;
    private static final int COST = 1;

    public adaptability() {
        super(ID, cardStrings.NAME, "red/power/demon_form", COST, cardStrings.DESCRIPTION, CardType.POWER, AbstractCardEnum.PI_COLOR, CardRarity.COMMON, CardTarget.SELF);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new adaptabilityPower(p, magicNumber), magicNumber));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }

    public AbstractCard makeCopy() {
        return new adaptability();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    }
}
