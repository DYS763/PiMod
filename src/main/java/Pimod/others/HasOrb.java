package Pimod.others;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;

import java.util.Iterator;

public abstract class  HasOrb {
    public static boolean hasOrb(String targetID){

        AbstractPlayer p = AbstractDungeon.player;
        Iterator var2 = p.orbs.iterator();
        AbstractOrb o;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            o = (AbstractOrb)var2.next();
        } while(!o.ID.equals(targetID));
        return true;
    }
}
