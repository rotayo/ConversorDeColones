/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joel.alura;

import javax.swing.*;

/**
 *
 * @author Jowoel
 */
public class Menus extends javax.swing.JFrame{
    private double valorInicial;
    
    /*Menu Principal*/
    JPanel MenuPrincipal = new JPanel();
    JLabel textoMenuPrincipal = new JLabel();
    String[] opcionesCajaOpciones = {"Conversor de Monedas"};
    JComboBox<String> cajaOpciones = new JComboBox<>(opcionesCajaOpciones);
    
    /*Menu Tipo de Cambio*/
    JPanel MenuTipoDeCambio = new JPanel();
    JLabel textoTipoDeCambio = new JLabel();
    String[] opcionesOpcionesDeCambio = {"Colones a dolares", "Colones a euros", "Colones a libras", "Colones a yenes", "Colones a wones", 
        "Dolares a colones", "Euros a colones", "Libras a colones", "Yenes a colones", "Wones a colones", };
    JComboBox<String> cajaCambios = new JComboBox<>(opcionesOpcionesDeCambio);
    
    public Menus(){
        inicializacionMenus();
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorDeConversion) {
        this.valorInicial = valorDeConversion;
    }
    
    public void inicializacionMenus(){
        MenuPrincipal.add(textoMenuPrincipal);
        MenuPrincipal.add(cajaOpciones);
        textoMenuPrincipal.setText("Seleccione una opcion: ");
        
        MenuTipoDeCambio.add(textoTipoDeCambio);
        MenuTipoDeCambio.add(cajaCambios);
        textoTipoDeCambio.setText("Seleccione el tipo de cambio: ");
        
    }
    
    public String resultadoConversion(){
        String monedaInicial = "";
        String monedaConvertida = "";
        double valorConvertido = 0;
        ConversorDivisas conversor;
        
        if(cajaCambios.getSelectedIndex() <= 4 ){
            monedaInicial = " colones ";
            switch(cajaCambios.getSelectedIndex()){
                case 0:
                    monedaConvertida = " dolares ";
                    conversor = new ConversorDivisas(0,"colon-extranjero");
                    valorConvertido = conversor.Convertir(valorInicial);
                    break;
                case 1:
                    monedaConvertida = " euros ";
                    conversor = new ConversorDivisas(1,"colon-extranjero");
                    valorConvertido = conversor.Convertir(valorInicial);
                    break;
                case 2:
                    monedaConvertida = " libras ";
                    conversor = new ConversorDivisas(2,"colon-extranjero");
                    valorConvertido = conversor.Convertir(valorInicial);
                    break;
                case 3:
                    monedaConvertida = " yenes ";
                    conversor = new ConversorDivisas(3,"colon-extranjero");
                    valorConvertido = conversor.Convertir(valorInicial);
                    break;
                case 4:
                    monedaConvertida = " wones ";
                    conversor = new ConversorDivisas(4,"colon-extranjero");
                    valorConvertido = conversor.Convertir(valorInicial);
                    break;
            }
        }else{
            monedaConvertida = " colones ";
            switch(cajaCambios.getSelectedIndex()){
                case 5:
                    monedaInicial = " dolares ";
                    conversor = new ConversorDivisas(0,"extranjero-colon");
                    valorConvertido = conversor.Convertir(valorInicial);
                    break;
                case 6:
                    monedaInicial = " euros ";
                    conversor = new ConversorDivisas(1,"extranjero-colon");
                    valorConvertido = conversor.Convertir(valorInicial);
                    break;
                case 7:
                    monedaInicial = " libras ";
                    conversor = new ConversorDivisas(2,"extranjero-colon");
                    valorConvertido = conversor.Convertir(valorInicial);
                    break;
                case 8:
                    monedaInicial = " yenes ";
                    conversor = new ConversorDivisas(3,"extranjero-colon");
                    valorConvertido = conversor.Convertir(valorInicial);
                    break;
                case 9:
                    monedaInicial = " wones ";
                    conversor = new ConversorDivisas(4,"extranjero-colon");
                    valorConvertido = conversor.Convertir(valorInicial);
                    break;
                }
        }
        return "Su cantidad de "+valorInicial+monedaInicial+"equivale a "+valorConvertido+monedaConvertida;
    } 
}
