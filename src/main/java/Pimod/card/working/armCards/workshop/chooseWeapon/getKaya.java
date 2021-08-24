package Pimod.card.working.armCards.workshop.chooseWeapon;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
public class getKaya extends AbstractCard {
    public static final String ID = "getKaya";
    private static final CardStrings cardStrings;
    AbstractPlayer p = AbstractDungeon.player;

    public getKaya() {
        super(ID, cardStrings.NAME, "colorless/power/become_almighty", -2, cardStrings.DESCRIPTION, CardType.POWER, CardColor.COLORLESS, CardRarity.SPECIAL, CardTarget.ENEMY);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) { this.onChoseThisOption(); }

    public void onChoseThisOption() {

        this.addToBot(new ChannelAction(new kayaOrb()));
        if(!p.hasPower("kayaPower")){
            this.addToTop(new ApplyPowerAction(p,p,new kayaPower(p)));}
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }

    public AbstractCard makeCopy() {
        return new getKaya();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    }
}