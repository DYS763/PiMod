package Pimod.card.working;

import Pimod.actions.reaperAction;
import Pimod.card.already.Strike_PI;
import Pimod.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class reaper extends AbstractCard {

    public static final String ID = "reaper";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String IMG_PATH = "cards/daji.png";
    private static final int COST = 1;
    private static final int ATTACK_DMG = 6;
    private static final int UPGRADE_PLUS_DMG = 3;

    public reaper() {
        super(ID, NAME, "cards/daji.png", 1, DESCRIPTION, CardType.ATTACK, AbstractCardEnum.PI_COLOR, CardRarity.RARE, CardTarget.ENEMY);
        //this.tags.add(CardTags.STARTER_STRIKE);
        //this.tags.add(CardTagEnum.SPARK);   魔理沙mod的  暂时不清楚什么作用
        this.baseDamage = 10;
        this.damage =this.baseDamage;
        this.baseMagicNumber = 6;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;

    }
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new reaperAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), this.magicNumber));
    }

    public AbstractCard makeCopy() {
        return new reaper();
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

