package Pimod.card.working;
import Pimod.patches.AbstractCardEnum;
import Pimod.powers.experiencePower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class trainToAttack extends AbstractCard {

    public static final String ID = "trainToAttack";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String IMG_PATH = "cards/daji.png";
    private static final int COST = 0;
    private static final int ATTACK_DMG = 6;
    private static final int UPGRADE_PLUS_DMG = 3;

    public trainToAttack() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.ATTACK, AbstractCardEnum.PI_COLOR, CardRarity.BASIC, CardTarget.ENEMY);
        //this.tags.add(CardTags.STARTER_STRIKE);
        //this.tags.add(CardTagEnum.SPARK);   魔理沙mod的  暂时不清楚什么作用
        this.baseDamage = 6;
        this.baseMagicNumber=3;
        this.magicNumber=this.baseMagicNumber;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        this.addToBot(new ApplyPowerAction(p, p, new experiencePower(p, this.magicNumber), this.magicNumber));
    }

    public AbstractCard makeCopy() {
        return new trainToAttack();
    }

    public boolean isStrike() {
        return true;
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(3);
            this.upgradeMagicNumber(2);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}

