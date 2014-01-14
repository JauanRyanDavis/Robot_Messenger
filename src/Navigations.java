//Class:	Navigations
//Description:	Objects that hold a direction and amount of steps to travel
//********************************************************************************
public class Navigations {
   int steps;
   String direction;
   boolean reverse;
   
   Navigations(Object xentry, Object yentry){
       this.direction=xentry.toString();
       this.steps=Integer.parseInt(yentry.toString());
   }
   
   public String toString(){
      String output= "Go "+ direction+" "+steps+" steps";
      return output;
   }
   
   public void reverseDirection(){
       if(reverse==true){
           switch (direction) {
               case "N":
                   this.direction="S";
                   break;
               case "S":
                   this.direction="N";
                   break;
               case "E":
                   this.direction="W";
                   break;
               case "W":  
                   this.direction="E";
                   break;
           }
           
       }//End if
   }
}//End Navigations
