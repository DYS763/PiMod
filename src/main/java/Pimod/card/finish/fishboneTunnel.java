package Pimod.card.finish;

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
/*升级效果未测试
* */
public class fishboneTunnel extends CustomCard {
    public static final String ID = "fishboneTunnel";
    private static CardStrings cardStrings;
    public static  String NAME;
    public static  String DESCRIPTION;
    public static final String IMG_PATH = "cards/shuai_img.png";
    private static final int COST = 1;
    private static int UncommonMineralAmt = 1;
    public fishboneTunnel() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION,
                CardType.SKILL, AbstractCardEnum.PI_COLOR,
                CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 1;
        this.magicNumber=this.baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for(int i=0;i<magicNumber;i++){
            this.addToBot(new MakeTempCardInHandAction(getCommonMineralCard(),1));
        }
        this.addToBot(new MakeTempCardInHandAction(getUncommonMineralCard(),UncommonMineralAmt));
    }

    @Override
    public AbstractCard makeCopy() {
        return new fishboneTunnel();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("fishboneTunnel");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
