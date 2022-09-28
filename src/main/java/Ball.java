import javafx.scene.paint.Paint;

import java.util.Random;

public class Ball {
    private double xPos;
    private double yPos;
    private double radius;
    private double xVel;
    private double yVel;
    private Paint colour;
    // private Logic logic;
    // private Boolean changed;
    private Data data;

    Ball(double startX, double startY, double startRadius, Paint colour) {
        this.xPos = startX;
        this.yPos = startY;
        this.radius = startRadius;
        this.colour = colour;
        xVel = new Random().nextInt(5);
        yVel = new Random().nextInt(5);
    //    this.changed = false;
    }

    void tick() {
        xPos += xVel;
        yPos += yVel;
    }

    void setxVel(double xVel) {
        this.xVel = xVel;
    }

    void setyVel(double yVel) {
        this.yVel = yVel;
    }

    double getRadius() {
        return radius;
    }

    double getxPos() {
        return xPos;
    }

    double getyPos() {
        return yPos;
    }

    Paint getColour() {
        return colour;
    }

    double getxVel() {
        return xVel;
    }

    double getyVel() {
        return yVel;
    }

    void setxPos(double xPos) {
        this.xPos = xPos;
    }

    void setyPos(double yPos) {
        this.yPos = yPos;
    }

    void think(boolean collision) {
        // Here is where the strategy should have some effect.
        // You can add parameters to the think method so the ball knows something about its
        // world to make decisions with, or you can inject things upon construction for it to query
        // if you prefer.
        this.data = new Data(this);
        this.data = this.data.execute(collision, this.xPos, this.yPos, this.xVel);
        if (this.data.isChanged()){
            this.setxPos(this.data.getxPos());
            this.setyPos(this.data.getyPos());
            this.setxVel(this.data.getxVel());

            // this.ste = this.data.getxPos();
            // this.yPos = this.data.getyPos();
            // this.xVel = this.data.getxVel();
            // this.yVel = this.data.getyVel();
        }
    }
}
