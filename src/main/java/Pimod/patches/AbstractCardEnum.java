package Pimod.patches;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.cards.AbstractCard.CardColor;

import javax.smartcardio.Card;

public class AbstractCardEnum {
    @SpireEnum
    public static CardColor PI_COLOR;
    @SpireEnum
    public static CardColor PI_DERIVATIONS;
    @SpireEnum
    public static CardColor PI_MINERAL;

    public AbstractCardEnum() {
    }
}
