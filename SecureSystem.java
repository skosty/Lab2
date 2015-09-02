///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package security1;
//
//
//import java.util.StringTokenizer;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// *
// * 
// */
//public class SecureSystem {
//  
//  static Map<SecuritySubject, String> SubMap = new HashMap<SecuritySubject, String>(); 
//  static Map<SecurityObject, String> ObjMap = new HashMap<SecurityObject, String>();
//  private static ReferenceMonitor rm = new ReferenceMonitor();
//  
//  /**
//   * @param args the command line arguments
//   */
//  public static void main(String[] args) {
//    
//    
//    // Create subjects and objects
//    // Read in file line by line from args[0]
//    // For each line, parseCommand and pass instruction object to rm
////    // Set TEMP of subject 
////    createSubject(new SecuritySubject("Hal"), SecurityLevel.HIGH);
////    createSubject(new SecuritySubject("Lois"), SecurityLevel.LOW);
////    createObject(new SecurityObject("MalcolmsAllowance", 0), SecurityLevel.HIGH); 
////    createObject(new SecurityObject("ReesesGrades", 0), SecurityLevel.LOW);
//    createSubject(new SecuritySubject("Hal"), SecurityLevel.HIGH);
//    createSubject(new SecuritySubject("Lyle"), SecurityLevel.LOW);
//    createObject(new SecurityObject("HObj", 0), SecurityLevel.HIGH); 
//    createObject(new SecurityObject("LObj", 0), SecurityLevel.LOW);
//    
//    File InputFile = new File(args[0]);
//    try{
//      BufferedReader fr = new BufferedReader(new FileReader(InputFile));
//      String line;
//      while( (line = fr.readLine()) != null){
//        if(line.isEmpty()) continue;
//        Instruction i = parseCommand(line);
//        int result = rm.performInstruction(i);
//        if(i.sub != null) i.sub.setTEMP(result);
//        
//        printState();
//      } // end while 
//      
//    } // end try     
//    catch(FileNotFoundException e){
//      System.out.println("ERROR: Could not find file " + InputFile.getAbsolutePath());
//    }catch(IOException io){
//      System.out.println("ERROR: Exception reading line.");
//    }
//			
//    
//  } // end main 
//  
//  static void printState(){
//    
//    // print subjects
//    for(SecuritySubject sub : SubMap.keySet() ){
//      System.out.print(sub.name + ": " + sub.getTEMP() + "\t");
//    }
//    System.out.println("");
//    // print objects
//    for(SecurityObject obj : ObjMap.keySet() ){
//      System.out.print(obj.name + ": " + obj.getVal() + "\t");
//    }
//    
//    System.out.println("\n");
//  }
//  
//  static private void createSubject(SecuritySubject sub, SecurityLevel level){
//    // Add subject to this list and ReferenceMonitor list 
//    SubMap.put(sub, sub.getName().toUpperCase());
//    rm.Sub.put(sub,level);
//  } // end createSubject 
//  
//  static private void createObject(SecurityObject obj, SecurityLevel level){
//    // Add object to this list and ReferenceMonitor list 
//    ObjMap.put(obj, obj.getName().toUpperCase());
//    rm.Obj.put(obj,level);
//  } // end createObject 
//  
//  
//  public static Instruction parseCommand(String line){
//    
//   
//    String _type = null;
//    SecuritySubject _sub = null;
//    SecurityObject _obj = null; 
//    Integer _parameter = null;
//    String tmp = null; 
//    
//    
//    // Create tokenizer 
//    StringTokenizer strTok = new StringTokenizer(line);
//    
//    // Check for empty command
//    if(!strTok.hasMoreTokens()) return Instruction.BadInstruction; 
//    
//    // Find type 
//    tmp = strTok.nextToken().toUpperCase();
//    if(tmp.equalsIgnoreCase("read")) _type = "READ";
//    else if(tmp.equalsIgnoreCase("write")) _type = "WRITE";
//    else return Instruction.BadInstruction; 
//    
//    // Get subject 
//    if(!strTok.hasMoreTokens()) return Instruction.BadInstruction; 
//    tmp = strTok.nextToken().toUpperCase();
//    if(SubMap.containsValue(tmp)){
//      // get object associated to name tmp by iterating over keys
//      for(SecuritySubject sub : SubMap.keySet()){
//        if(sub.getName().equalsIgnoreCase(tmp)) _sub = sub; 
//      }
//    } 
//            
//    else return Instruction.BadInstruction; // if subject doesn't exist return bad instruction
//    
//    // Get Object 
//    if(!strTok.hasMoreTokens()) return Instruction.BadInstruction; 
//    tmp = strTok.nextToken().toUpperCase();
//    if(ObjMap.containsValue(tmp)){
//      // get object associated to name tmp by iterating over keys
//      for(SecurityObject obj : ObjMap.keySet()){
//        if(obj.getName().equalsIgnoreCase(tmp)) _obj = obj; 
//      }
//    } 
//    else return Instruction.BadInstruction; // if object doesn't exist return bad instruction
//    
//    
//    
//    
//    // Get Parameters
//    if(_type.equalsIgnoreCase("write")){
//      if(!strTok.hasMoreTokens()) return Instruction.BadInstruction; 
//      
//      // Parse for int 
//      Integer param = null;
//      try{
//        param = Integer.parseInt(strTok.nextToken());
//      } catch(NumberFormatException e){
//        return Instruction.BadInstruction;
//      }
//      
//      _parameter = param;
//    } // end parameter if 
//
//    // Make sure no other arguments are given
//    if(strTok.hasMoreTokens()) return Instruction.BadInstruction;
//    
//    Instruction inst;
//    if(_parameter == null)  inst = new Instruction(_type, _sub, _obj);
//    else  inst = new Instruction(_type, _sub, _obj, _parameter);
//    
//    return inst;
//  } // end parseCommand
//  
//  
//  
//}
