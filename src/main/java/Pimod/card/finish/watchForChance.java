package Pimod.card.finish;
//伺机而动

import Pimod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.PlayTopCardAction;
import com.megacrit.cardcrawl.actions.unique.ArmamentsAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

import java.util.ArrayList;
import java.util.Iterator;


public class watchForChance extends CustomCard{

    public static final String ID = "watchForChance";
    public static final String IMG_PATH = "cards/fangyu.png";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 1;

    public watchForChance() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_COLOR, CardRarity.COMMON, CardTarget.SELF);
        this.tags.add(CardTags.STARTER_DEFEND);
        this.baseBlock = 6;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractCard a = new piWeaken();
        AbstractCard b = new piDraw();
        AbstractCard c = new piUpgrade();

        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
        ArrayList<AbstractCard> stanceChoices = new ArrayList();
        if(p.hasPower("allChoicePower")){

            this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber));
            this.addToBot(new DrawCardAction(this.magicNumber));
            this.addToBot(new ArmamentsAction(this.upgraded));
        }else {
            stanceChoices.add(a);
            stanceChoices.add(b);
            stanceChoices.add(c);
            if (this.upgraded) {
                Iterator var4 = stanceChoices.iterator();

                while(var4.hasNext()) {
                    AbstractCard i = (AbstractCard)var4.next();
                    i.upgrade();
                }
            }

            this.addToBot(new ChooseOneAction(stanceChoices));

        }

    }

    public AbstractCard makeCopy() {
        return new watchForChance();
    }

    public boolean isDefend() {
        return true;
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(3);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("watchForChance");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
