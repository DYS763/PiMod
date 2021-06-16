package Pimod.campfire.campfireEffect;

import Pimod.patches.AbstractCardEnum;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.rooms.RestRoom;
import com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import Pimod.cardActions.getRandomExtendsCards;
import com.megacrit.cardcrawl.vfx.cardManip.PurgeCardEffect;

import java.util.ArrayList;
import java.util.List;


public class changeEffect extends AbstractGameEffect {
    private static final UIStrings uiStrings;
    public static final String[] TEXT;
    private static final float DUR = 2.0F;
    private boolean hasDug = false;
    private Color screenColor;

    public changeEffect() {
        this.screenColor = AbstractDungeon.fadeColor.cpy();
        this.duration = 2.0F;
        this.screenColor.a = 0.0F;   //动画效果
        ((RestRoom)AbstractDungeon.getCurrRoom()).cutFireSound();
        List<String> curses = new ArrayList();
        for(int i = AbstractDungeon.player.masterDeck.group.size() - 1; i >= 0; --i) {
            if (((AbstractCard)AbstractDungeon.player.masterDeck.group.get(i)).color == AbstractCardEnum.PI_DERIVATIONS   //遍历人物卡组，把有PI_DERIVATIONS的都删了，以及部分卡牌判断，留着学习
                    && !((AbstractCard)AbstractDungeon.player.masterDeck.group.get(i)).inBottleFlame
                    && !((AbstractCard)AbstractDungeon.player.masterDeck.group.get(i)).inBottleLightning
                    && ((AbstractCard)AbstractDungeon.player.masterDeck.group.get(i)).cardID != "AscendersBane"
                    && ((AbstractCard)AbstractDungeon.player.masterDeck.group.get(i)).cardID != "CurseOfTheBell"
                    && ((AbstractCard)AbstractDungeon.player.masterDeck.group.get(i)).cardID != "Necronomicurse")
            {
                AbstractDungeon.effectList.add(new PurgeCardEffect((AbstractCard)AbstractDungeon.player.masterDeck.group.get(i)));
                curses.add(((AbstractCard)AbstractDungeon.player.masterDeck.group.get(i)).cardID);
                AbstractDungeon.player.masterDeck.removeCard((AbstractCard)AbstractDungeon.player.masterDeck.group.get(i));
            }
        }
    }

    public void update() {
        this.duration -= Gdx.graphics.getDeltaTime();
        this.updateBlackScreenColor();
        if (this.duration < 1.0F && !this.hasDug) {
            this.hasDug = true;
            AbstractDungeon.getCurrRoom().rewards.clear();
            ArrayList<AbstractCard> rewardCards = getRandomExtendsCards.getRandomPiCards(); //获得卡牌函数

            if (rewardCards != null && !rewardCards.isEmpty()) {
                AbstractDungeon.cardRewardScreen.open(rewardCards, null, TEXT[0]);
            }
            AbstractDungeon.getCurrRoom().phase = RoomPhase.COMPLETE;
        }

        if (this.duration < 0.0F) {
            this.isDone = true;
            ((RestRoom)AbstractDungeon.getCurrRoom()).fadeIn();
            AbstractDungeon.getCurrRoom().phase = RoomPhase.COMPLETE;
        }
    }

    private void updateBlackScreenColor() {
        if (this.duration > 1.5F) {
            this.screenColor.a = Interpolation.fade.apply(1.0F, 0.0F, (this.duration - 1.5F) * 2.0F);
        } else if (this.duration < 1.0F) {
            this.screenColor.a = Interpolation.fade.apply(0.0F, 1.0F, this.duration);
        } else {
            this.screenColor.a = 1.0F;
        }

    }

    public void render(SpriteBatch sb) {
        sb.setColor(this.screenColor);
        sb.draw(ImageMaster.WHITE_SQUARE_IMG, 0.0F, 0.0F, (float)Settings.WIDTH, (float)Settings.HEIGHT);
    }

    public void dispose() {
    }
    static {
        uiStrings = CardCrawlGame.languagePack.getUIString("CampfireSleepEffect");
        TEXT = uiStrings.TEXT;
    }
}