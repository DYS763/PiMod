package Pimod.card.already;

import Pimod.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Niunai extends CustomCard{//“extends CustomCard” 继承basemod的CustomCard类，可以理解为继承了卡牌所需要的几个基本组成部件。

	public static final String ID = "Niunai";
	public static final String IMG_PATH = "cards/niunai.png";
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
	public Niunai() {
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.PI_COLOR, CardRarity.COMMON, CardTarget.SELF);
		this.exhaust = true;
	}

	public void use(AbstractPlayer p, AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new RemoveDebuffsAction(p));
	}

	public AbstractCard makeCopy() {
		return new Niunai();
	}
	public void upgrade() {
		if (!this.upgraded) {
			this.upgradeName();
			this.isInnate = true;
			this.selfRetain = true;
			this.rawDescription =cardStrings.UPGRADE_DESCRIPTION;
		}

	}

	static {
		cardStrings = CardCrawlGame.languagePack.getCardStrings("Niunai");
		NAME = cardStrings.NAME;
		DESCRIPTION = cardStrings.DESCRIPTION;
	}
}
