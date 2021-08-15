package Pimod.card.working;



import Pimod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;


public class fightMemory extends CustomCard{

    public static final String ID = "fightMemory";
    public static final String IMG_PATH = "cards/fangyu.png";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 1;

    public fightMemory() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_COLOR, CardRarity.UNCOMMON, CardTarget.SELF);
        this.tags.add(CardTags.STARTER_DEFEND);
        this.baseBlock = 6;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p, p, this.block));
        this.addToBot(new GainBlockAction(p, p, p.exhaustPile.size()));
    }

    public AbstractCard makeCopy() {
        return new fightMemory();
    }

    public boolean isDefend() {
        return true;
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(5);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
