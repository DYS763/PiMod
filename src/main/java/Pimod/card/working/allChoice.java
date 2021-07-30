package Pimod.card.working;

import Pimod.powers.allChoicePower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
//选择牌全拿 难整

public class allChoice extends AbstractCard {
    public static final String ID = "allChoice";
    private static final CardStrings cardStrings;

    public allChoice() {
        super("allChoice", cardStrings.NAME, "red/power/demon_form", 3, cardStrings.DESCRIPTION, CardType.POWER, CardColor.RED, CardRarity.RARE, CardTarget.NONE);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new allChoicePower(p)));

    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }

    public AbstractCard makeCopy() {
        return new allChoice();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("allChoice");
    }
}
