/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * 
 */
public class SecurityObject {
  
  String name = null;
  int val; 
  
  public SecurityObject(String _name, int _val){
    this.name = _name;
    this.val = _val;
  }
  
  public String getName(){
    return name; 
  }
  
  public int getVal(){
    return val; 
  }
 
  public void setVal(int _val){
    this.val = _val;
  }
  
  
}
