package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {

    Ambulance(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(90,156,163));
        panel.setBounds(5,5,890,590);
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setFont(new Font("tahoma",Font.BOLD,12));
        table.setBackground(new Color(90,156,163));
        table.setBounds(20,40,900,450);
        panel.add(table);
        try {

            conn c =new conn();
            String q  = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label1 =new JLabel("Name");
        label1.setBounds(20,10,100,14);
        label1.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 =new JLabel("Gender");
        label2.setBounds(200,10,100,14);
        label2.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 =new JLabel("Car Name");
        label3.setBounds(366,10,100,14);
        label3.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 =new JLabel("Availability");
        label4.setBounds(560,10,100,14);
        label4.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 =new JLabel("Location");
        label5.setBounds(740,10,100,14);
        label5.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label5);



        JButton b1 = new JButton("BACK");
        b1.setBounds(450,510,120,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Ambulance();
    }
}
