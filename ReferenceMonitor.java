/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 *
 * 
 */
public class ReferenceMonitor {

  public static Map<SecuritySubject, SecurityLevel> Sub = new HashMap<SecuritySubject, SecurityLevel>();
  public static Map<SecurityObject, SecurityLevel> Obj = new HashMap<SecurityObject, SecurityLevel>();

  public ReferenceMonitor(){
    
  }
  
  // Determine allowed operations 
//    - handle bad instruction
//    - determine allowed operations
//    - call object manager 
  public int performInstruction(Instruction i){
    
    i.print();
    
    if(i == Instruction.BadInstruction) return 0;
    
    // Perform Operation 
    if(i.type.equalsIgnoreCase("write")){
      return executeWrite(i);
    } else if(i.type.equalsIgnoreCase("read") ) {
      return executeRead(i);
    } else if(i.type.equalsIgnoreCase("create")){
      return executeCreate(i);
    } else if(i.type.equalsIgnoreCase("Destroy")){
      return executeDestroy(i);
    } else if(i.type.equalsIgnoreCase("Run")){
      return executeRun(i);
    }
   
    return 0;
  } // end PerformOperation method 
    
 
  private int executeRead(Instruction i){
      // Find object names
      SecurityObject obj = null; 
      Iterator<SecurityObject> itr = Obj.keySet().iterator();
      while(itr.hasNext()){
        SecurityObject o = itr.next();
        if(o.getName().equalsIgnoreCase(i.obj.getName())){
//          System.out.println("OBJECT FOUND IN READ " + o.getVal());
          obj = o;
//          System.out.println("o: " + o);
        }
          
      }
      
    if(SecurityLevel.dominates(Obj.get(obj), Sub.get(i.sub))){
//      System.out.println("Operation not permitted."); 
      return 1;
    } else 
    {
      int val = ObjectManager.read(obj);
//      System.out.println("Value of READ: " + val);
      
      return 0;
      
    }
      
  }
  
  private int executeWrite(Instruction i){
    
    // Find object names
      SecurityObject obj = null; 
      Iterator<SecurityObject> itr = Obj.keySet().iterator();
      while(itr.hasNext()){
        SecurityObject o = itr.next();
        if(o.getName().equalsIgnoreCase(i.obj.getName())){
//          System.out.println("OBJECT FOUND IN WRITE");
          obj = o;
//           System.out.println("o: " + o);
        }
          
      }
      
//        System.out.println("obj: " + obj);
//        System.out.println("i.obj: " + i.obj);
    if(SecurityLevel.dominates(Sub.get(i.sub), Obj.get(obj))){
      System.out.println("Operation not permitted."); return 0;
    } else return ObjectManager.write(obj, i.parameter);
  }
  
  private int executeCreate(Instruction i){
    // create object obj with security level of sub
    // Initial value = 0; if obj exists, no-op
    for(SecurityObject obj : Obj.keySet() ){
      if (obj.getName().equalsIgnoreCase(i.obj.getName())){
        if(i.sub.getName().equalsIgnoreCase("Lyle")){
        System.out.print("Operation not permitted. Object already exists."); 
        System.out.println(" Bit transferred: 1");
        }
        return 0;
      }
    } // end for 
    if(i.sub.getName().equalsIgnoreCase("Lyle"))
    System.out.println("Bit transferred: 0");
    // Put new object in object map, pointing to subjects security level
    Obj.put(new SecurityObject(i.obj.getName(), 0), Sub.get(i.sub));
//    System.out.println(i.obj.getName() + "-----");
    return 1; 
  } // end executeCREATE 
  
  private int executeDestroy(Instruction i){
    for(SecurityObject obj : Obj.keySet() ){
      if (obj.getName().equalsIgnoreCase(i.obj.getName())){
        Obj.remove(obj);
        return 1;
      }
    } // end for
    
//    System.out.println("Operation not permitted. Object does not exist. "); 
    return 0;
    
  }
  
  private int executeRun(Instruction i){
    
    return i.sub.run();
    
    
  }
  
    // ObjectManager Class 
     static class ObjectManager {
 
      public static int read(SecurityObject o){
//        System.out.println("READ: " + o.getVal());
        return o.getVal();
        
      } // end read 
  
      public static int write(SecurityObject o, int _val){
        o.setVal(_val);
//        System.out.println("WRITE: " + _val + ". " + o.getVal());
        return 0; 
      } // end write 
  
     } // end ObjectManager class
  
}

