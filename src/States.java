import java.util.ArrayList;

// Refactoriza el siguiente código para mejorar su estructura:
public class States {
    // Cambio el enum por un String con los nombres de los estados.
// Para crear cada objeto solamente se introduce el nombre del condado
// y la cantidad amt(amount).
// La variable points se obtiene con condicion según el estado, asi
// como las constantes siguientes, 3 para las tasas (rate)
// y 3 para la base de cada estado.

    private String state;
    private double amt;
    private int points;
    private static double rate;
    private static double base;
    private static final double TX_RATE = 1.568;
    private static final double OH_RATE = 2.568;
    private static final double MN_RATE = 2.025;
    private static final double OT_RATE = 3.525;
    private static final double TX_BASE = 2500;
    private static final double OH_BASE = 1250;
    private static final double MN_BASE = 1720;
    private static final double OT_BASE = 3000;
    // Definimos el constructor para la creación de los objetos Estados....
    public States(String state, double amt) {
        this.state = state;
        this.amt = amt;
    }
    // ....así como un método getPoints() para asignar los puntos según el
// estado introducido.
    public int getPoints(){
        if (state.equals("OHIO"))
            points = 2;
        points=1;
        return points;
    }


    // Con un if elegimos el nombre del estado, la base y la tasa del mismo a través de los setters.
// En caso de no coincidir con uno de los estados, se tomará OTHER como valor del estado, base y tasa.
    public String getState() {
        if (state.equalsIgnoreCase("OHIO")) {
            points = 2;
            return "OHIO";
        } else if (state.equalsIgnoreCase("TEXAS")) {
            points =1;
            return "TEXAS";
        } else if (state.equalsIgnoreCase("MAINE")){
            points =1;
            return "MAINE";}
        else {
            points =1;
            return "OTHER";}
    }
    public void setState(String state) {
        this.state = state;
    }
    public double getRate() {
        if (state.equalsIgnoreCase("OHIO"))
            return OH_RATE;
        else if (state.equalsIgnoreCase("TEXAS"))
            return TX_RATE;
        else if (state.equalsIgnoreCase("MAINE"))
            return MN_RATE;
        else {
            return OT_RATE;
        }
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public double getBase() {
        if (state.equalsIgnoreCase("OHIO")) {
            return OH_BASE;}
        else if (state.equalsIgnoreCase("TEXAS")){
            return TX_BASE;}
        else if (state.equalsIgnoreCase("MAINE")){
            return MN_BASE;}
        else {
            return OT_BASE;
        }
    }
    public void setBase(double base) {
        getBase();
    }
    public double extra(double base) {
        return base*1.5;
    }
    public double basis(double base) {
        return base*getRate();
    }

    public double calculation(double amt) {
        getBase();
        return 2 * basis(amt) + extra(amt) * 1.05;
    }

    @Override
    public String toString() {
        return "Estados:\n________________\n" +
                "Nombre= \"" + getState() + "\"\n"+
                "Cantidad= \"" + String.format("%.2f", amt) + "\"\n" +
                "Base= \"" + String.format("%.2f", getBase()) + "\"\n" +
                "Cálculo= \"" + String.format("%.2f", calculation(amt)) + "\"\n" +
                "Puntos= \"" + getPoints() + "\"\n" +
                "Tasa= \"" + String.format("%.2f", getRate()) + "\"\n";
    }

    public static void main(String[] args) {
        States estado1= new States("TEXAS", 25000);
        States estado2= new States("OHIO",2800);
        States estado3= new States("MAINE",2560);
        States estado4= new States("JERSEY",3250);
        ArrayList<States> condados = new ArrayList<>();
        condados.add(estado1);
        condados.add(estado2);
        condados.add(estado3);
        condados.add(estado4);
        System.out.println("LISTA DE LOS ESTADOS ELEGIDOS CON SUS CANTIDADES,\n" +
                "IMPUESTOS Y CÁLCULO DE ");
        for (States c : condados){
            c.getState();c.getBase();c.getRate();c.getPoints();
            System.out.println(c.toString());
        }
    }
}

