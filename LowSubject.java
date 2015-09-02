import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class LowSubject extends SecuritySubject {
  
  File outputFile;
  int word = 0;
  int digit = 0;
  
  LowSubject(String name, File infile){
    super(name);
    setOutFile(infile);
  }
  
  private void setOutFile(File _infile){
    String name =  ".out";
    outputFile = new File(_infile.getAbsolutePath() + name );
  }
  
  public int run(){
//    System.out.println(this.getTEMP());
    
    word += this.getTEMP()*(int)Math.pow(2, digit);
//    System.out.println("Increment:" + this.getTEMP()*(int)Math.pow(2, digit));
    digit++;
    
    
    if(digit > 7){
      digit = 0;
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        System.out.println(word);
//        System.out.println(Character.toString((char) word));
        
        
      try{
        
        PrintWriter pw = new PrintWriter(new FileOutputStream(outputFile, true));
//        System.out.println(outputFile.getAbsolutePath());
        pw.print( Character.toString((char) word));
        pw.close();
      }catch(IOException e){
        System.out.println("Could not write output to file.");
      }
     
      word = 0;
    }
    // In this part, bit is added to byte.
    // If byte is full, write to file. 
    return 0;
  }
  
}
