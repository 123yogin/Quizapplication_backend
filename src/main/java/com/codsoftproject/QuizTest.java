package com.codsoftproject;

import java.awt.event.*;
import javax.swing.*;

public class QuizTest  extends JFrame implements ActionListener{

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;

    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int [5];

    QuizTest(String s){
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for(int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton() ;
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30,40,450,20);
        radioButton[0].setBounds(50,80,450,20);
        radioButton[1].setBounds(50,110,200,20);
        radioButton[2].setBounds(50,140,200,20);
        radioButton[3].setBounds(50,170,200,20);
        
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);

    }

    void setData(){
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("Question 1 : what is your name?");
            radioButton[0].setText("Amit");
            radioButton[1].setText("Rahul");
            radioButton[2].setText("Raj");
            radioButton[3].setText("Rahul");
        }
        if (current == 1) {
            label.setText("Question 2 : what is your age?");
            radioButton[0].setText("13");
            radioButton[1].setText("45");
            radioButton[2].setText("58");
            radioButton[3].setText("24");
        }
        if (current == 2) {
            label.setText("Question 3 : what is your college?");
            radioButton[0].setText("LD");
            radioButton[1].setText("PDPU");
            radioButton[2].setText("LDRP");
            radioButton[3].setText("GEC");
        }
        if (current == 3) {
            label.setText("Question 4 : what is your branch?");
            radioButton[0].setText("Computer");
            radioButton[1].setText("Civil");
            radioButton[2].setText("MECH.");
            radioButton[3].setText("IT");
        }
        if (current == 4) {
            label.setText("Question 5 : what is your job?");
            radioButton[0].setText("java");
            radioButton[1].setText("python");
            radioButton[2].setText("cotlin");
            radioButton[3].setText("PHP");
        }
        label.setBounds(30,40,450,20);
        for(int i = 0, j = 0;i<=40;i+=10){
            radioButton[j].setBounds(50,50+i,350,15);
        }
    }

    boolean checkAns(){
        if (current==0) {
            return(radioButton[1].isSelected());
        }
        if (current==1) {
            return(radioButton[2].isSelected());
        }
        if (current==2) {
            return(radioButton[3].isSelected());
        }
        if (current==3) {
            return(radioButton[0].isSelected());
        }
        if (current==4) {
            return(radioButton[0].isSelected());
        }
        return false;
        
    }
    public static void main(String[] args) {
       new QuizTest("Quiz App");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (checkAns()) {
                count = count +1;
                current++;
                setData();
                if (current==4) {
                    btnNext.setEnabled(false);
                    btnResult.setVisible(true);
                    btnResult.setText("Result");
                }
            }
           if (e.getActionCommand().equals("Result")) {
            if (checkAns()) {
                count = count +1;
                current++;
                JOptionPane.showMessageDialog(this, "Correct answer are"+ count);
                System.exit(0);
            }
           } 
        }
    }



}
