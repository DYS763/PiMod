package Pimod.card.finish;
import Pimod.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.Iterator;

public class dieOut extends AbstractCard {

    public static final String ID = "dieOut";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String IMG_PATH = "cards/daji.png";
    private static final int COST = 2;
    public static int extra = 0;
    private AbstractCreature c;
    public dieOut() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.ATTACK, AbstractCardEnum.PI_COLOR, CardRarity.RARE, CardTarget.ENEMY);
        //this.tags.add(CardTags.STARTER_STRIKE);
        //this.tags.add(CardTagEnum.SPARK);   魔理沙mod的  暂时不清楚什么作用
        this.baseDamage = 9;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        Iterator var1 = m.powers.iterator();
        while(var1.hasNext()) {
            AbstractPower a = (AbstractPower)var1.next();
            if (a.type == AbstractPower.PowerType.DEBUFF) {
                switch (a.ID){
                    case "Poison" :
                    case "Weakened":
                    case "Frail":
                        extra += a.amount;
                        break;
                    default:
                        break;
                }
            }
        }
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        this.addToBot(new DamageAction(m, new DamageInfo(p, extra, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));

    }

    public AbstractCard makeCopy() {
        return new dieOut();
    }

    public boolean isStrike() {
        return true;
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(6);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}


