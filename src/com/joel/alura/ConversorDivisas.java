package com.joel.alura;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ConversorDivisas {
    DecimalFormatSymbols a = new DecimalFormatSymbols(Locale.getDefault());
    DecimalFormat mostrarDecimales = new DecimalFormat("#0.00",a);
    
    private String tipoDeCambio;
    private double valorDivisa;
    
    private double[] valoresDivisas = {534.41/*dolar*/,575.68/*euro*/,652/*libras*/,4.06/*Yen*/,0.41/*won*/};
    
    public ConversorDivisas(int cambio, String tipoDeCambio){
        a.setDecimalSeparator('.');
        mostrarDecimales = new DecimalFormat("#0.00",a);
        if(tipoDeCambio.equals("extranjero-colon") || tipoDeCambio.equals("colon-extranjero")){
            this.tipoDeCambio = tipoDeCambio;
        } else{
            this.tipoDeCambio = "indefinido";
        }
        this.valorDivisa = this.valoresDivisas[cambio];
    }
    
    public double Convertir(double valor){
        switch(tipoDeCambio){
            case "colon-extranjero":
                return Double.parseDouble(mostrarDecimales.format(valor/valorDivisa));
            case "extranjero-colon":
                return Double.parseDouble(mostrarDecimales.format(valor*valorDivisa));
            default:
                throw new RuntimeException("Tipo de cambio invalido, intente con colon-extranjero o extranjero-colon");
        }
    }
    
    
}
