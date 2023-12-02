package com.example.evifinal;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class IMCCalculator {
    public static double calcularIMC(double peso, double estatura) {
        if (estatura != 0) {
            double IMC= peso / Math.pow(estatura, 2);
            BigDecimal roundedIMC = new BigDecimal(IMC).setScale(2, RoundingMode.HALF_UP);
            return roundedIMC.doubleValue();
        } else {
            return 0;
        }
    }

    public static String obtenerCategoriaIMC(double imc) {
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Peso saludable";
        } else if (imc >= 25.0 && imc <= 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}
