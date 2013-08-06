package com.mikedepinto.robotgame;
// test project 3

import android.graphics.Rect;

import java.util.ArrayList;

public class Robot {

	// Constants are Here
	final int JUMPSPEED = -20;
	final int MOVESPEED = 5;

	public int centerX = 100;
	private int centerY = 377;
	private boolean jumped = false;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean ducked = false;
	private boolean readyToFire = true;

	private int speedX = 0;
	private int speedY = 0;
	public static Rect rect = new Rect(0, 0, 0, 0);
	public static Rect rect2 = new Rect(0, 0, 0, 0);
	public static Rect rect3 = new Rect(0, 0, 0, 0);
	public static Rect rect4 = new Rect(0, 0, 0, 0);
	public static Rect yellowRed = new Rect(0, 0, 0, 0);
	
	public static Rect footleft = new Rect(0,0,0,0);
	public static Rect footright = new Rect(0,0,0,0);
	
	
	private Background bg1 = GameScreen.getBg1();
	private Background bg2 = GameScreen.getBg2();

	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private ArrayList<MainAttack> mainAttack = new ArrayList<MainAttack>();

    // Character stats
    public int attackDamage, attackX, attackY;
    public int totalX = 0;
    public int robotXP = 0;
    public int robotHP = 100;
    public int robotMana = 100;
    public double robotManaRegen = 0.05;
    public double robotRegenCounter = 0.05;
    public int xpToLevel = 100;
    public int level = 1;


    public boolean isFacingRight = true;


	public void update() {
		// Moves Character or Scrolls Background accordingly.

		if (speedX < 0 && centerX > 300) {
			centerX += speedX;

            // creates a total X value
            totalX += speedX;
		}
		if (speedX == 0 || speedX < 0) {
			bg1.setSpeedX(0);
			bg2.setSpeedX(0);

		}
		if (centerX <= 500 && speedX > 0) {
			centerX += speedX;

            totalX += speedX;
		}
        if (centerX <200 && speedX < 0){
            centerX += speedX;

            totalX += speedX;
        }
		if (speedX > 0 && centerX > 500) {
			bg1.setSpeedX(-MOVESPEED / 5);
			bg2.setSpeedX(-MOVESPEED / 5);

            totalX += speedX;
		}
        if (centerX <= 300 && speedX <0){
            bg1.setSpeedX(MOVESPEED / 5);
            bg2.setSpeedX(MOVESPEED / 5);

            totalX += speedX;
        }

		// Updates Y Position
		centerY += speedY;

		// Handles Jumping

			speedY += 1;

		if (speedY > 3){
			jumped = true;
		}

		// Prevents going beyond X coordinate of 0
		//if (centerX + speedX <= 60) {
		//	centerX = 61;
		//}

		rect.set(centerX - 34, centerY - 63, centerX + 34, centerY);
		rect2.set(rect.left, rect.top + 63, rect.left+68, rect.top + 128);
		rect3.set(rect.left - 26, rect.top+32, rect.left, rect.top+52);
		rect4.set(rect.left + 68, rect.top+32, rect.left+94, rect.top+52);
		yellowRed.set(centerX - 110, centerY - 110, centerX + 70, centerY + 70);
		footleft.set(centerX - 50, centerY + 20, centerX, centerY + 35);
		footright.set(centerX, centerY + 20, centerX+50, centerY+35);


    if (robotRegenCounter < 1){
        robotRegenCounter += robotManaRegen;
    } else {
        robotRegenCounter -= 1;
        robotMana += 1;
    }



	}

	public void moveRight() {
		if (ducked == false) {
			speedX = MOVESPEED;
            isFacingRight = true;
		}
	}

	public void moveLeft() {
		if (ducked == false) {
			speedX = -MOVESPEED;
            isFacingRight = false;
		}
	}

	public void stopRight() {
		setMovingRight(false);
		stop();
	}

	public void stopLeft() {
		setMovingLeft(false);
		stop();
	}

	private void stop() {
		if (isMovingRight() == false && isMovingLeft() == false) {
			speedX = 0;
		}

		if (isMovingRight() == false && isMovingLeft() == true) {
			moveLeft();
		}

		if (isMovingRight() == true && isMovingLeft() == false) {
			moveRight();
		}

	}

	public void jump() {
		if (jumped == false) {
			speedY = JUMPSPEED;
			jumped = true;
		}

	}

	public void shoot() {
        if(robotMana > 10){

		if (readyToFire) {
			Projectile p = new Projectile(centerX + 50, centerY - 25);
			projectiles.add(p);
		 robotMana -= 10;
        }

        } // end if have mana
    } // end shoot

    public void MainAttack(){
        MainAttack ma = new MainAttack(centerX + 50, centerY - 25);
        mainAttack.add(ma);

        }




    public void xpScale(){

        switch(level){
            case 1: {
                xpToLevel = 100;
                break;

            }
            case 2:{
                xpToLevel = 250;
                break;
            }
            case 3: {
                xpToLevel = 625;
                break;
            }
            case 4: {
                xpToLevel = 1565;
                break;
            }
            case 5: {
                xpToLevel = 3900;
                break;
            }


        } // end switch
    }
    public void levelUp(){



        if (robotXP >= xpToLevel){
            level += 1;
            xpScale();


        } else {

        }


    } // end levelup method
public int getTotalX(){
    return totalX;
}
    public int getXpToLevel(){
        return xpToLevel;
    }
    public int getLevel(){
        return level;
    }
	public int getCenterX() {
		return centerX;
	}
    public int getRobotHP(){
        return robotHP;
    }
    public int getRobotMana(){
        return robotMana;
    }
    public int getRobotXP(){
        return robotXP;
    }

	public int getCenterY() {
		return centerY;
	}

	public boolean isJumped() {
		return jumped;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public boolean isDucked() {
		return ducked;
	}

	public void setDucked(boolean ducked) {
		this.ducked = ducked;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public ArrayList getProjectiles() {
		return projectiles;
	}
    public ArrayList getMainAttack(){
        return mainAttack;
    }
    public boolean getIsFacingRight() {
        return isFacingRight;
    }


    public boolean isReadyToFire() {
		return readyToFire;
	}

	public void setReadyToFire(boolean readyToFire) {
		this.readyToFire = readyToFire;
	}

}
