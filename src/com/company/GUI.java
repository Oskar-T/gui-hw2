package com.company;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ------------------------------------------------------------------
// this class implements window focus listening
// ------------------------------------------------------------------
public class GUI extends JFrame {
    public GUI(Application application) {
        super("Complex event demo");
        this.application = application;
        setSize(400, 300);

        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener((ActionEvent e) ->
        {
            int result = JOptionPane.showConfirmDialog(this,
                    "Are you sure?",
                    null, JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        fileMenu.add(quitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        //label
        label = new JLabel();
        add(label);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();


        setVisible(true);
    }

    protected void updateTime() {
        label.setText(String.valueOf(application.state++));
    }


    private Application application;
    private JMenuBar menuBar;
    private JLabel label;


}