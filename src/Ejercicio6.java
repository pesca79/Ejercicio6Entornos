import java.util.ArrayList;

// Refactoriza el siguiente código para mejorar su estructura:
public class Ejercicio6 {
 private String name;
 private double amt;
 private double base;
 private double calc;
 private int points;
 private double rate;

 public Ejercicio6(String name, double amt, double base, int points, double rate) {
  this.name = name;
  this.amt = amt;
  this.base = base;
  this.points = points;
  this.rate = rate;
 }

 public enum state {
  OHIO("OHIO", 2, 200),
  TEXAS("TEXAS", 3, 300),
  MAINE("MAINE", 2.0, 300),
  OTHER("OTHER", 3.0, 500);
  public static String name;
  public static double rate;
  public static double base;
  state(String name, double rate, double base) {
  }
 }

 public String getName() {
  if (name.equalsIgnoreCase("OHIO"))
   return state.OHIO.name();
  else if (name.equalsIgnoreCase("TEXAS"))
   return state.TEXAS.name();
  else if (name.equalsIgnoreCase("MAINE"))
   return state.MAINE.name();
  else {
   return state.OTHER.name();
  }
 }
 public void setName(String name) {
  this.name = getName();
 }
 public double getRate() {
  final double TX_RATE = state.TEXAS.rate;
  final double OH_RATE = state.OHIO.rate;
  final double MN_RATE = state.MAINE.rate;
  final double OT_RATE = state.OTHER.rate;
  if (name.equalsIgnoreCase("OHIO"))
   return OH_RATE;
  else if (name.equalsIgnoreCase("TEXAS"))
   return TX_RATE;
  else if (name.equalsIgnoreCase("MAINE"))
   return MN_RATE;
  else {
   return OT_RATE;
  }
 }
 public void setRate(double rate) {
  this.rate = getRate();
 }
 public double getBase() {
  final double TX_BASE = state.TEXAS.base;
  final double OH_BASE = state.OHIO.base;
  final double MN_BASE = state.MAINE.base;
  final double OT_BASE = state.OTHER.base;
  if (getName().equalsIgnoreCase("OHIO")) {
   setBase(OH_BASE);
  } else if (getName().equalsIgnoreCase("TEXAS"))
   setBase(TX_BASE);
  else if (getName().equalsIgnoreCase("MAINE"))
   setBase(MN_BASE);
  else {
   setBase(OT_BASE);
  }
  return 0;
 }
 public void setBase(double base) {
  this.base = base;
 }
 public double extra(double base) {
  return base*1.5;
 }
 public double basis(double amt) {
  return amt*getRate();
 }

 public double calculation(double amt) {
  return calc = 2 * basis(amt) + extra(amt) * 1.05;
 }

 @Override
 public String toString() {
  return "Estados: " +
          "Nombre= \"" + getName() + "\"\n"+
          "Cantidad= \"" + amt + "\"\n" +
          "Base= \"" + base + "\"\n" +
          "Cálculo= \"" + calculation(amt) + "\"\n" +
          "Puntos= \"" + points + "\"\n" +
          "Tasa= \"" + rate + "\"\n";
 }

 public double doAllCalcules() {
  if (getName().equals("TEXAS")) {
   this.rate = state.TEXAS.rate;
   return calculation(state.TEXAS.rate);
  } else if (getName().equals("OHIO")) {
   this.rate = state.OHIO.rate;
   return calculation(state.OHIO.rate);
  } else if (getName().equals("MAINE")) {
   this.rate = state.MAINE.rate;
   return calculation(state.MAINE.rate);
  } else
   this.rate = state.OTHER.rate;
  return calculation(state.OTHER.rate);
 }
 public static void main(String[] args) {
  Ejercicio6 estado1= new Ejercicio6("TEHAS",25000,250,2,1.0);
  Ejercicio6 estado2= new Ejercicio6("OHIO",2800,275,1,2.2);
  Ejercicio6 estado3= new Ejercicio6("MAINE",2560,225,3,2.5);
  Ejercicio6 estado4= new Ejercicio6("OTHER",3250,300,2,1.8);
  ArrayList<Ejercicio6> condados = new ArrayList<>();
  condados.add(estado1);
  condados.add(estado2);
  condados.add(estado3);
  condados.add(estado4);
  for (Ejercicio6 c : condados){
   System.out.println(c.toString());
  }
 }
}

