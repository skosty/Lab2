public class SecurityLevel {
  
  static final SecurityLevel HIGH = new SecurityLevel();
  static final SecurityLevel LOW = new SecurityLevel();
//  
//  private SecurityLevel(){
//    
//  }
  
  public static boolean dominates(SecurityLevel a, SecurityLevel b){
    if(a == HIGH && b == LOW) return true; 
    else return false; 
  } // end dominates 
  
}
