//Program:	RobotRobinhood.java
//Course:	COSC210
//Description:	Program reads the content of a text file that contain directions and
//              a message for the robot to deliver when it reaches its destination.
//              After message is delivered, robot returns to its start position.
//Author:	Jauan Davis
//Revised:	11/8/12
//Language:	Java
//IDE:		NetBeans 7.2
//*******************************************************************************
//*******************************************************************************
import java.util.StringTokenizer; 
public class RobotRobinhood {
 //Method:	main
//Description:	Method prompts user to enter text file that contains instructions 
//              for the robot. Each directipn and steps are stored on an Object of type
//              Navigations and push onto the LinkedStack stack. When the robot is returning
//              to start position the stack is just popped to get the robot back to its
//              start position.
//Parameters:  	none
//Returns:     	void
//Calls:       	none
    public static void main(String[] args) {
       KeyboardInputClass keyboardInput = new KeyboardInputClass();
       TextFileClass textFile = new TextFileClass();
     for(;;){
       textFile.getFileName("Specify the text file address containing the robot instructions: (Enter X to exit)");
       if(textFile.fileName.equalsIgnoreCase("X")){
           return;
       }
       String content= "";
       if (textFile.fileName.length()>0){
           if (textFile.getFileContents()>0){
             for(int i=0; i<textFile.lineCount; i++){
              content= content+ textFile.text[i];
              }
           }
       }//End if
       String showsteps=keyboardInput.getKeyboardInput("Show intermediate steps? (Y/N)");
       System.out.println("");
       StringTokenizer directions= new StringTokenizer(content,",\n\r");
       StackInterface stack=new LinkedStack();
       Navigations traveling; Navigations returning;
       int tokens=(directions.countTokens()-3)/2;
       int x= Integer.parseInt(directions.nextElement().toString());
       int y= Integer.parseInt(directions.nextElement().toString());
       
    System.out.println("Starting coordinates: ("+x+","+y+")");
    while(directions.hasMoreElements() && tokens!=0){
      traveling= new Navigations(directions.nextElement(),directions.nextElement());

      if("N".equals(traveling.direction)){
        y+=traveling.steps;
      }   
      if("S".equals(traveling.direction)){
        y-=traveling.steps;
      }    
      if("E".equals(traveling.direction)){
        x+=traveling.steps;
      }    
      if("W".equals(traveling.direction)){
        x-=traveling.steps;
      }
      stack.push(traveling);
      if(showsteps.equalsIgnoreCase("Y")){
      System.out.println(traveling);
      }
      tokens--;
   }
   System.out.println("Destination coordinates: ("+x+","+y+")");
   System.out.println("The message is: "+directions.nextElement().toString());
   System.out.println("\nReturning to starting point..."); 
   while(stack.isEmpty()!=true){
     returning= (Navigations)stack.pop();
     returning.reverse=true;
     returning.reverseDirection();
      if("N".equals(returning.direction)){
        y+=returning.steps;
      }   
      if("S".equals(returning.direction)){
        y-=returning.steps;
      }    
      if("E".equals(returning.direction)){
        x+=returning.steps;
      }    
      if("W".equals(returning.direction)){
        x-=returning.steps;
      }
      if(showsteps.equalsIgnoreCase("Y")){
      System.out.println(returning);
      }
   }//End while
   System.out.println("Robot has returned to position: ("+x+","+y+")\n");
 }//End forloop  
    }//end main
}//End class

