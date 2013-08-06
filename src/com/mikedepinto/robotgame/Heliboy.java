package com.mikedepinto.robotgame;

public class Heliboy extends Enemy {



	public Heliboy(int centerX, int centerY) {
        damage = 5;
        xpValue = 100;
        jumpSpeed = -3;
		setCenterX(centerX);
		setCenterY(centerY);

	}

}
