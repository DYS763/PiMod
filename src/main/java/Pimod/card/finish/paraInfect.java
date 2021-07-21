package Pimod.card.finish;
import Pimod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.*;
//寄染

public class paraInfect extends CustomCard{

    public static final String ID = "paraInfect";
    public static final String IMG_PATH = "img/cards/Defend_MRS.png";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 1;


    public paraInfect() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_COLOR, CardRarity.RARE, CardTarget.SELF);
        this.tags.add(CardTags.STARTER_DEFEND);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.hasPower("Weakened")){//虚弱转换为力量
            AbstractPower a=AbstractDungeon.player.getPower("Weakened");
            this.addToBot(new ApplyPowerAction(p,p,new StrengthPower(p,a.amount),a.amount));
            this.addToTop(new RemoveSpecificPowerAction(p, p, a.ID));
        }
        if(p.hasPower("Vulnerable")){//易伤转换为敏捷
            AbstractPower a=AbstractDungeon.player.getPower("Vulnerable");
            this.addToBot(new ApplyPowerAction(p,p,new DexterityPower(p,a.amount),a.amount));
            this.addToTop(new RemoveSpecificPowerAction(p, p, a.ID));
        }
        if(p.hasPower("Frail")){//易碎转化为多重护甲
            AbstractPower a=AbstractDungeon.player.getPower("Frail");
            this.addToBot(new ApplyPowerAction(p,p,new MetallicizePower(p,a.amount),a.amount));
            this.addToTop(new RemoveSpecificPowerAction(p, p, a.ID));
        }


    }

    public AbstractCard makeCopy() {
        return new paraInfect();
    }


    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(0);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("paraInfect");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
