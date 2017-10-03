/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiloscronometro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class InterfazCronometro extends JFrame implements ActionListener {

    //Atributos
    JLabel labelCrono;
    JButton btnIniciar;
    JButton btnParar;

    static boolean iniciarCronometro = false;

    //Constructor
    public InterfazCronometro(String nombre) {
        super(nombre);
        setSize(300, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        crearContenido();
    }

    public void crearContenido() {
        JPanel panelCronometro = new JPanel();
        labelCrono = new JLabel("00:00:00");
        labelCrono.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        panelCronometro.add(labelCrono);
        panelCronometro.setLayout(new FlowLayout());

        JPanel panelBtn = new JPanel();
        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(this);
        btnParar = new JButton("Parar");
        btnParar.addActionListener(this);
        panelBtn.setLayout(new FlowLayout());

        panelBtn.add(btnIniciar);
        panelBtn.add(btnParar);

        getContentPane().add(panelCronometro, BorderLayout.CENTER);
        add(panelBtn, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIniciar) {
            if (iniciarCronometro == false) {
                iniciarCronometro = true;
                iniciarHilo();
            }
        }
        if (e.getSource() == btnParar) {

            if (iniciarCronometro == true) {
                iniciarCronometro = false;
            }
        }
    }
    
    public void iniciarHilo(){
        Cronometro hilo = new Cronometro(labelCrono);
        hilo.start();
    }
}
