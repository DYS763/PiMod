package Pimod.tutorial;
import Pimod.card.already.*;
import Pimod.card.finish.*;
import Pimod.card.testCard.*;
import Pimod.card.finish.baton;
import Pimod.card.finish.getBaton;
import Pimod.card.finish.fishboneTunnel;
import Pimod.card.finish.iaido;
import Pimod.card.finish.remove;
import Pimod.card.finish.evillyDevote;
import Pimod.card.finish.gambling;
import Pimod.card.working.*;
import Pimod.card.finish.panicAttack;
import Pimod.card.finish.temporaryWeapon;
import Pimod.card.finish.sorbet;
import Pimod.card.finish.recklessAttack;
import Pimod.card.finish.paraInfect;
import Pimod.card.working.armCards.getMagnum;
import Pimod.card.working.armCards.magnum;
import Pimod.characters.A_PI;
import Pimod.patches.AbstractCardEnum;
import Pimod.patches.PIClassEnum;
import Pimod.relic.bread;
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
    public static final Color PIMINERAL = CardHelper.getColor(0,0,0);
    private ArrayList<AbstractCard> cardsToAdd = new ArrayList();
    public static Texture change;

    public Tutorial() {
        BaseMod.subscribe(this);
        logger.info("creating the color:picolor");
        BaseMod.addColor(AbstractCardEnum.PI_COLOR,PICOLOR,PICOLOR,PICOLOR,PICOLOR,PICOLOR,PICOLOR,PICOLOR,"img/512/bg_attack_MRS_s.png", "img/512/bg_skill_MRS_s.png", "img/512/bg_power_MRS_s.png", "img/512/cardOrb.png", "img/1024/bg_attack_MRS.png", "img/1024/bg_skill_MRS.png", "img/1024/bg_power_MRS.png", "img/1024/cardOrb.png", "img/UI/energyOrb.png");
        BaseMod.addColor(AbstractCardEnum.PI_DERIVATIONS,PIEXTENDS,PIEXTENDS,PIEXTENDS,PIEXTENDS,PIEXTENDS,PIEXTENDS,PIEXTENDS,"img/512/bg_attack_MRS_s.png", "img/512/bg_skill_MRS_s.png", "img/512/bg_power_MRS_s.png", "img/512/cardOrb.png", "img/1024/bg_attack_MRS.png", "img/1024/bg_skill_MRS.png", "img/1024/bg_power_MRS.png", "img/1024/cardOrb.png", "img/UI/energyOrb.png");
        BaseMod.addColor(AbstractCardEnum.PI_MINERAL,PIMINERAL,PIMINERAL,PIMINERAL,PIMINERAL,PIMINERAL,PIMINERAL,PIMINERAL,"img/512/bg_attack_MRS_s.png", "img/512/bg_skill_MRS_s.png", "img/512/bg_power_MRS_s.png", "img/512/cardOrb.png", "img/1024/bg_attack_MRS.png", "img/1024/bg_skill_MRS.png", "img/1024/bg_power_MRS.png", "img/1024/cardOrb.png", "img/UI/energyOrb.png");

    }

    public static void initialize() {
        new Tutorial();
        System.out.print("hello world! 5*6+30=");
        System.out.print(5*6+30);
        System.out.print("end of line!\n2+2="+4);//此处+代表文本之间相连，\n在此是一个字符，专门表示该行已结束。
    }

    @Override
    public void receiveEditRelics() {
        BaseMod.addRelicToCustomPool(new bread(), AbstractCardEnum.PI_COLOR);
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

        //测试用牌
        this.cardsToAdd.clear();
        this.cardsToAdd.add(new extendstest1());
        this.cardsToAdd.add(new extendstest2());
        this.cardsToAdd.add(new extendstest3());
        this.cardsToAdd.add(new extendstest11());
        this.cardsToAdd.add(new extendstest12());
        this.cardsToAdd.add(new extendstest13());
        this.cardsToAdd.add(new extendstest111());
        this.cardsToAdd.add(new extendstest122());
        this.cardsToAdd.add(new extendstest133());
        this.cardsToAdd.add(new flare3());
        this.cardsToAdd.add(new flare11());
        this.cardsToAdd.add(new flare13());
        this.cardsToAdd.add(new flare01());
        this.cardsToAdd.add(new flare03());
        this.cardsToAdd.add(new testForOrb());

        //矿物牌
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

        //武器牌
        this.cardsToAdd.add(new baton());
        this.cardsToAdd.add(new magnum());

        //主卡组
        this.cardsToAdd.add(new Defend_PI());   //防御
        this.cardsToAdd.add(new Strike_PI());   //打击
        this.cardsToAdd.add(new Moniyixia());   //伤害白卡
        this.cardsToAdd.add(new Furou());       //腐肉 恢复手段白卡
        this.cardsToAdd.add(new Yinggangguangxian());   //硬刚光线
        this.cardsToAdd.add(new Youjiguangxian());      //游击光线 两个造成短暂debuff的卡牌
        this.cardsToAdd.add(new Chengzhineifire());     //城之内fire 多段伤害卡
        this.cardsToAdd.add(new Niunai());              //牛奶 清除debuff手段
        this.cardsToAdd.add(new meide());               //美德 缺德流补齐组件之一
        this.cardsToAdd.add(new diaoling());            //凋零 上重创的白卡
        this.cardsToAdd.add(new quede());               //缺德 双倍debuff
        this.cardsToAdd.add(new getBaton());               //接力棒 过牌
        this.cardsToAdd.add(new fishboneTunnel());      //鱼骨矿道 矿物类型增益卡
        this.cardsToAdd.add(new iaido());               //居合 高伤强制过回合蓝卡
        this.cardsToAdd.add(new remove());              //解除武装 移除武器 过牌基础卡
        this.cardsToAdd.add(new evillyDevote());        //邪恶献身 高强度高风险增益金卡
        this.cardsToAdd.add(new panicAttack());         //慌乱推击 伤害白卡
        this.cardsToAdd.add(new temporaryWeapon());     //临时武器 伤害白卡
        this.cardsToAdd.add(new gambling());            //羸弱赌徒 伤害蓝卡 随即手牌能量
        this.cardsToAdd.add(new sorbet());              //草莓冰沙 存储能量 运营蓝卡
        this.cardsToAdd.add(new recklessAttack());      //莽撞一击 移除武器 充能蓝卡
        this.cardsToAdd.add(new paraInfect());          //寄染 自身debuff转化为buff debuff流高强度金卡
        this.cardsToAdd.add(new watchForChance());      //等待时机 选择蓝卡
        this.cardsToAdd.add(new allChoice());           //全选 强化选择卡
        this.cardsToAdd.add(new heavyAttack());         //重击
        this.cardsToAdd.add(new lightUp());             //点亮 防御增益蓝卡
        this.cardsToAdd.add(new sharpenBlade());        //打磨利刃 重伤流组件
        this.cardsToAdd.add(new hitOnWound());             //类似飞身踢的回费抽1蓝卡
        this.cardsToAdd.add(new doubleEdgedSword());        //双刃剑 高质量消耗金卡
        this.cardsToAdd.add(new poleVault());               //撑杆跳 蓝卡防御
        this.cardsToAdd.add(new reaper());                  //收割者镰刀 蓝卡回血
        this.cardsToAdd.add(new hideAndSeek());             //躲猫猫 防御卡
        this.cardsToAdd.add(new getMagnum());


        //选择牌附属
        this.cardsToAdd.add(new piUpgrade());
        this.cardsToAdd.add(new piDraw());
        this.cardsToAdd.add(new piWeaken());
    }

    @Override
    public void receivePostDungeonInitialize() {
        logger.info(">>>初始化开始<<<");

        logger.info(">>>初始化完成<<<");
    }
    public void receivePostInitialize() {

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

