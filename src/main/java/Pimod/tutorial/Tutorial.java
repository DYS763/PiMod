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
        System.out.print("end of line!\n2+2="+4);//??????+???????????????????????????\n??????????????????????????????????????????????????????
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

        //????????????
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

        //?????????
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

        //?????????
        //this.cardsToAdd.add(new baton());
        //this.cardsToAdd.add(new magnum());
        //this.cardsToAdd.add(new kaya());
        //this.cardsToAdd.add(new sange());
        //this.cardsToAdd.add(new yashiya());

        //?????????
        this.cardsToAdd.add(new Defend_PI());               //??????1
        this.cardsToAdd.add(new Strike_PI());               //??????1
        this.cardsToAdd.add(new Moniyixia());               //????????????1
        this.cardsToAdd.add(new Furou());                   //?????? ??????????????????1
        this.cardsToAdd.add(new Yinggangguangxian());       //????????????1
        this.cardsToAdd.add(new Youjiguangxian());          //???????????? ??????????????????debuff?????????1
        this.cardsToAdd.add(new Chengzhineifire());         //?????????fire ???????????????
        this.cardsToAdd.add(new Niunai());                  //?????? ??????debuff??????1
        this.cardsToAdd.add(new meide());                   //?????? ???????????????????????????1
        this.cardsToAdd.add(new diaoling());                //??????
        //this.cardsToAdd.add(new quede());                   //?????? ??????debuff1
        //this.cardsToAdd.add(new getBaton());                //????????? ??????1
        this.cardsToAdd.add(new fishboneTunnel());          //???????????? ?????????????????????1
        this.cardsToAdd.add(new iaido());                   //?????? ???????????????????????????1
        //this.cardsToAdd.add(new remove());                  //???????????? ???????????? ???????????????1 ??????
        this.cardsToAdd.add(new evillyDevote());            //???????????? ??????????????????????????????
        //this.cardsToAdd.add(new panicAttack());             //???????????? ????????????1
        //this.cardsToAdd.add(new temporaryWeapon());         //???????????? ????????????1
        this.cardsToAdd.add(new gambling());                //???????????? ???????????? ??????????????????1
        this.cardsToAdd.add(new sorbet());                  //???????????? ???????????? ????????????1
        //this.cardsToAdd.add(new recklessAttack());          //???????????? ???????????? ????????????1
        this.cardsToAdd.add(new paraInfect());              //?????? ??????debuff?????????buff debuff??????????????????1
        this.cardsToAdd.add(new watchForChance());          //???????????? ????????????
        this.cardsToAdd.add(new heavyAttack());             //??????
        this.cardsToAdd.add(new lightUp());                 //?????? ??????????????????
        this.cardsToAdd.add(new sharpenBlade());            //???????????? ???????????????
        this.cardsToAdd.add(new hitOnWound());              //???????????????????????????1??????1
        this.cardsToAdd.add(new doubleEdgedSword());        //????????? ?????????????????????1
        this.cardsToAdd.add(new poleVault());               //????????? ????????????1
        this.cardsToAdd.add(new reaper());                  //??????????????? ????????????
        this.cardsToAdd.add(new hideAndSeek());             //????????? ?????????
        //this.cardsToAdd.add(new getMagnum());               //???????????????
        this.cardsToAdd.add(new dieOut());                  //??????
        //this.cardsToAdd.add(new chooseWeapon());            //????????????
        this.cardsToAdd.add(new mine());                    //??????   ?????????????????????
       // this.cardsToAdd.add(new completelyUsed());          //??????    ???bug????????????
        this.cardsToAdd.add(new thornyHandgard());          //???????????? ?????????
        this.cardsToAdd.add(new efficientlyUse());          //???????????? ???0???1
        this.cardsToAdd.add(new skilledForm());             //????????????
        this.cardsToAdd.add(new featherFan());              //???????????? ??????2???  ????????????
        this.cardsToAdd.add(new multiplexing());            //???????????? ???????????????2
        this.cardsToAdd.add(new goodMeal());                //???????????? 2??????3 ?????????3
        this.cardsToAdd.add(new throughTrouble());          //???????????? ??????debuff???+1??????
        this.cardsToAdd.add(new fightMemory());             //???????????? ???????????????????????????+x?????????
        this.cardsToAdd.add(new sweepingBlade());           //???????????? ??????10??????2??????
        this.cardsToAdd.add(new H3AD(0));          //???????????? ?????????????????????????????? ??????????????????
        this.cardsToAdd.add(new endlessArrow());            //???????????? ???????????? 1??? 6??? ?????? ???????????????????????????????????????7?????????
        this.cardsToAdd.add(new livingArmor());             //???????????? ????????? 1??? 5??? ?????? ????????????????????????7?????????
        this.cardsToAdd.add(new trashCan());                //???????????? ????????? ??????????????? ??????1??????
        this.cardsToAdd.add(new leapOfFaith());             //???????????? ???????????? 1??? ??????1?????? ???3??????
        this.cardsToAdd.add(new adaptToChanging());         //???????????? ???????????? ??????7????????????debuff ????????????7???
        this.cardsToAdd.add(new breakCard());               //???????????? ???????????? ???????????????1???????????????????????????????????????
        this.cardsToAdd.add(new demonPoison());             //???????????? ???????????? 2????????? ??????8?????????
        this.cardsToAdd.add(new polish());                  //???????????? ?????? ??????3?????????
        this.cardsToAdd.add(new enchant());                 //???????????? ?????? ?????????8??????????????? ?????? ??????????????????????????????
        this.cardsToAdd.add(new wellPrepared());            //???????????? ???????????? ???2 ?????????????????????????????????+1
        this.cardsToAdd.add(new intuition());               //???????????? ???????????? ????????????
        this.cardsToAdd.add(new trainToAttack());           //???????????? ???????????? 0??????4 ??????+3
        this.cardsToAdd.add(new holdShield());              //???????????? ?????? ??????9?????? ??????+2
        this.cardsToAdd.add(new farawayMemory());           //???????????? ???????????? 2??? ????????????
        this.cardsToAdd.add(new turnOff());                 //???????????? ?????? ??????????????????????????????????????????
        this.cardsToAdd.add(new oldOne());                  //???????????? ????????? ??????9?????????????????????????????????3?????????   ????????????
        this.cardsToAdd.add(new quickDefense());            //???????????? ???????????? ???????????????????????? ???????????????????????????
        this.cardsToAdd.add(new daaaaash());                //???????????? ?????? 1??? ??????3????????? ???2??????
        this.cardsToAdd.add(new adaptability());            //???????????? ????????? ?????????????????????2??????
        this.cardsToAdd.add(new camp());                    //???????????? ?????? ????????????????????????8??????????????????????????????+4
        this.cardsToAdd.add(new wellTrained());             //???????????? ???????????? ?????? ??????????????????/??????????????????
        this.cardsToAdd.add(new experienceRepair());        //???????????? ???????????? ???????????????????????????????????????????????????????????????
        this.cardsToAdd.add(new excavate());        /*
        ??????buff??????  ??????????????????????????????????????????????????????????????????-3 ????????????  ????????????????????????????????????????????????????????????-3 ????????????
        * */
        //?????????
        //
        //D6
        //????????????
        //????????????
        //?????????
        //??????
        //?????????????????? ????????????

        //???????????????
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
        logger.info(">>>???????????????<<<");

        logger.info(">>>???????????????<<<");
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
        receiveJson("??????", "Pimod_cards.json", CardStrings.class);
        receiveJson("??????", "Pimod_powers.json", PowerStrings.class);
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

