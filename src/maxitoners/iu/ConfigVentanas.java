/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maxitoners.iu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author luism
 */
public class ConfigVentanas {
    // Método estático para configurar una ventana
    public static void configurarVentana(JFrame ventana, String titulo) {
        // Establecer el título de la ventana
        ventana.setTitle(titulo);

        // Cargar el logo desde los recursos
        try {
            Image icono = ImageIO.read(ConfigVentanas.class.getResourceAsStream("/maxitoners/imgs/Maxitoners Logo.jpg"));
            ventana.setIconImage(icono);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
