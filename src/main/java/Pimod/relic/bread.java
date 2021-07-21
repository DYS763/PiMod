package Pimod.relic;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;


public class bread extends AbstractClickRelic{
    public static final String ID = "bread";
    public bread(){
        super(ID,new Texture("img/relics/bread_s.png"),RelicTier.STARTER,LandingSound.CLINK );
    }
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new bread();
    }

    @Override
    protected void onRightClick() {
        this.addToBot(new HealAction(AbstractDungeon.player, AbstractDungeon.player, 2));
    }
}




