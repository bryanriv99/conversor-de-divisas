import java.util.Map;

public class Moneda {
    private final Map<String,Double> tasas;

    public Moneda(Datos datos) {
        this.tasas = datos.conversion_rates();
    }

    public double pesoADolar(double peso){
        return peso*tasas.get("USD");
    }

    public double DolarAPeso(double dolar){
        return dolar*tasas.get("MXN");
    }

    public double PesoAPesoArg(double peso){
        return peso*tasas.get("ARS");
    }

    public double PesoArgAPeso(double peso){
        return peso*tasas.get("MXN");
    }

    public double yenAPeso(double yen){
        return yen * tasas.get("MXN");
    }

    public double peroAYen(double peso){
        return peso * tasas.get("JPY");
    }

    public double pesoASol(double peso){
        return peso * tasas.get("PEN");
    }

    public double solAPeso(double sol){
        return sol * tasas.get("MXN");
    }
}
