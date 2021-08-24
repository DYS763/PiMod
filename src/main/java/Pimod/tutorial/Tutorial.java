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
import Pimod.card.working.armCards.workshop.chooseWeapon.*;
import Pimod.card.working.skilledForm;
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
    private final ArrayList<AbstractCard> cardsToAdd = new ArrayList();
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
       // this.cardsToAdd.add(new extendstest1());
        //this.cardsToAdd.add(new extendstest2());
        //this.cardsToAdd.add(new extendstest3());
       // this.cardsToAdd.add(new extendstest11());
       // this.cardsToAdd.add(new extendstest12());
       // this.cardsToAdd.add(new extendstest13());
       // this.cardsToAdd.add(new extendstest111());
      //  this.cardsToAdd.add(new extendstest122());
       // this.cardsToAdd.add(new extendstest133());

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
        //this.cardsToAdd.add(new baton());
        //this.cardsToAdd.add(new magnum());
        //this.cardsToAdd.add(new kaya());
        //this.cardsToAdd.add(new sange());
        //this.cardsToAdd.add(new yashiya());

        //主卡组
        this.cardsToAdd.add(new Defend_PI());               //防御1
        this.cardsToAdd.add(new Strike_PI());               //打击1
        this.cardsToAdd.add(new Moniyixia());               //伤害白卡1
        this.cardsToAdd.add(new Furou());                   //腐肉 恢复手段白卡1
        this.cardsToAdd.add(new Yinggangguangxian());       //硬刚光线1
        this.cardsToAdd.add(new Youjiguangxian());          //游击光线 两个造成短暂debuff的卡牌1
        this.cardsToAdd.add(new Chengzhineifire());         //城之内fire 多段伤害卡
        this.cardsToAdd.add(new Niunai());                  //牛奶 清除debuff手段1
        this.cardsToAdd.add(new meide());                   //美德 缺德流补齐组件之一1
        this.cardsToAdd.add(new diaoling());                //血月
        //this.cardsToAdd.add(new quede());                   //缺德 双倍debuff1
        //this.cardsToAdd.add(new getBaton());                //接力棒 过牌1
        this.cardsToAdd.add(new fishboneTunnel());          //鱼骨矿道 矿物类型增益卡1
        this.cardsToAdd.add(new iaido());                   //居合 高伤强制过回合蓝卡1
        //this.cardsToAdd.add(new remove());                  //解除武装 移除武器 过牌基础卡1 无限
        this.cardsToAdd.add(new evillyDevote());            //邪恶献身 高强度高风险增益金卡
        //this.cardsToAdd.add(new panicAttack());             //慌乱推击 伤害白卡1
        //this.cardsToAdd.add(new temporaryWeapon());         //临时武器 伤害白卡1
        this.cardsToAdd.add(new gambling());                //羸弱赌徒 伤害蓝卡 随即手牌能量1
        this.cardsToAdd.add(new sorbet());                  //草莓冰沙 存储能量 运营蓝卡1
        //this.cardsToAdd.add(new recklessAttack());          //莽撞一击 移除武器 充能蓝卡1
        this.cardsToAdd.add(new paraInfect());              //寄染 自身debuff转化为buff debuff流高强度金卡1
        this.cardsToAdd.add(new watchForChance());          //等待时机 选择蓝卡
        this.cardsToAdd.add(new heavyAttack());             //重击
        this.cardsToAdd.add(new lightUp());                 //点亮 防御增益蓝卡
        this.cardsToAdd.add(new sharpenBlade());            //打磨利刃 重伤流组件
        this.cardsToAdd.add(new hitOnWound());              //类似飞身踢的回费抽1蓝卡1
        this.cardsToAdd.add(new doubleEdgedSword());        //双刃剑 高质量消耗金卡1
        this.cardsToAdd.add(new poleVault());               //撑杆跳 蓝卡防御1
        this.cardsToAdd.add(new reaper());                  //收割者镰刀 蓝卡回血
        this.cardsToAdd.add(new hideAndSeek());             //躲猫猫 防御卡
        //this.cardsToAdd.add(new getMagnum());               //马格南之鹰
        this.cardsToAdd.add(new dieOut());                  //抹杀
        //this.cardsToAdd.add(new chooseWeapon());            //选择武器
        this.cardsToAdd.add(new mine());                    //采集   每回合获得矿物
       // this.cardsToAdd.add(new completelyUsed());          //精炼    有bug，不会修
        this.cardsToAdd.add(new thornyHandgard());          //蓝卡能力 金属化
        this.cardsToAdd.add(new efficientlyUse());          //蓝卡能力 打0抽1
        this.cardsToAdd.add(new skilledForm());             //金卡能力
        this.cardsToAdd.add(new featherFan());              //蓝卡防御 消耗2卡  需要修改
        this.cardsToAdd.add(new multiplexing());            //蓝卡防御 被消耗时抽2
        this.cardsToAdd.add(new goodMeal());                //蓝卡技能 2费回3 消耗回3
        this.cardsToAdd.add(new throughTrouble());          //蓝卡能力 获得debuff时+1力量
        this.cardsToAdd.add(new fightMemory());             //蓝卡防御 获得已消耗卡牌数量+x的格挡
        this.cardsToAdd.add(new sweepingBlade());           //蓝卡攻击 全体10伤害2重伤
        this.cardsToAdd.add(new H3AD(0));          //蓝卡攻击 耗能基于抽到时的能量 可以多次升级
        this.cardsToAdd.add(new endlessArrow());            //蓝卡攻击 无尽箭矢 1费 6伤 无限 此卡被消耗时对所有敌人造成7点伤害
        this.cardsToAdd.add(new livingArmor());             //蓝卡防御 活护腕 1费 5甲 无限 此卡被消耗时获得7点护甲
        this.cardsToAdd.add(new trashCan());                //金能力卡 垃圾桶 回合结束时 消耗1张卡
        this.cardsToAdd.add(new leapOfFaith());             //蓝卡技能 信仰之跃 1费 获得1易伤 抽3张牌
        this.cardsToAdd.add(new adaptToChanging());         //蓝卡技能 临机应变 获得7甲如果有debuff 额外获得7甲
        this.cardsToAdd.add(new breakCard());               //蓝卡技能 破极兵刃 你打出的下1张卡将消耗并回复相应的费用
        this.cardsToAdd.add(new demonPoison());             //蓝卡技能 魔王药剂 2费消耗 给予8层凋零
        this.cardsToAdd.add(new polish());                  //蓝卡能力 打磨 获得3层锋利
        this.cardsToAdd.add(new enchant());                 //蓝卡技能 附魔 经验为8时才能打出 消耗 打出时永久强化一张牌
        this.cardsToAdd.add(new wellPrepared());            //蓝卡技能 准备就绪 抽2 本回合每打一张牌，经验+1
        this.cardsToAdd.add(new intuition());               //蓝卡技能 超人直觉 经验翻倍
        this.cardsToAdd.add(new trainToAttack());           //白卡攻击 训练射击 0费打4 经验+3
        this.cardsToAdd.add(new holdShield());              //蓝卡技能 持盾 获得9格挡 经验+2
        this.cardsToAdd.add(new farawayMemory());           //蓝卡技能 远古记忆 2费 获得经验
        this.cardsToAdd.add(new turnOff());                 //金卡攻击 熄灯 本回合的经验效果不会消耗经验
        this.cardsToAdd.add(new oldOne());                  //蓝卡攻击 一招鲜 造成9伤害，经验在此卡上发挥3倍效果   加强一点
        this.cardsToAdd.add(new quickDefense());            //蓝卡技能 应急防御 失去所有经验层数 获得相应层数的格挡
        this.cardsToAdd.add(new daaaaash());                //蓝卡技能 疾跑 1费 失去3点经验 抽2张牌
        this.cardsToAdd.add(new adaptability());            //蓝卡能力 适应性 收到攻击时获得2经验
        this.cardsToAdd.add(new camp());                    //蓝卡技能 扎营 如果经验层数大于8转换为能量，否则经验+4
        this.cardsToAdd.add(new wellTrained());             //蓝卡技能 训练有素 选择 经验转化敏捷/经验转化力量
        this.cardsToAdd.add(new experienceRepair());        //蓝卡技能 经验修补 第一次打出这张卡时，消耗经验，提高基础属性
        this.cardsToAdd.add(new excavate());        /*
        新增buff经验  打出攻击牌时，若打出的上一张牌是攻击牌，经验-3 伤害增加  获得格挡时，若打出的上一张牌是技能牌经验-3 防御增加
        * */
        //多面手
        //
        //D6
        //下界之星
        //破釜沉舟
        //军械库
        //铁镐
        //微型赌徒特酿 战神形态

        //选择牌附属
        this.cardsToAdd.add(new piUpgrade());
        this.cardsToAdd.add(new piDraw());
        this.cardsToAdd.add(new piWeaken());
        this.cardsToAdd.add(new getKaya());
        this.cardsToAdd.add(new getSange());
        this.cardsToAdd.add(new getYashiya());
        this.cardsToAdd.add(new turnDexterity());
        this.cardsToAdd.add(new turnStrength());
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
        Tutorial.Keywords keywords = gson.fromJson(loadJson(keywordsPath), Keywords.class);
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

