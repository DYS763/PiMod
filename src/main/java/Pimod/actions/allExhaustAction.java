package Pimod.actions;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.ActionType;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import java.util.Iterator;

public class allExhaustAction extends AbstractGameAction {
    private AbstractPlayer p;
    private int costTarget;

    public allExhaustAction(int costToTarget) {
        this.p = AbstractDungeon.player;
        this.setValues(this.p, AbstractDungeon.player, this.amount);
        this.actionType = ActionType.CARD_MANIPULATION;
        this.costTarget = costToTarget;
    }

    public void update() {
        if (this.p.exhaustPile.isEmpty()) {
            this.isDone = true;
        }
        if (this.p.exhaustPile.size() > 0) {
            Iterator var1 = this.p.exhaustPile.group.iterator();

            label21:
            while(true) {
                AbstractCard card;
                do {
                    if (!var1.hasNext()) {
                        break label21;
                    }

                    card = (AbstractCard)var1.next();
                } while(card.cost != this.costTarget && !card.freeToPlayOnce);
                this.p.hand.addToHand(card);
                this.p.exhaustPile.removeCard(card);
            }
        }

        this.tickDuration();
        this.isDone = true;
    }
}
