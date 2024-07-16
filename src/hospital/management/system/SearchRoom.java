package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {


    Choice choice;

    JTable table;
    SearchRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

         JLabel For = new JLabel("Search For Room ");
         For.setBounds(250,11,186,31);
         For.setForeground(Color.white);
         For.setFont(new Font("tahoma",Font.BOLD,20));
         panel.add(For);

        JLabel Status = new JLabel("Status :");
        Status.setBounds(70,70,80,20);
        Status.setForeground(Color.white);
        Status.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(Status);

         choice = new Choice();
         choice.setBounds(170,70,120,20);
         choice.add("Available");
         choice.add("Occupied");
         panel.add(choice);

         table = new JTable();
         table.setBounds(0,187,700,210);
         table.setBackground(new Color(90,156,163));
         table.setForeground(Color.white);
         panel.add(table);

         try {

             conn c = new conn();
             String q = "select * from Room";
             ResultSet resultSet = c.statement.executeQuery(q);
             table.setModel(DbUtils.resultSetToTableModel(resultSet));


         }
         catch (Exception e){
             e.printStackTrace();
         }

        JLabel label1 = new JLabel("Room Number");
        label1.setBounds(12,162,150,20);
        label1.setForeground(Color.white);
        label1.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(170,162,150,20);
        label2.setForeground(Color.white);
        label2.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(350,162,150,20);
        label3.setForeground(Color.white);
        label3.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(550,162,150,20);
        label4.setForeground(Color.white);
        label4.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(label4);

        JButton search = new JButton("SEARCH");
        search.setBounds(200,420,120,25);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q ="select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try {

                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(380,420,120,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(700,500);
        setLocation(450,250);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
