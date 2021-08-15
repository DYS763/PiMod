package Pimod.card.working;
import Pimod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.Iterator;


public class adaptToChanging extends CustomCard{

    public static final String ID = "adaptToChanging";
    public static final String IMG_PATH = "cards/fangyu.png";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 1;
    private static boolean hasDebuff;


    public adaptToChanging() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_COLOR, CardRarity.UNCOMMON, CardTarget.SELF);
        this.tags.add(CardTags.STARTER_DEFEND);
        this.baseBlock = 7;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p, p, this.block));
        Iterator var1 = p.powers.iterator();
        while(var1.hasNext()) {
            AbstractPower c = (AbstractPower)var1.next();
            if (c.type == AbstractPower.PowerType.DEBUFF) {
                hasDebuff=true;
            }
        }
        if(hasDebuff){
            this.addToBot(new GainBlockAction(p, p, this.block));
        }
    }

    public AbstractCard makeCopy() {
        return new adaptToChanging();
    }

    public boolean isDefend() {
        return true;
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(4);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
