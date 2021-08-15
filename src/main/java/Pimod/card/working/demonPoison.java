package Pimod.card.working;



import Pimod.patches.AbstractCardEnum;
import Pimod.powers.diaolingPower;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;


public class demonPoison extends CustomCard{

    public static final String ID = "demonPoison";
    public static final String IMG_PATH = "cards/fangyu.png";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 2;

    public demonPoison() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_COLOR, CardRarity.RARE, CardTarget.ENEMY);
        this.tags.add(CardTags.STARTER_DEFEND);
        this.baseBlock = 5;
        this.baseMagicNumber = 6;
        this.magicNumber=this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(m, p, new diaolingPower(m, p, this.magicNumber), this.magicNumber, AbstractGameAction.AttackEffect.POISON));

    }

    public AbstractCard makeCopy() {
        return new demonPoison();
    }


    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(3);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
