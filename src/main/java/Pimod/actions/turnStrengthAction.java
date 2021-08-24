package Pimod.actions;

import Pimod.powers.experiencePower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.AbstractPower.PowerType;
import java.util.Iterator;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class turnStrengthAction extends AbstractGameAction {
    private final AbstractCreature c;

    public turnStrengthAction(AbstractCreature c) {
        this.c = c;
        this.duration = 0.5F;
    }

    public void update() {
        if(c.hasPower("experiencePower")){
            Iterator var1 = this.c.powers.iterator();
            while(var1.hasNext()) {
                AbstractPower p = (AbstractPower)var1.next();
                if (p.ID.equals("experiencePower")&&p.amount>4) {
                    int energyNum=p.amount/4;
                    int reduceNum=energyNum*4;
                    this.addToBot(new ApplyPowerAction(c,c,new StrengthPower(c,energyNum)));
                    this.addToBot(new ApplyPowerAction(c, c, new experiencePower(c, -reduceNum), -reduceNum));
                }else {
                    this.isDone = true;
                }
            }
        }

        this.isDone = true;
    }
}