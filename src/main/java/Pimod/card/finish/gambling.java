package Pimod.card.finish;

import Pimod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.PummelDamageAction;
import com.megacrit.cardcrawl.actions.unique.RandomizeHandCostAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

/*已完成  金
 * */
public class gambling extends CustomCard{

    public static final String ID = "gambling";
    public static final String IMG_PATH = "cards/fangyu.png";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 0;
    public gambling() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.ATTACK, AbstractCardEnum.PI_COLOR, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseDamage = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
            this.addToBot(new RandomizeHandCostAction());
            this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
            this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
            this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
            this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));

    }

    public AbstractCard makeCopy() {
        return new gambling();
    }


    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(2);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("gambling");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
