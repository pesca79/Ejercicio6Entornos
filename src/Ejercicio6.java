// Refactoriza el siguiente código para mejorar su estructura:
import java.util.*;
public class Ejercicio6 {
    public static final double TX_RATE = 1;
    public static final double MN_RATE = 2;
    public static final double OH_RATE = 3;
    public static int points = 0;
    public static double amt;
    public static double calc;
    public static double base;
    public static double rate;
    public static double basis(double amt){return 0;}
    public static double extra(double amt){return 0;}
    public static void setRate(double rate) {Ejercicio6.rate = rate;}
    public static void main(String[] args) {
        ArrayList<String> state = new ArrayList<>();
        state.add("TEXAS");
        state.add("OHIO");
        state.add("MAINE");
        state.add("OTHER");
        for(int i = 0; i<state.size();i++){
            if (state.get(i) == "TEXAS") {
                setRate(TX_RATE);
                amt = base * TX_RATE;
                calc = 2 * basis(amt) + extra(amt) * 1.05;
            } else if ((state.get(i) == "OHIO") || (state.get(i) == "MAINE")) {
                if (state.get(i) == "OHIO") {rate = OH_RATE;}
                else {rate = MN_RATE;}
                amt = base * rate;
                calc = 2 * basis(amt) + extra(amt) * 1.05;
            } else if (state.get(i) == "OHIO") {points = 2;}
            else {
                rate = 1;
                amt = base;
                calc = 2 * basis(amt) + extra(amt) * 1.05;
            }
        }
    }
}
/*
if (state == TEXAS) {
 rate = TX_RATE;
 amt = base * TX_RATE;
 calc = 2*basis(amt) + extra(amt)*1.05;
}
else if ((state == OHIO) || (state == MAINE)) {
 rate = (state == OHIO) ? OH_RATE : MN_RATE;
 amt = base * rate;
 calc = 2*basis(amt) + extra(amt)*1.05;
 if (state == OHIO)
 points = 2;
 }
 else {
 rate = 1;
 amt = base;
 calc = 2*basis(amt) + extra(amt)*1.05;
}
}
*/
