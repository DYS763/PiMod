package Pimod.actions;



import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.AbstractPower.PowerType;
import java.util.Iterator;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class quickDefenseAction extends AbstractGameAction {
    private final AbstractCreature c;

    public quickDefenseAction(AbstractCreature c) {
        this.c = c;
        this.duration = 0.5F;
    }

    public void update() {
        Iterator var1 = this.c.powers.iterator();

        while(var1.hasNext()) {
            AbstractPower p = (AbstractPower)var1.next();
            if (p.ID.equals("experiencePower")) {
                this.addToBot(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, p.amount));
                this.addToTop(new RemoveSpecificPowerAction(this.c, this.c, p.ID));
            }
        }
        this.isDone = true;
    }
}