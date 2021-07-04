package Pimod.tutorial;
import Pimod.card.*;
import Pimod.card.MineralCards.*;
import Pimod.card.PiBaseCard.Defend_PI;
import Pimod.card.PiBaseCard.Strike_PI;
import Pimod.card.testCard.*;
import Pimod.characters.A_PI;
import Pimod.patches.AbstractCardEnum;
import Pimod.patches.PIClassEnum;
import Pimod.relic.goldenApple;
import basemod.BaseMod;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.localization.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;


@SpireInitializer
public class Tutorial implements EditCardsSubscriber, PostDungeonInitializeSubscriber, EditStringsSubscriber,
        EditRelicsSubscriber, EditCharactersSubscriber ,EditKeywordsSubscriber,PostInitializeSubscriber
        ,OnPowersModifiedSubscriber{
    public static final Logger logger = LogManager.getLogger(Tutorial.class.getName());
    public static final Color PICOLOR = CardHelper.getColor(236,102,172);
    public static final Color PIEXTENDS = CardHelper.getColor(0,0,0);
    private ArrayList<AbstractCard> cardsToAdd = new ArrayList();
    public static Texture change;

    public Tutorial() {
        BaseMod.subscribe(this);
        logger.info("creating the color:picolor");
        BaseMod.addColor(AbstractCardEnum.PI_COLOR,PICOLOR,PICOLOR,PICOLOR,PICOLOR,PICOLOR,PICOLOR,PICOLOR,"img/512/bg_attack_MRS_s.png", "img/512/bg_skill_MRS_s.png", "img/512/bg_power_MRS_s.png", "img/512/cardOrb.png", "img/1024/bg_attack_MRS.png", "img/1024/bg_skill_MRS.png", "img/1024/bg_power_MRS.png", "img/1024/cardOrb.png", "img/UI/energyOrb.png");
        BaseMod.addColor(AbstractCardEnum.PI_DERIVATIONS,PIEXTENDS,PIEXTENDS,PIEXTENDS,PIEXTENDS,PIEXTENDS,PIEXTENDS,PIEXTENDS,"img/512/bg_attack_MRS_s.png", "img/512/bg_skill_MRS_s.png", "img/512/bg_power_MRS_s.png", "img/512/cardOrb.png", "img/1024/bg_attack_MRS.png", "img/1024/bg_skill_MRS.png", "img/1024/bg_power_MRS.png", "img/1024/cardOrb.png", "img/UI/energyOrb.png");
    }

    public static void initialize() {
        new Tutorial();
        System.out.print("hello world! 5*6+30=");
        System.out.print(5*6+30);
        System.out.print("end of line!\n2+2="+4);//此处+代表文本之间相连，\n在此是一个字符，专门表示该行已结束。
    }

    @Override
    public void receiveEditRelics() {
        BaseMod.addRelicToCustomPool(new goldenApple(), AbstractCardEnum.PI_COLOR);
    }

    @Override
    public void receiveEditCards() {
        logger.info("starting editing cards");
        this.loadCardsToAdd();
        logger.info("adding cards for MARISA");
        Iterator var1 = this.cardsToAdd.iterator();

        while(var1.hasNext()) {
            AbstractCard card = (AbstractCard)var1.next();
            logger.info("Adding card : " + card.name);
            BaseMod.addCard(card);
        }

        logger.info("done editing cards");
    }
    @Override
    public void receiveEditCharacters() {
        logger.info("begin editing characters");
        logger.info("add " + PIClassEnum.A_PI.toString());
        BaseMod.addCharacter(new A_PI("A_PI"), "img/charSelect/testButton.png", "img/charSelect/a_pi1.jpg", PIClassEnum.A_PI);
        logger.info("done editing characters");
    }
    private void loadCardsToAdd() {
        this.cardsToAdd.clear();
        this.cardsToAdd.add(new flare());
        this.cardsToAdd.add(new Defend_PI());
        this.cardsToAdd.add(new Strike_PI());
        this.cardsToAdd.add(new flare1());
        this.cardsToAdd.add(new flare2());
        this.cardsToAdd.add(new flare3());
        this.cardsToAdd.add(new flare11());
        this.cardsToAdd.add(new flare12());
        this.cardsToAdd.add(new flare13());
        this.cardsToAdd.add(new flare01());
        this.cardsToAdd.add(new flare02());
        this.cardsToAdd.add(new flare03());
        this.cardsToAdd.add(new Moniyixia());
        this.cardsToAdd.add(new Furou());
        this.cardsToAdd.add(new Yinggangguangxian());
        this.cardsToAdd.add(new Youjiguangxian());
        this.cardsToAdd.add(new Chengzhineifire());
        this.cardsToAdd.add(new Niunai());
        this.cardsToAdd.add(new meide());
        this.cardsToAdd.add(new extendstest1());
        this.cardsToAdd.add(new extendstest2());
        this.cardsToAdd.add(new extendstest3());
        this.cardsToAdd.add(new extendstest11());
        this.cardsToAdd.add(new extendstest12());
        this.cardsToAdd.add(new extendstest13());
        this.cardsToAdd.add(new extendstest111());
        this.cardsToAdd.add(new extendstest122());
        this.cardsToAdd.add(new extendstest133());
        this.cardsToAdd.add(new diaoling());
        this.cardsToAdd.add(new quede());
        this.cardsToAdd.add(new testForOrb());
        this.cardsToAdd.add(new coal());
        this.cardsToAdd.add(new diamond());
        this.cardsToAdd.add(new glowStone());
        this.cardsToAdd.add(new emerald());
        this.cardsToAdd.add(new gold());
        this.cardsToAdd.add(new obsidian());
        this.cardsToAdd.add(new quartz());
        this.cardsToAdd.add(new redStone());
        this.cardsToAdd.add(new steel());
        this.cardsToAdd.add(new stone());

    }

    @Override
    public void receivePostDungeonInitialize() {
        logger.info(">>>初始化开始<<<");

        logger.info(">>>初始化完成<<<");
    }
    public void receivePostInitialize() {
        change = new Texture(Gdx.files.internal("img/UI/campfire/ShopOnline.png"));
    }
    @Override
    public void receiveEditStrings() {
        String relic;
        String card;
        String power;
        String potion;
        String event;
        String UI;
        logger.info("lang == zhs");
        card = "localization/Pimod_cards.json";
        relic = "localization/Pimod_relics.json";
        power = "localization/Pimod_powers.json";
        potion = "localization/Pimod_potions.json";
        event = "localization/Pimod_events.json";
        UI = "localization/Pimod_ui.json";
        String relicStrings = Gdx.files.internal(relic).readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
        String cardStrings = Gdx.files.internal(card).readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(CardStrings.class, cardStrings);
        String powerStrings = Gdx.files.internal(power).readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(PowerStrings.class, powerStrings);
        String potionStrings = Gdx.files.internal(potion).readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(PotionStrings.class, potionStrings);
        String eventStrings = Gdx.files.internal(event).readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(EventStrings.class, eventStrings);
        String UIStrings=Gdx.files.internal(UI).readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(UIStrings.class, UIStrings);
        logger.info("done editing strings");
        receiveJson("卡牌", "Pimod_cards.json", CardStrings.class);
        receiveJson("力量", "Pimod_powers.json", PowerStrings.class);
    }
    private void receiveJson(String typeInfo, String jsonFileName, Class<?> className) {
        String cardStrings = Gdx.files.internal("localization/" + jsonFileName).readString("UTF-8");
        BaseMod.loadCustomStrings(className, cardStrings);
    }
    public void receivePowersModified() {

    }

    private static String loadJson(String jsonPath) {
        return Gdx.files.internal(jsonPath).readString(String.valueOf(StandardCharsets.UTF_8));
    }

    public void receiveEditKeywords() {
        logger.info("Setting up custom keywords");
        String keywordsPath;
        keywordsPath = "localization/Pimod_keywords.json";
        Gson gson = new Gson();
        Tutorial.Keywords keywords = (Tutorial.Keywords)gson.fromJson(loadJson(keywordsPath), Tutorial.Keywords.class);
        Keyword[] var4 = keywords.keywords;
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Keyword key = var4[var6];
            logger.info("Loading keyword : " + key.NAMES[0]);
            BaseMod.addKeyword(key.NAMES, key.DESCRIPTION);
        }

        logger.info("Keywords setting finished.");
    }

    class Keywords{
        Keyword[] keywords;
        Keywords(){}
    }
}

