package jab.module;

import jab.module.Module;
import robocode.Event;
import robocode.ScannedRobotEvent;
import robocode.Rules;
import robocode.util.Utils;

/**
 * Radar
 * 
 * @author jab
 */
public class Radar extends Part {

	public Module bot;

	public void scan() {
		if (bot.getRadarTurnRemaining() == 0.0) {
			bot.setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
		}
	}

	private byte radarDirection;

	public Radar(Module bot) {
		this.bot = bot;
		this.radarDirection = 1;
	}

	public void listen(Event e) {
		if (e instanceof ScannedRobotEvent) {
			double angleToEnemy = bot.getHeadingRadians() + bot.enemy.bearingRadians;

			double radarTurn = Utils.normalRelativeAngle(angleToEnemy - bot.getRadarHeadingRadians());
			double extraTurn = Math.min(Math.atan(90.0 / bot.enemy.distance), Rules.RADAR_TURN_RATE_RADIANS);

			if (radarTurn < 0)
				radarTurn -= extraTurn;
			else
				radarTurn += extraTurn;

			bot.setTurnRadarRightRadians(radarTurn);

		}
	}

}
