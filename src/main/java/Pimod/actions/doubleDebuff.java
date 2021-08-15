package Pimod.actions;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.AbstractPower.PowerType;
import java.util.Iterator;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class doubleDebuff extends AbstractGameAction {
    private final AbstractCreature c;
    protected static final Logger logger = LogManager.getLogger(AbstractDungeon.class.getName());

    public doubleDebuff(AbstractCreature c) {
        this.c = c;
        this.duration = 0.5F;
        this.actionType = ActionType.DEBUFF;
        this.attackEffect = AttackEffect.FIRE;

    }

    public void update() {
        Iterator var1 = this.c.powers.iterator();

        while(var1.hasNext()) {
            AbstractPower p = (AbstractPower)var1.next();
            if (p.type == PowerType.DEBUFF) {
                switch (p.ID){
                    case "Poison" :
                        this.addToTop(new ApplyPowerAction(c, c, new PoisonPower(c, c, c.getPower("Poison").amount), c.getPower("Poison").amount));
                        break;
                    case "Weakened":
                        this.addToTop(new ApplyPowerAction(c, c, new WeakPower(c,c.getPower("Weakened").amount,false), c.getPower("Weakened").amount));
                        break;
                    default:
                        logger.info("WTF?");
                        break;
                }
            }
        }

        this.isDone = true;
    }
}