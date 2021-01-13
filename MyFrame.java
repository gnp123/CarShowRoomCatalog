package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.CheckedOutputStream;

public class MyFrame extends JFrame {
    JPanel upPanel=new JPanel();
    JPanel midPanel=new JPanel();
    JPanel downPanel=new JPanel();

    JButton addElCar=new JButton("Add Electric Car");
    JButton addGasCar=new JButton("Add Gas Car");
    JButton addHybCar=new JButton("Add Hybrid car");
    JButton saveBtn=new JButton("Save");
    JButton showCat=new JButton("Show catalog");
    JButton exit=new JButton("EXIT");




    ArrayList<Object> arr = new ArrayList<>();


    public MyFrame(){
        this.setTitle("Mobility4You Catalog");
        this.setSize(400,550);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,1));
        this.add(upPanel);
        this.add(midPanel);
        this.add(downPanel);

        upPanel.setLayout(new GridLayout(1,1));
        upPanel.add(addElCar);
        addElCar.addActionListener(new AddAction());
        upPanel.add(addGasCar);
        addGasCar.addActionListener(new AddActionGC());
        upPanel.add(addHybCar);
        addHybCar.addActionListener(new AddActionHC());

        midPanel.setLayout(new GridLayout(2,1));
        midPanel.add(showCat);
        showCat.addActionListener(new DisplayAction());
        midPanel.add(saveBtn);
        saveBtn.addActionListener(new SaveAction());

        downPanel.setLayout(new GridLayout(1,1));
        downPanel.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.setVisible(true);

    }

    public  void fileReader(){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Georgi\\Desktop\\CarsList.txt")))
        {

            Object sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);

            }

        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public void writeFile(){
        FileWriter writer = null;
        try {
            writer = new FileWriter("C:\\Users\\Georgi\\Desktop\\CarsList.txt");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        for(Object str: arr) {

                try {
                    writer.write(str + System.lineSeparator());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        try {
            writer.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }






    public class AddAction extends JFrame implements ActionListener  {

        JPanel upPanel=new JPanel();
        JPanel downPanel=new JPanel();

        JLabel marka=new JLabel("Марка");
        JLabel model=new JLabel("Модел");
        JLabel power=new JLabel("Мощност");
        JLabel battery=new JLabel("Капацитет батерия");
        JLabel price=new JLabel("Цена");

        JTextField markaTF=new JTextField(20);
        JTextField modelTF=new JTextField(20);
        JTextField powerTF=new JTextField(20);
        JTextField batteryTF=new JTextField(20);
        JTextField priceTF=new JTextField(20);

        JButton save=new JButton("Add");

        public String toString(){
            return "ELECTRIC_CAR"+" "+brand+" "+modelName+" "+powerr+" "+batteryCap+" "+pricee;
        }

        String brand;
        String modelName;
        double powerr;
        int batteryCap;
        int pricee;

        @Override
        public void actionPerformed(ActionEvent e) {
           JFrame frame=new JFrame("ADD ELECTRIC CAR");
            frame.setSize(400,550);
            frame.setLayout(new GridLayout(2,1));
            frame.add(upPanel);
            frame.add(downPanel);

            upPanel.setLayout(new GridLayout(5,2));
            upPanel.add(marka);
            upPanel.add(markaTF);
            upPanel.add(model);
            upPanel.add(modelTF);
            upPanel.add(power);
            upPanel.add(powerTF);
            upPanel.add(battery);
            upPanel.add(batteryTF);
            upPanel.add(price);
            upPanel.add(priceTF);
            downPanel.add(save);
            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddAction user=new AddAction();
                    user.brand=markaTF.getText();
                    user.modelName=modelTF.getText();
                    user.powerr=Double.parseDouble(powerTF.getText());
                    user.batteryCap=Integer.parseInt(batteryTF.getText());
                    user.pricee=Integer.parseInt(priceTF.getText());

                    arr.add(user.toString());


                }
            });

            frame.setVisible(true);


        }
    }

    public class AddActionGC extends JFrame implements ActionListener {

        JPanel upPanel=new JPanel();
        JPanel downPanel=new JPanel();

        JLabel marka=new JLabel("Марка");
        JLabel model=new JLabel("Модел");
        JLabel engine=new JLabel("Кубатъра");
        JLabel power=new JLabel("Мощност");
        JLabel price=new JLabel("Цена");

        JTextField markaTF=new JTextField(20);
        JTextField modelTF=new JTextField(20);
        JTextField engineTF=new JTextField(20);
        JTextField powerTF=new JTextField(20);
        JTextField priceTF=new JTextField(20);

        JButton save=new JButton("Add");

        public String toString(){
            return "GAS_CAR"+" "+brand+" "+modelName+" "+engineDis+" "+powerr+" "+pricee;
        }

        String brand;
        String modelName;
        double engineDis;
        int powerr;
        int pricee;

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame=new JFrame("ADD GAS CAR");
            frame.setSize(400,550);
            frame.setLayout(new GridLayout(2,1));
            frame.add(upPanel);
            frame.add(downPanel);

            upPanel.setLayout(new GridLayout(5,2));
            upPanel.add(marka);
            upPanel.add(markaTF);
            upPanel.add(model);
            upPanel.add(modelTF);
            upPanel.add(engine);
            upPanel.add(engineTF);
            upPanel.add(power);
            upPanel.add(powerTF);
            upPanel.add(price);
            upPanel.add(priceTF);

            downPanel.add(save);
            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddActionGC user=new AddActionGC();
                    user.brand=markaTF.getText();
                    user.modelName=modelTF.getText();
                    user.engineDis=Double.parseDouble(engineTF.getText());
                    user.powerr=Integer.parseInt(powerTF.getText());
                    user.pricee=Integer.parseInt(priceTF.getText());

                    arr.add(user.toString());



                }
            });

            frame.setVisible(true);
        }
    }

    public class AddActionHC extends JFrame implements ActionListener {

        JPanel upPanel=new JPanel();
        JPanel downPanel=new JPanel();

        JLabel marka=new JLabel("Марка");
        JLabel model=new JLabel("Модел");
        JLabel power=new JLabel("Мощност");
        JLabel battery=new JLabel("Капацитет батерия");
        JLabel price=new JLabel("Цена");

        JTextField markaTF=new JTextField(20);
        JTextField modelTF=new JTextField(20);
        JTextField powerTF=new JTextField(20);
        JTextField batteryTF=new JTextField(20);
        JTextField priceTF=new JTextField(20);

        JButton save=new JButton("Add");

        String modell;
        String markaa;
        double powerr;
        int batery;
        int pricee;

        public String toString(){
            return "HYBRID_CAR"+" "+modell+" "+markaa+" "+powerr+" "+batery+" "+pricee;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame=new JFrame("ADD HYBRID CAR");
            frame.setSize(400,550);
            frame.setLayout(new GridLayout(2,1));
            frame.add(upPanel);
            frame.add(downPanel);

            upPanel.setLayout(new GridLayout(5,2));
            upPanel.add(marka);
            upPanel.add(markaTF);
            upPanel.add(model);
            upPanel.add(modelTF);
            upPanel.add(power);
            upPanel.add(powerTF);
            upPanel.add(battery);
            upPanel.add(batteryTF);
            upPanel.add(price);
            upPanel.add(priceTF);

            downPanel.add(save);
            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddActionHC user=new AddActionHC();
                    user.modell=modelTF.getText();
                    user.markaa=markaTF.getText();
                    user.powerr=Double.parseDouble(powerTF.getText());
                    user.batery=Integer.parseInt(batteryTF.getText());
                    user.pricee=Integer.parseInt(priceTF.getText());
                    arr.add(user.toString());


                    /*try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Georgi\\Desktop\\CarsList.txt")))
                    {

                        Object sCurrentLine;

                        while ((sCurrentLine = br.readLine()) != null) {
                            arr.add(sCurrentLine);
                        }

                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }*/
                    //filereader();
                    //writeFile();
                    /*FileWriter writer = null;
                    try {
                        writer = new FileWriter("C:\\Users\\Georgi\\Desktop\\CarsList.txt");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    for(Object str: arr) {
                        try {
                            writer.write(str + System.lineSeparator());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    try {
                        writer.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }*/

                }
            });

            frame.setVisible(true);
        }
    }

    public class SaveAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            fileReader();
            writeFile();
        }
    }

    public class DisplayAction implements ActionListener {

        JPanel read=new JPanel();
        JPanel down=new JPanel();

        JTextArea disp=new JTextArea();
        JButton sortCT=new JButton("Sort by Car Type");
        JButton sortB=new JButton("Sort by Brand");

        public void sortByType(){
            disp.selectAll();
            disp.replaceSelection("");
            var sorted=arr.stream().map(Object::toString).sorted().collect(Collectors.joining("\n"));
            disp.append(sorted);
            disp.setVisible(true);


        }


        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame diss=new JFrame("CAR CATALOG");
            diss.setSize(400,500);
            diss.setLayout(new GridLayout(2,1));
            diss.add(read);
            diss.add(down);
            read.add(disp);
            disp.setSize(450,550);
            down.add(sortCT);
            sortCT.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    disp.selectAll();
                    disp.replaceSelection("");
                    fileReader();
                    sortByType();


                }
            });
            down.add(sortB);
            sortB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                
                }
            });

            disp.selectAll();
            disp.replaceSelection("");

            try (BufferedReader myReader = new BufferedReader(new FileReader("C:\\Users\\Georgi\\Desktop\\CarsList.txt"))) {
                String text = null;
                while ((text = myReader.readLine()) != null) {
                    disp.append(text +"\n");
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }

            disp.setVisible(true);
            diss.setVisible(true);

        }
    }
}
