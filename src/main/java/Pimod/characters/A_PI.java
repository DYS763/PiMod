package Pimod.characters;
import Pimod.patches.AbstractCardEnum;
import Pimod.patches.PIClassEnum;
import Pimod.tutorial.Tutorial;
import basemod.abstracts.CustomPlayer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.AnimationState;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.events.beyond.SpireHeart;
import com.megacrit.cardcrawl.events.city.Vampires;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.helpers.ScreenShake.ShakeDur;
import com.megacrit.cardcrawl.helpers.ScreenShake.ShakeIntensity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;

public class A_PI extends CustomPlayer {
    //从魔理沙mod复制过来的，还没改
    private static final int ENERGY_PER_TURN = 3;
    private static final String MARISA_SHOULDER_2 = "img/char/Marisa/shoulder2.png";
    private static final String MARISA_SHOULDER_1 = "img/char/Marisa/shoulder1.png";
    private static final String MARISA_CORPSE = "img/char/Marisa/fallen.png";
    public static final Logger logger = LogManager.getLogger(Tutorial.class.getName());
    private static final String MARISA_SKELETON_ATLAS = "img/char/Marisa/MarisaModelv3.atlas";
    private static final String MARISA_SKELETON_JSON = "img/char/Marisa/MarisaModelv3.json";
    private static final String MARISA_ANIMATION = "Idle";
    private static final String[] ORB_TEXTURES = new String[]{"img/UI/EPanel/layer5.png", "img/UI/EPanel/layer4.png", "img/UI/EPanel/layer3.png", "img/UI/EPanel/layer2.png", "img/UI/EPanel/layer1.png", "img/UI/EPanel/layer0.png", "img/UI/EPanel/layer5d.png", "img/UI/EPanel/layer4d.png", "img/UI/EPanel/layer3d.png", "img/UI/EPanel/layer2d.png", "img/UI/EPanel/layer1d.png"};
    private static final String ORB_VFX = "img/UI/energyBlueVFX.png";
    private static final float[] LAYER_SPEED = new float[]{-40.0F, -32.0F, 20.0F, -20.0F, 0.0F, -10.0F, -8.0F, 5.0F, -5.0F, 0.0F};
    private static final int STARTING_HP = 75;
    private static final int MAX_HP = 75;
    private static final int STARTING_GOLD = 99;
    private static final int HAND_SIZE = 5;
    private static final int ASCENSION_MAX_HP_LOSS = 5;
    //可能是资源路径之类的东西
    public A_PI(String name) {
        super(name, PIClassEnum.A_PI, ORB_TEXTURES, "img/UI/energyBlueVFX.png", LAYER_SPEED, (String)null, (String)null);
        this.dialogX = this.drawX + 0.0F * Settings.scale;
        this.dialogY = this.drawY + 220.0F * Settings.scale;
        logger.info("init Marisa");
        this.initializeClass((String)null, "img/char/Marisa/shoulder2.png", "img/char/Marisa/shoulder1.png", "img/char/Marisa/fallen.png", this.getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(3));
        this.loadAnimation("img/char/Marisa/MarisaModelv3.atlas", "img/char/Marisa/MarisaModelv3.json", 2.0F);
        AnimationState.TrackEntry e = this.state.setAnimation(0, "Idle", true);
        e.setTime(e.getEndTime() * MathUtils.random());
        this.stateData.setMix("Hit", "Idle", 0.1F);
        e.setTimeScale(1.0F);
        logger.info("init finish");
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList();


        retVal.add("Strike_PI");
        // 12张

        return retVal;
    }

    @Override
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList();
        retVal.add("bread");
        return retVal;
    }

    public CharSelectInfo getLoadout(){
        String title;
        String flavor;


        title="缺德佬api";
        flavor="很缺德";
        return new CharSelectInfo(title, flavor, 75, 75, 0, 99, 5, this, this.getStartingRelics(), this.getStartingDeck(), false);
    }

    public String getTitle(PlayerClass playerClass) {
        String title;
        title = "缺德佬";
        return title;
    }

    public AbstractCard.CardColor getCardColor() {
        return AbstractCardEnum.PI_COLOR;
    }

    public Color getCardRenderColor() {
        return Tutorial.PICOLOR;
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return null;                 //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    }

    public Color getCardTrailColor(){
        return Tutorial.PICOLOR;
    }

    public int getAscensionMaxHPLoss() {
        return 5;
    }

    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontBlue;
    }

    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("SELECT_MRS", MathUtils.random(-0.1F, 0.1F));
        CardCrawlGame.screenShake.shake(ShakeIntensity.MED, ShakeDur.SHORT, false);      //aaaaaaaaaaaaaaaa
    }

    public String getCustomModeCharacterButtonSoundKey() {
        return "";
    }   //aaaaaaaaaaaaaaaaaaaaaaaaaa

    public String getLocalizedCharacterName() {
        String char_name;
        char_name = "A_PI";
        return char_name;
    }

    public AbstractPlayer newInstance() {
        return new A_PI(this.name);
    }   //AAAAAAAAAAA

    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AttackEffect[]{AttackEffect.SLASH_HEAVY, AttackEffect.FIRE, AttackEffect.SLASH_DIAGONAL, AttackEffect.SLASH_HEAVY, AttackEffect.FIRE, AttackEffect.SLASH_DIAGONAL};
    }   //AAAAAAAAAAAAAAAAAAAAAAAA

    public String getSpireHeartText() {
        return SpireHeart.DESCRIPTIONS[10];
    }

    public Color getSlashAttackColor() {
        return Tutorial.PICOLOR;
    }

    public String getVampireText() {
        return Vampires.DESCRIPTIONS[1];
    }
}
