/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paletteTransparan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author MurabbiProgrammer
 */
public class Panel extends JPanel {

    private Color warna;

    public Panel() {
        //membuat sebuah warna yang diambil dari warna background RGB
        //dengan tingkat ke"transparanan" = 125
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 125);

    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        //membuat sebuah warna yang diambil dari warna background RGB
        //dengan tingkat ke"transparanan" = 125
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 125);
        //mengecat
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd = (Graphics2D) g.create();
        //mengatur warna gd dengan warna
        gd.setColor(warna);
        //mengecat kotak dengan warna gd
        gd.fillRect(0, 0, getWidth(), getHeight());

        gd.dispose();
    }
}
