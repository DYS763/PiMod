package Pimod.card.working.armCards.workshop.chooseWeapon;
import Pimod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;
import java.util.Iterator;
public class chooseWeapon extends CustomCard{

    public static final String ID = "chooseWeapon";
    public static final String IMG_PATH = "cards/fangyu.png";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 1;

    public chooseWeapon() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_COLOR, CardRarity.UNCOMMON, CardTarget.SELF);
        this.tags.add(CardTags.STARTER_DEFEND);
        this.baseBlock = 6;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractCard a = new getSange();
        AbstractCard b = new getYashiya();
        AbstractCard c = new getKaya();
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
        ArrayList<AbstractCard> stanceChoices = new ArrayList();

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



    public AbstractCard makeCopy() {
        return new chooseWeapon();
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
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}