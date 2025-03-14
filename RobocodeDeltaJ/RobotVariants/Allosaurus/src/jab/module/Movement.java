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
		// Limit our speed to 8
		bot.setMaxVelocity(8);
		// Start moving (and turning)
		bot.setAhead(10000);
	}

	private int turnRightValue;

	public Movement(Module bot) {
		this.bot = bot;
		this.turnRightValue = 45;
	}

	public void listen(Event e) {
		if (e instanceof HitWallEvent) {
			bot.setTurnRight(turnRightValue);
		}
	}

}
