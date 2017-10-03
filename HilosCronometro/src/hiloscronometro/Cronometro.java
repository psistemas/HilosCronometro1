/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiloscronometro;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author pc
 */
public class Cronometro extends Thread {

    JLabel label;

   static int seg = 0, min = 0, hora = 0;

    //Constructor
    public Cronometro(JLabel labelCrono) {
        label = labelCrono;
    }

    @Override
    public void run() {
        while (InterfazCronometro.iniciarCronometro == true) {
            try {
                
                Thread.sleep(1000);
                mostrarCronometro();
            } catch (InterruptedException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }
    
    public void mostrarCronometro(){
        seg++;
        if(seg > 59){
            seg = 0;
            min++;
        }
        if(min>59){
            min =0;
            hora++;
        }
         
        
        
        String relog =String.format("%02d:%02d:%02d",hora,min,seg)   ;
        label.setText(relog);
        
        
    }

}
