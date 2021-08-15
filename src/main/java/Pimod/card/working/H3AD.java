package Pimod.card.working;
import Pimod.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.unique.SkewerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class H3AD extends AbstractCard {

    public static final String ID = "H3AD";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String IMG_PATH = "cards/daji.png";
    private static final int COST = -1;
    private static final int ATTACK_DMG = 6;
    private static final int UPGRADE_PLUS_DMG = 3;
    public H3AD() {
        this(0);
    }
    public H3AD(int upgrades) {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.ATTACK, AbstractCardEnum.PI_COLOR, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseDamage = 6;
        this.timesUpgraded = upgrades;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new SkewerAction(p, m, this.damage, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse));
    }

    public AbstractCard makeCopy() {
        return new H3AD();
    }

    public void upgrade() {
        this.upgradeDamage(4 + this.timesUpgraded);
        ++this.timesUpgraded;
        this.upgraded = true;
        this.name = cardStrings.NAME + "+" + this.timesUpgraded;
    }
    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}

