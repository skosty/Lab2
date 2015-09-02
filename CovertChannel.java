import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class CovertChannel {

  private static ReferenceMonitor rm = new ReferenceMonitor();
  
  public static void main(String[] args) throws FileNotFoundException  {
    long STARTTIME = System.currentTimeMillis();
    String outfileString; 
    File outFile; 
    // Redirect Output
    if(args.length > 1){ // first arg is verbose
      outFile = new File(args[1]);
      System.setOut(new PrintStream( new File(outFile.getAbsolutePath() + ".log") )) ;
    }else
      outFile = new File(args[0]);
    
    // Create Subjects 
    HighSubject Hal = new HighSubject("Hal");
    LowSubject Lyle = new LowSubject("Lyle", outFile);
    rm.Sub.put(Hal, SecurityLevel.HIGH);
    rm.Sub.put(Lyle, SecurityLevel.LOW);
    
    // Create reader stream 
    BufferedReader br = null; 
    try{
      br = new BufferedReader(new FileReader(outFile));
    } catch(FileNotFoundException f){
      System.out.println("File " + outFile.getAbsolutePath() + "not found for reading.");
    }
    
    // Read in file, line by line
    String line;
    try{
      
    while((line = br.readLine()) != null){
      // For each character 
      for(int i = 0; i < line.length(); i++){  
       byte character = (byte) line.charAt(i);
       // Cycle bits
       for(int bit = 0; bit < 8; bit++){
         if((character & (1 << bit) ) != 0  ){
           Hal.setTEMP(1);// bit is 1, set hal temp to 1
         }
         else{
           Hal.setTEMP(0);// bit is 0, set hal temp to 0
         }
  
       
         // Generate Instructions
          // If Hal.getTemp = 1, create
         
         // TMP OBJECT 
         
         SecurityObject tmpOBJ = new SecurityObject("Obj", 0);
         
         if(Hal.getTEMP() == 1){
           rm.performInstruction(new Instruction("Create", Hal, tmpOBJ  ));
         }
          rm.performInstruction(new Instruction("Create", Lyle, tmpOBJ ));
          rm.performInstruction(new Instruction("Write", Lyle, tmpOBJ, 1));
          Lyle.setTEMP(rm.performInstruction(new Instruction("Read", Lyle, tmpOBJ)));
          rm.performInstruction(new Instruction("Destroy", Lyle, tmpOBJ));
          rm.performInstruction(new Instruction("Run", Lyle, null));
          
//         if(Hal.getTEMP() == 1){
//           rm.performInstruction(new Instruction("Create", Hal, new SecurityObject("Obj", 0)  ));
//         }
//          rm.performInstruction(new Instruction("Create", Lyle, new SecurityObject("Obj", 0) ));
//          rm.performInstruction(new Instruction("Write", Lyle, new SecurityObject("Obj", 0), 1));
//          Lyle.setTEMP(rm.performInstruction(new Instruction("Read", Lyle, new SecurityObject("Obj", 0))));
//          rm.performInstruction(new Instruction("Destroy", Lyle, new SecurityObject("Obj", 0)));
//          rm.performInstruction(new Instruction("Run", Lyle, null));
//          
          // Lyle create
            // Lyle write
            // Lyle read
            // Lyle destroy
            // Lyle run 
       
       
       
       
       }// end inner bit loop 
      } // end for loop 
      
      
    } // end while
    
    }catch(IOException e){
      System.out.println("Error reading line.");
    } // end IOexception catch 
    
    
    long ENDTIME = System.currentTimeMillis();
    System.out.println("Run Time: " + (ENDTIME - STARTTIME) + " ms");
  }
}
