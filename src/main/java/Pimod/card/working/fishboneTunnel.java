package Pimod.card.working;

import Pimod.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import basemod.abstracts.CustomCard;
import static Pimod.cardActions.returnRandomMineralCard.getCommonMineralCard;
import static Pimod.cardActions.returnRandomMineralCard.getUncommonMineralCard;
/*升级效果未完成
* */
public class fishboneTunnel extends CustomCard {
    public static final String ID = "fishboneTunnel";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "cards/shuai_img.png";
    private static final int COST = 0;
    private static final int VULNERABLE_AMT = 1;

    public fishboneTunnel() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION,
                CardType.SKILL, AbstractCardEnum.PI_COLOR,
                CardRarity.UNCOMMON, CardTarget.NONE);
        this.magicNumber = this.baseMagicNumber = VULNERABLE_AMT;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new MakeTempCardInHandAction(getCommonMineralCard(),1));
        this.addToBot(new MakeTempCardInHandAction(getUncommonMineralCard(),1));
    }

    @Override
    public AbstractCard makeCopy() {
        return new excavate();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
        }
    }
}
