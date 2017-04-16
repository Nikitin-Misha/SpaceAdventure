package com.company;

public class Hero {

    public Sprite image ;
    private int x;
    private int y;

    private double Vy;
    private double Vx;
    private double ay;


    public void setX(int x) {
        this.x = x;
    }

    public void setVx(int Vx) {
        this.Vx = Vx;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVy(double vy) {
        Vy = vy;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public double getVy() {
        return Vy;
    }

    public double getVx() {
        return Vx;
    }

    public double getAy() {
        return ay;
    }

    public Hero(int x, int y, double vy, double vx,double ay) {
        this.x = x;
        this.y = y;
        Vy = vy;
        this.ay = ay;
        Vx = vx;
        image = Game.getSprite("pictures/sprites_8.run1.png");
        }

    public void jump(double delta) {
        if (y > Constants.minY) {
            Vy = 0;
            y = Constants.minY;
        } else {
            Vy += Constants.ACC * delta;
        }
        y += (int) Vy * delta;
        if (Vy > 20) {
            image = Game.getSprite("pictures/sprites.jumpUP.png");
            Game.CHECK_THE_JUMP = true;
        }
        if (Vy <-20){
            image = Game.getSprite("pictures/sprites.jumpDOWN.png");
            Game.CHECK_THE_JUMP = true;
        }
        if ((y <= Constants.minY) && (y >= Constants.minY-10))
            Game.CHECK_THE_JUMP = false;
    }

    static void processUpPressed()
    {
        Game.hero.setVy(Constants.MAXVy_FOR_HERO);
    }

    static void runningLeft(double delta) {
        Game.hero.setX(Game.hero.getX()-(int)(Game.hero.Vx * delta));
    }

    static void runningRight(double delta) {
        Game.hero.setX(Game.hero.getX()+(int)(Game.hero.Vx * delta));
    }
}
