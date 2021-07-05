package Pimod.cardActions;
import Pimod.card.finish.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;


import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.rollRarity;

public abstract class returnRandomMineralCard {
    protected static final Logger logger = LogManager.getLogger(AbstractDungeon.class.getName());

    public static AbstractCard getCommonMineralCard(){
        Random random = new Random();
        switch ((random.nextInt(3))){
            case 0: return new stone();
            case 1: return new steel();
            case 2: return new quartz();
        }
        return new stone();
    }

    public static AbstractCard getUncommonMineralCard(){
        Random random = new Random();
        switch (random.nextInt(4)){
            case 0: return new coal();
            case 1: return new gold();
            case 2: return new redStone();
            case 3: return new glowStone();
        }
        return new stone();
    }
    public static AbstractCard getRareMineralCard(){
        Random random = new Random();
        switch (random.nextInt(3)){
            case 0: return new diamond();
            case 1: return new obsidian();
            case 2: return new emerald();
        }
        return new stone();
    }


    public static AbstractCard getRandomMineralCard(){
        Random random = new Random();
        AbstractCard.CardRarity rarity = rollRarity();   //随机稀有度
        switch(rarity) {

            case COMMON:
                {
                switch (random.nextInt(3)){
                    case 0: return new stone();
                    case 1: return new steel();
                    case 2: return new quartz();
                }
                }
                logger.info("COMMON");
                break;
            case UNCOMMON:
            {
                switch (random.nextInt(4)){
                    case 0: return new coal();
                    case 1: return new gold();
                    case 2: return new redStone();
                    case 3: return new glowStone();
                }
            }
                logger.info("UNCOMMON");
                break;
            case RARE:
            {
                switch (random.nextInt(3)){
                    case 0: return new diamond();
                    case 1: return new obsidian();
                    case 2: return new emerald();
                }
            }
                logger.info("RARE");
                break;
            default:
                logger.info("WTF?");
        }
        return new stone();
    }


}
