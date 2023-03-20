package com.joel.alura;

import javax.swing.*;

/**
 * 18-3-23
 * @author Joel Ortiz Rivera
 */
public class Main extends javax.swing.JFrame {

    public static void main(String[] args) {
        Menus menu = new Menus();
        while(true){
            //Menu principal
            int opcionMP = JOptionPane.showOptionDialog(null, menu.MenuPrincipal, "Menu Principal", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null,null,null);
            if(opcionMP != JOptionPane.OK_OPTION){
                break;
            }
            //Menu seleccionar valor
            String valor = JOptionPane.showInputDialog("Ingrese un valor: ");
            if(valor == null){
                break;
            }
            valor = valor.trim();
            if(valor.isEmpty() || !valor.matches("[0-9]+")){
                JOptionPane.showMessageDialog(null, "Valor invalido");
                break;
            } else{              
                menu.setValorInicial( Double.parseDouble(valor));
            }
            //Menu seleccionar tipo de cambio
            int opcionTC = JOptionPane.showOptionDialog(null, menu.MenuTipoDeCambio, "Tipo de Cambio", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null,null,null);
            if(opcionTC != JOptionPane.OK_OPTION){
                break;
            }
            //Mensaje muestra resultado
            JOptionPane.showMessageDialog(null, menu.resultadoConversion());

            //Desea continuar?
            int continuar = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmación", JOptionPane.OK_CANCEL_OPTION);
            if (continuar != JOptionPane.OK_OPTION) {
                break;
            }
        }
        System.out.println("Progama finalizado");
    }
    
}
