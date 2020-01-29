import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class App {

    private static Simulation simulation;
    private static MapVisualisation mapVisualisation;
    private static JFrame jFrame;
    private static int sleepTime;

    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
                jFrame = new JFrame("SnakeEleven");
                Map map = new Map(100, 100);
                simulation = new Simulation(map);
                mapVisualisation = new MapVisualisation(map);
                jFrame.add(mapVisualisation);
                jFrame.addKeyListener(simulation);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.pack();
                jFrame.setVisible(true);
//            }
//        });
        loop();
    }

    private static void loop() {
        while (!simulation.isDead) {
            simulation.day();
            mapVisualisation.update();




            jFrame.invalidate();
            jFrame.validate();
            jFrame.repaint();
            sleepTime = (int) ((((double)1/(double)simulation.speed))*100000);
            try {
                sleep(sleepTime);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(jFrame,"Punkty: "+simulation.points);
    }


}
