package jab.module;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.Random;
import robocode.util.Utils;
import jab.module.Module;

/**
 * Targeting
 * 
 * @author jabier.martinez
 */
public class Targeting extends Part {

	public Module bot;

	public Targeting(Module bot) {
		this.bot = bot;
	}

	public void target() {
		//Putar senjata ke arah acak
		double randomAngle = random.nextDouble() * 2 * Math.PI; //Sudut acak dalam radian
		double gunTurnAngle = Utils.normalRelativeAngle(randomAngle - bot.getGunHeadingRadians());
		bot.setTurnGunRightRadians(gunTurnAngle);
	}

	private Random random = new Random();

	public void onPaint(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.drawOval((int) bot.getX() - 50, (int) bot.getY() - 50, 100, 100);
	}

}
