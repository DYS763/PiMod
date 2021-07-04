package Pimod.cardActions;

import Pimod.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.Map;

import static Pimod.cardActions.getRandomExtendsCards.ExtendsCardPool;

public class addPiCards {
    //添加抽卡卡池方法，引用方法时要注意方法的位置
    protected static final Logger logger = LogManager.getLogger(AbstractDungeon.class.getName());
    public addPiCards() {//这个是添加卡池函数，方便测试放在这里，实用时放在主类的初始化语句
        Iterator var2 = CardLibrary.cards.entrySet().iterator();

        while(var2.hasNext()) {
            Map.Entry<String, AbstractCard> c = (Map.Entry)var2.next();
            AbstractCard card = (AbstractCard)c.getValue();
            if (card.color == AbstractCardEnum.PI_DERIVATIONS &&
                    card.rarity != AbstractCard.CardRarity.BASIC &&
                    card.rarity != AbstractCard.CardRarity.SPECIAL &&
                    card.type != AbstractCard.CardType.STATUS) {
                ExtendsCardPool.addToTop(card);
            }
        }

        logger.info("COLORLESS: " + ExtendsCardPool.size());
    }
}
