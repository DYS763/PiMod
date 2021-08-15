package Pimod.actions;



import Pimod.powers.experiencePower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.AbstractPower.PowerType;
import java.util.Iterator;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class campAction extends AbstractGameAction {
    private final AbstractCreature c;
    private int magicNumber;

    public campAction(AbstractCreature c,int magicNumber) {
        this.c = c;
        this.duration = 0.5F;
        this.magicNumber=magicNumber;
    }

    public void update() {
        if(c.hasPower("experiencePower")){
            Iterator var1 = this.c.powers.iterator();
            while(var1.hasNext()) {
                AbstractPower p = (AbstractPower)var1.next();
                if (p.ID.equals("experiencePower")&&p.amount>8) {
                    int energyNum=p.amount/8;
                    int reduceNum=energyNum*8;
                    this.addToBot(new GainEnergyAction(energyNum));
                    this.addToBot(new ApplyPowerAction(c, c, new experiencePower(c, -reduceNum), -reduceNum));
                }else {
                    this.addToBot(new ApplyPowerAction(c, c, new experiencePower(c, magicNumber), magicNumber));
                }
            }
        }
        else {
            this.addToBot(new ApplyPowerAction(c, c, new experiencePower(c, magicNumber), magicNumber));
        }

        this.isDone = true;
    }
}