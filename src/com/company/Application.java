package com.company;


public class Application {
    public Application() {
        gui = new GUI(this);
        state = 0;

    }

    public int state;

    private GUI gui;
}
