public abstract class SecuritySubject {
  
  String name = null;
  private int TEMP; 
  
  public SecuritySubject(String _name){
    this.name = _name;
  }
  
  public String getName(){
    return name; 
  }
  
  public int getTEMP(){
    return TEMP; 
  }
 
  public void setTEMP(int _TEMP){
    this.TEMP = _TEMP;
//    System.out.println(this.TEMP);
  }
  
  abstract int run();
  
}
