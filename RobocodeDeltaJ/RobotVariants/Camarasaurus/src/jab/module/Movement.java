package jab.module;

import jab.module.Module;
import robocode.Event;
import robocode.HitWallEvent;

/**
 * Movement
 * 
 * @author jab
 */
public class Movement extends Part {

	public Module bot;

	public void move() {
		bot.setMaxVelocity(8);
		bot.turnLeft(bot.getHeading() % 90);
		bot.setAhead(moveAmount);
	}

	private double moveAmount;

	public Movement(Module bot) {
		this.bot = bot;
		this.moveAmount = Math.max(bot.getBattleFieldHeight(), bot.getBattleFieldWidth());
	}

	public void listen(Event e) {
		if (e instanceof HitWallEvent) {
			bot.turnRight(90);
			bot.setAhead(moveAmount);
		}
	}

}
