
public interface Logic {
    
    
   public Data execute(double xPos, double yPos, double xVel, double yVel, boolean colision);
   
   
}

class Red implements Logic {
    

    @Override
    public Data execute(double xPos, double yPos, double xVel, double yVel, boolean colision) {
        return new Data(false, xPos, yPos, xVel, yVel);
    }
}

class Blue implements Logic {
    
    
    @Override
        public Data execute(double xPos, double yPos, double xVel, double yVel, boolean colision) {
            if (colision){
                return new Data(true, xPos, yPos, xVel - 0.9, yVel - 0.9);
            }
            else{
                return new Data(false, xPos, yPos, xVel, yVel);
            }
        }

		
}


class Black implements Logic {
    
    @Override    
    public Data execute(double xPos, double yPos, double xVel, double yVel, boolean colision) {
            double nW = distance(xPos, yPos, 0.0, 0.0);
            double nE = distance(xPos, yPos, 0.0, 640 );
            double sW = distance(xPos, yPos, 400.0, 0.0);   
            double sE = distance(xPos, yPos, 400.0, 640.0);
            double max = Math.max(Math.max(nW, nE), Math.max(sW, sE));
            if (max == nW){
                return new Data(true, xPos, yPos, xVel + 0.3, yVel + 0.3);
            }
            else if (max == nE){
                return new Data(true, xPos, yPos, xVel + 0.3, yVel - 0.3);
            }
            else if (max == sW){
                return new Data(true, xPos, yPos, xVel - 0.3, yVel + 0.3);
            }
            else{
                return new Data(true, xPos, yPos, xVel - 0.3, yVel - 0.3);
            }    
        }

        public static double distance(double xPos, double yPos, double xCord, double yCord){
            return Math.sqrt(Math.pow(xPos - xCord, 2) + Math.pow(yPos - yCord, 2));
            
        }
     
    }
