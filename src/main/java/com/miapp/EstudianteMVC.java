/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.miapp;

import com.miapp.vista.EstudianteView;
import com.miapp.controlador.EstudianteController;

/**
 *
 * @author taidy
 */
public class EstudianteMVC {
    public static void main(String[] args) {
        // Lanza la interfaz gráfica en el hilo de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            EstudianteView vista = new EstudianteView();
            new EstudianteController(vista);  // conecta Vista y Modelo
            vista.setVisible(true);
        });
    }
}