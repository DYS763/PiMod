package Pimod.card.testCard;

import Pimod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class Furou extends CustomCard{//“extends CustomCard” 继承basemod的CustomCard类，可以理解为继承了卡牌所需要的几个基本组成部件。

	public static final String ID = "Furou";
	public static final String IMG_PATH = "cards/furou.png";
	private static final CardStrings cardStrings;
	public static final String NAME;
	public static final String DESCRIPTION;

	//注：
	//描叙中存在几个特殊的字符串： 
	// 1. !D! 、 !M! 、 !B!。
	//该字符串全为英文字符，使用时前后需用空格完整地与其他文本前后隔开，从左至右依次表示damage、magicnumber、block三个变量的值，当三个变量值与baseDamage、baseMagicnumber、baseBlock不同时发生对应的颜色变化。
	//这六个变量的具体信息见：
	// 2. [R]、[G]、[B]
	//该字符串全为英文字符，使用时前后需用空格完整地与其他文本前后隔开，从左至右依次表示战士的能量、猎手的能量、机器人的能量。
	// 3. 关键字，诸如 力量 、 敏捷。
	//该字符串无中英文限制，使用时前后需用空格完整地与其他文本前后隔开，游戏中已有的关键字可以直接使用，需要自定义的可以去接口部分自己编辑关键字。（详参ModCore的receiveEditKeywords部分）
	//
	//实例：  “获得 !M! 层 力量 。如果 力量 超过3层，额外获得 [R] 。”;
	
	private static final int COST = 0;//卡牌的费用。
	
	//注：以上声明的五个变量并非强制需要。仅出于代码的美观考虑而写。
	public Furou() {
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_COLOR, CardRarity.COMMON, CardTarget.SELF);
		this.baseMagicNumber = 5;
		this.magicNumber = this.baseMagicNumber;
		this.tags.add(CardTags.HEALING);
		this.exhaust = true;
	}

	public void use(AbstractPlayer p, AbstractMonster m) {
		this.addToBot(new HealAction(p, p, this.magicNumber));
		this.addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p, 2, false), 2));
	}

	public AbstractCard makeCopy() {
		return new Furou();
	}


	public void upgrade() {
		if (!this.upgraded) {
			this.upgradeName();
			this.upgradeMagicNumber(3);
		}

	}

	static {
		cardStrings = CardCrawlGame.languagePack.getCardStrings("Furou");
		NAME = cardStrings.NAME;
		DESCRIPTION = cardStrings.DESCRIPTION;
	}
}
