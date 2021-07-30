package Pimod.card.finish;

import Pimod.actions.sorbetAction;
import Pimod.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import basemod.abstracts.CustomCard;
/*草莓冰沙
* */
public class sorbet extends CustomCard {
    public static final String ID = "sorbet";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "cards/my_card_img.png";
    private static final int COST = 2;

    public sorbet() {
        super(ID, NAME, IMG_PATH, -1, DESCRIPTION,
                CardType.SKILL, AbstractCardEnum.PI_COLOR,
                CardRarity.UNCOMMON, CardTarget.SELF);
        this.returnToHand=true;
        this.exhaust=true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new sorbetAction(p, this.freeToPlayOnce, this.energyOnUse, this.upgraded));
    }

    @Override
    public AbstractCard makeCopy() {
        return new sorbet();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
        }
    }
}
