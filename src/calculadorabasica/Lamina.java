/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorabasica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 26/05/2021
 *
 */
public class Lamina extends JPanel {

    private String ultimaOp;
    private double resultado;
    private boolean principio;
    private JPanel miLamina;
    private JButton pantalla;

    public Lamina() {
        principio = true;
        setLayout(new BorderLayout());
        pantalla = new JButton("0"); //Este boton nos servira como pantalla dentro de nuestra calculadora
        miLamina = new JPanel(); //Agregamos una lamina nueva, esa lamina le pondremos un Layout Grid para dividir las secciones de cada boton
        
        add(pantalla, BorderLayout.NORTH); //En esta linea de codigo indicamos que queremos que la pantalla se agrege en la parte norte de nuestro panel
        pantalla.setEnabled(false);
        ActionListener insertar = new insertarNumero();
        ActionListener op = new AccionOrden();
        ponerBoton("7", insertar);
        ponerBoton("8", insertar);
        ponerBoton("9", insertar);
        ponerBoton("/", op);
        ponerBoton("4", insertar);
        ponerBoton("5", insertar);
        ponerBoton("6", insertar);
        ponerBoton("*", op);
        ponerBoton("1", insertar);
        ponerBoton("2", insertar);
        ponerBoton("3", insertar);
        ponerBoton("-", op);
        ponerBoton("0", insertar);
        ponerBoton(".", op);
        ponerBoton("=", op);
        ponerBoton("+", op);
        miLamina.setLayout(new GridLayout(4, 4)); //Con esto indicamos que va a tener 4 filas y 4 columnas
        add(miLamina, BorderLayout.CENTER);
        ultimaOp = "=";
    }

    //Creamos un metodo para que agrege los botones
    public void ponerBoton(String valor, ActionListener oyente) {
        JButton boton = new JButton(valor);
        boton.addActionListener(oyente);
        boton.setBackground(new Color(23,54,80));
       boton.setForeground(Color.WHITE);
        miLamina.add(boton);

    }

    //Vamos a crear una clase que gestionara los eventos de cada boton
    private class insertarNumero implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String entrada = e.getActionCommand();
            if (principio) {
                pantalla.setText("");
                principio = false;
            }
            pantalla.setText(pantalla.getText() + entrada);
        }

    }

    //Vamos a crear una clase que realizara las accione segun la operacion que deseamos
    private class AccionOrden implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String operacion = e.getActionCommand();
            calcular(Double.parseDouble(pantalla.getText())); //Con este metodo rescatamos lo que tenemos en pantalla
            ultimaOp = operacion;
            principio = true;

        }

        public void calcular(double n) {
            if (ultimaOp.equals("+")) {
                resultado += n;
                // System.out.println(resultado);
            } else if (ultimaOp.equals("-")) {
                resultado -= n;
            } else if (ultimaOp.equals("*")) {
                resultado *= n;
            } else if (ultimaOp.equals("/")) {
                resultado /= n;
            } else if (ultimaOp.equals("=")) {
                resultado = n;

            }
            pantalla.setText("" + resultado); //Con esto convertimos nuestro valor Double a String

        }

    }

}
