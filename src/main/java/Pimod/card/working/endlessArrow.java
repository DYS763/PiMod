package Pimod.card.working;
import Pimod.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.CleaveEffect;

public class endlessArrow extends AbstractCard {

    public static final String ID = "endlessArrow";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String IMG_PATH = "cards/daji.png";
    private static final int COST = 1;
    private static final int ATTACK_DMG = 6;
    private static final int UPGRADE_PLUS_DMG = 3;

    public endlessArrow() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.ATTACK, AbstractCardEnum.PI_COLOR, CardRarity.UNCOMMON, CardTarget.ENEMY);
        //this.tags.add(CardTags.STARTER_STRIKE);
        //this.tags.add(CardTagEnum.SPARK);   魔理沙mod的  暂时不清楚什么作用
        this.baseDamage = 6;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }
    public void triggerOnExhaust() {
        AbstractPlayer p = AbstractDungeon.player;
        this.addToBot(new SFXAction("ATTACK_HEAVY"));
        this.addToBot(new VFXAction(p, new CleaveEffect(), 0.1F));
        this.addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));

    }

    public AbstractCard makeCopy() {
        return new endlessArrow();
    }


    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(3);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}

