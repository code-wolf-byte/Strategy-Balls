public class Data {
    private double xPos;
    private double yPos;
    // private double radius;
    private double xVel;
    private double yVel;
    private Boolean changed;
    // private String paint;
    private Logic logic; 
    public Data(Ball ball){
        this.xPos = ball.getxPos();
        this.yPos = ball.getyPos();
        this.xVel = ball.getxVel();
        this.yVel = ball.getyPos();
        this.changed = false;
        if (ball.getColour().toString().equals("0xff0000ff")){
            this.logic = new Blue();
        }
        else if (ball.getColour().toString().equals("0x000000ff")){
            this.logic = new Black();
        }
        else{
            this.logic = new Red();
        }

    }
    
    public Data(boolean isChanged, double xPos, double yPos, double xVel, double yVel){
        this.changed = isChanged;
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVel = xVel;
        this.yVel = yVel;     
    }
    public Data execute(boolean colision, double xPos, double yPos, double xVel){
        return this.logic.execute(xPos, yPos, xVel, yVel, colision);
    }
    
    
    double getxPos() {
        return xPos;
    }

    double getyPos() {
        return yPos;
    }

    double getxVel() {
        return xVel;
    }

    double getyVel() {
        return yVel;
    }

    Boolean isChanged() {
        return changed;
    }

}

