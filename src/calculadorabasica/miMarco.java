/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorabasica;

import javax.swing.JFrame;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 26/05/2021
 *
 */
public class miMarco extends JFrame {

    public miMarco() {
        setVisible(true);
        setTitle("Calculadora");
        setSize(500,500);
        setLocation(200,300);
        Lamina lamina=new Lamina();
        add(lamina);
    }

}
