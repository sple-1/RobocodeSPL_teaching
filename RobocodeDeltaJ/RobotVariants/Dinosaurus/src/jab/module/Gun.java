package jab.module;

import java.util.Random;

/**
 * Gun
 * 
 * @author jab
 */
public class Gun extends Part {

	public Module bot;

	public Gun(Module bot) {
		this.bot = bot;
	}

	public void fire() {
		bot.bulletPower = random.nextInt(4);
	}

	private Random random = new Random();

}
