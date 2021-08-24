package Pimod.card.finish;

import Pimod.patches.AbstractCardEnum;
import Pimod.powers.sharpenBladePower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
//打磨利刃

public class sharpenBlade extends AbstractCard {
    public static final String ID = "sharpenBlade";
    private static final CardStrings cardStrings;
    private static final int COST = 1;
    public sharpenBlade() {
        super("sharpenBlade", cardStrings.NAME, "red/power/demon_form", COST, cardStrings.DESCRIPTION, CardType.POWER, AbstractCardEnum.PI_COLOR, CardRarity.UNCOMMON, CardTarget.NONE);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new sharpenBladePower(p, magicNumber), magicNumber));


    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }

    public AbstractCard makeCopy() {
        return new sharpenBlade();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("sharpenBlade");
    }
}
