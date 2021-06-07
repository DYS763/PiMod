package Pimod.cardActions;
import Pimod.patches.AbstractCardEnum;
import Pimod.tutorial.Tutorial;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.random.Random;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.cardRng;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.megacrit.cardcrawl.saveAndContinue.SaveFile;
import com.megacrit.cardcrawl.saveAndContinue.SaveFile.SaveType;
import com.megacrit.cardcrawl.core.Settings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class getRandomPiCards {

    public static float colorlessRareChance;
    public static CardGroup colorlessCardPool;
    public static int cardBlizzRandomizer;
    public static int cardBlizzStartOffset;
    protected static final Logger logger = LogManager.getLogger(AbstractDungeon.class.getName());



    public static ArrayList<AbstractCard> getRandomPiCards() {
        ArrayList<AbstractCard> retVal = new ArrayList();
        int numCards = 3;

        AbstractCard card;
        for(int i = 0; i < numCards; ++i) {
            AbstractCard.CardRarity rarity = rollRareOrUncommon(colorlessRareChance);
            card = null;
            switch(rarity) {
                case UNCOMMON:
                    card = getColorlessCardFromPool(rarity);
                    logger.info("UNCOMMON");
                    break;
                case RARE:
                    card = getColorlessCardFromPool(rarity);
                    logger.info("RARE");
                    cardBlizzRandomizer = cardBlizzStartOffset;
                    break;
                default:
                    logger.info("WTF?");
            }

            for(; retVal.contains(card); card = getColorlessCardFromPool(rarity)) {
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


    public static AbstractCard getColorlessCardFromPool(AbstractCard.CardRarity rarity) {
        addColorlessCards();
        AbstractCard retVal;
        switch(rarity) {
            case RARE:
                retVal = colorlessCardPool.getRandomCard(true, rarity);
                if (retVal != null) {
                    return retVal;
                }
                logger.info("RARE");
            case UNCOMMON:
                retVal = colorlessCardPool.getRandomCard(true, rarity);
                if (retVal != null) {
                    return retVal;
                }
                logger.info("UNCOMMON");
            default:
                logger.info("ERROR: getColorlessCardFromPool");
                return null;
        }
    }

    private static void addColorlessCards() {
        Iterator var2 = CardLibrary.cards.entrySet().iterator();

        while(var2.hasNext()) {
            Map.Entry<String, AbstractCard> c = (Map.Entry)var2.next();
            AbstractCard card = (AbstractCard)c.getValue();
            if (card.color == AbstractCardEnum.PI_COLOR && card.rarity != AbstractCard.CardRarity.BASIC && card.rarity != AbstractCard.CardRarity.SPECIAL && card.type != AbstractCard.CardType.STATUS) {
                colorlessCardPool.addToTop(card);
            }
        }

        logger.info("COLORLESS CARDS: " + colorlessCardPool.size());
    }

    static {
        colorlessCardPool = new CardGroup(CardGroup.CardGroupType.CARD_POOL);
    }

}
