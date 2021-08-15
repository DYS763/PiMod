package Pimod.card.working;

import Pimod.patches.AbstractCardEnum;
import Pimod.powers.breakCardPower;
import Pimod.powers.minePower;
import Pimod.powers.sharpenBladePower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
//挖矿

public class breakCard extends AbstractCard {
    public static final String ID = "breakCard";
    private static final CardStrings cardStrings;
    private static final int COST = 1;

    public breakCard() {
        super(ID, cardStrings.NAME, "red/power/demon_form", COST, cardStrings.DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_COLOR, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new breakCardPower(p, magicNumber), magicNumber));

    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }

    public AbstractCard makeCopy() {
        return new breakCard();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    }
}
