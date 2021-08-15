package Pimod.card.finish;

import Pimod.patches.AbstractCardEnum;
import Pimod.powers.withered;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import basemod.abstracts.CustomCard;

import java.util.Iterator;

public class diaoling extends CustomCard {
    public static final String ID = "diaoling";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    // Get object containing the strings that are displayed in the game.
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "cards/my_card_img.png";
    private static final int COST = 2;
    private static final int ATTACK_DMG = 3;
    private static final int UPGRADE_PLUS_DMG = 3;
    private static final int VULNERABLE_AMT = 6;
    private static final int UPGRADE_PLUS_VULNERABLE = 1;

    public diaoling() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION,
                AbstractCard.CardType.ATTACK, AbstractCardEnum.PI_COLOR,
                CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        this.magicNumber = this.baseMagicNumber = VULNERABLE_AMT;
        this.damage=this.baseDamage = ATTACK_DMG;
        this.exhaust=true;

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        Iterator var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        while(var3.hasNext()) {
            AbstractMonster mo = (AbstractMonster)var3.next();
            this.addToBot(new ApplyPowerAction(mo, p, new withered(mo,mo,this.magicNumber), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new diaoling();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(UPGRADE_PLUS_DMG);
            this.upgradeBaseCost(1);
            this.upgradeMagicNumber(7);
        }
    }
}
