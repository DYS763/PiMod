package Pimod.cardActions;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.cardRng;
import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.rollRarity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;

public class getRandomExtendsCards {

    public static float PiRareChance;
    public static CardGroup ExtendsCardPool;
    public static int cardBlizzRandomizer;
    public static int cardBlizzStartOffset;
    protected static final Logger logger = LogManager.getLogger(AbstractDungeon.class.getName());



    public static ArrayList<AbstractCard> getRandomPiCards() { //源码是随机获得无色卡方法，
        //本类可以作为往卡组添加卡牌的通用参考，具体方法会英语就看得懂
        ArrayList<AbstractCard> retVal = new ArrayList();
        int numCards = 3;
        AbstractCard card;
        new addPiCards();
        for(int i = 0; i < numCards; ++i) {
            AbstractCard.CardRarity rarity = rollRarity();  //卡牌稀有度函数很重要，可以自己后期定义
            card = null;
            switch(rarity) {
                case COMMON:
                    card = getPiCardFromPool(rarity);
                    logger.info("COMMON");
                    break;
                case UNCOMMON:
                    card = getPiCardFromPool(rarity);
                    logger.info("UNCOMMON");
                    break;
                case RARE:
                    card = getPiCardFromPool(rarity);
                    logger.info("RARE");
                    cardBlizzRandomizer = cardBlizzStartOffset;
                    break;
                default:
                    logger.info("WTF?");
            }

            for(; retVal.contains(card); card = getPiCardFromPool(rarity)) {
                if (card != null) {
                    logger.info("DUPE: " + card.originalName);
                }
            }

            if (card != null) {
                retVal.add(card);
            }
        }

        ArrayList<AbstractCard> retVal2 = new ArrayList();
        Iterator var8 = retVal.iterator();

        while(var8.hasNext()) {
            card = (AbstractCard)var8.next();
            retVal2.add(card.makeCopy());
        }

        return retVal2;
    }
    public static AbstractCard.CardRarity rollRareOrUncommon(float rareChance) {
        return cardRng.randomBoolean(rareChance) ? AbstractCard.CardRarity.RARE : AbstractCard.CardRarity.UNCOMMON;
    }


    public static AbstractCard getPiCardFromPool(AbstractCard.CardRarity rarity) {

        AbstractCard retVal;
        switch(rarity) {
            case RARE:
                retVal = ExtendsCardPool.getRandomCard(true, rarity);
                if (retVal != null) {
                    return retVal;
                }
                logger.info("RARE");
            case UNCOMMON:
                retVal = ExtendsCardPool.getRandomCard(true, rarity);
                if (retVal != null) {
                    return retVal;
                }
                logger.info("UNCOMMON");

            case COMMON:
                retVal = ExtendsCardPool.getRandomCard(true, rarity);
                if (retVal != null) {
                    return retVal;
                }
                logger.info("COMMON");
            default:
                logger.info("ERROR: getColorlessCardFromPool");
                return null;
        }
    }


    static {
        ExtendsCardPool = new CardGroup(CardGroup.CardGroupType.CARD_POOL);
    }

}
