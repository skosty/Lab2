/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import java.util.StringTokenizer;

/**
 *
 *
 */
public class Instruction {

  public static final Instruction BadInstruction = new Instruction("BadInstruction", null, null);
  String type;
  SecuritySubject sub;
  SecurityObject obj;
  int parameter = 0;

  Instruction(String type, SecuritySubject sub, SecurityObject obj) {
    this.type = type;
    this.sub = sub;
    this.obj = obj;
  }

  Instruction(String type, SecuritySubject sub, SecurityObject obj, int parameter) {
    this.type = type;
    this.sub = sub;
    this.obj = obj;
    this.parameter = parameter;
  }

  public void print() {
    if (this == BadInstruction) {
      System.out.println("BadInstruction");
      return;
    }
    if (this.obj == null) {
      System.out.println(this.type + " " + this.sub.getName());
      return;
    }
    System.out.print(this.type + ": " + this.sub.getName() + " " + this.obj.getName());
    if (this.type.equalsIgnoreCase("write")) {
      System.out.print(" " + parameter);
    }
    System.out.println("");
  }
}
