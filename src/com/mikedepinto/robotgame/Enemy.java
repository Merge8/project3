package com.mikedepinto.robotgame;

import android.graphics.Rect;


public class Enemy {

	private int power, centerX, speedX, centerY;
	private Background bg = GameScreen.getBg1();
	private Robot robot = GameScreen.getRobot();

	public Rect r = new Rect(0, 0, 0, 0);



    public int health = 5;
    public int damage;
	private int movementSpeed;
    public int xpValue;
    public int jumpSpeed;
    public int speedY = 0;


    public boolean jumped;

	// Behavioral Methods
	public void update() {
		if (health >0) {
        follow();
        }

		centerX += speedX;
		speedX = bg.getSpeedX() * 5 + movementSpeed;
		r.set(centerX - 25, centerY - 25, centerX + 25, centerY + 35);

		if (Rect.intersects(r, Robot.yellowRed)) {
			checkCollision();
		}
		

	}

	private void checkCollision() {
		if (Rect.intersects(r, Robot.rect)|| Rect.intersects(r, Robot.rect2)
				|| Rect.intersects(r, Robot.rect3) || Rect.intersects(r, Robot.rect4)) {

            // if enemy runs into character

            robot.robotHP = robot.getRobotHP() - damage;
            if (robot.getCenterX() < centerX) {
            robot.centerX -= 5;
            robot.centerX -= 5;
            robot.centerX -= 5;
            robot.centerX -= 5;
            robot.centerX -= 5;
            } else if (robot.getCenterX() > centerX){
                robot.centerX += 5;
                robot.centerX += 5;
                robot.centerX += 5;
                robot.centerX += 5;
                robot.centerX += 5;
            } else {

            }



        }
	}

    public void jump() {


            if (centerY > 150 && jumped == false){
                centerY += jumpSpeed;
                centerY += jumpSpeed;
                if (centerY < 150){
                jumped = true;
            }
            } else if (centerY > 350 && jumped == true);
        centerY -= jumpSpeed;
        if (centerY > 350){
        jumped = false;
        }

        }


	public void follow() {

		//2 test
		//jump();
        // 3 test
		if (centerX < -95 || centerX > 810){
			movementSpeed = 0;
		}

		else if (Math.abs(robot.getCenterX() - centerX) < 5) {
			movementSpeed = 0;
		}

		else {

			if (robot.getCenterX() >= centerX) {
				movementSpeed = 1;
			} else {
				movementSpeed = -1;
			}
		}

	}




	public void die() {

	}
    public int getHealth() {
        return health;
    }
	public void attack() {

	}

	public int getPower() {
		return power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Background getBg() {
		return bg;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

}