package Pimod.relic;

import Pimod.PimodConfig.PimodConfig;
import Pimod.campfire.campfireOption.changeOption;
import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class goldenApple extends CustomRelic {
    /**
     * 遗物ID 随便写 但是需要和json文件名称一致
     * 比如我这里最终是 CANDY_MOD_Money 就需要最后json文件内有 CANDY_MOD_Money 的遗物信息
     */
    public static final String ID = PimodConfig.RELIC_PRE_NAME + "goldenApple";
    /**
     * 日志对象
     */
    private static final Logger log = LogManager.getLogger(goldenApple.class);

    /**
     * 构造函数
     */
    public goldenApple() {
        //图片使用内置的 使用破碎王冠 的图标
        //使用内置图标就不需要导入了 想自定义可以抄其他的mod或者看教程
        super(ID, "crown.png", RelicTier.RARE, LandingSound.CLINK);
    }
    public void addCampfireOption(ArrayList<AbstractCampfireOption> options) {
        options.add(new changeOption(true));
    }
    /**
     * 在战斗开始时触发
     */
    @Override
    public void atBattleStart() {
        super.atBattleStart();

        AbstractDungeon.player.gainEnergy(1);
    }

    /**
     * 重写遗物的描述内容 可以不用管
     *
     * @return 字符串内容
     */
    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

}
