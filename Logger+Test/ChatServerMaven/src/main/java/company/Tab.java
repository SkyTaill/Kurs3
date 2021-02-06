package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Tab extends JFrame {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;


    JPanel panel = new JPanel();
    JLabel label = new JLabel("Введите текст");
    JTextField tf = new JTextField(10);
    JButton send = new JButton("Отправить");
    JTextArea ta = new JTextArea();
   // private Handler handler;
    JPanel panelPass = new JPanel();
    JTextField password1 = new JTextField(5);
    JTextField password2 = new JTextField(5);
    JButton passbutton = new JButton("Авторизироваться");
    public Tab(){
      //  this.handler=new Handler(this);
        Check();
        JFrame frame = new JFrame("Чат");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        panel.add(label);
        panel.add(tf);
        panel.add(send);


        panelPass.add(password1);
        panelPass.add(password2);
        panelPass.add(passbutton);



        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = String.valueOf(tf.getText());

                //ta.append(a+"\n");
                sendMsg(a);
                tf.setText("");

                }
            }
    );
        passbutton.addActionListener(new ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                       String a = String.valueOf(password1.getText());
                                       a+=" ";
                                       a+= String.valueOf(password2.getText());
                                       //ta.append(a+"\n");

                                       sendMsg(a);
                                       ta.setText(HistoryOfChat.takeOfTheFile());
                                       panelPass.setVisible(false);

                                   }
                               }
        );


        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, panelPass);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }
    public void Check(){
        try {
            socket = new Socket("localhost", 8189); //пишем с кем будем устанавливать соединение
            in = new DataInputStream(socket.getInputStream());   //для ввода датаинпут это способ чтоб работала кодировка более правильный чем в эхосервере
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                while (true) {
                    try {
                        String str = in.readUTF();  //ожидает сообщение от сервера в отдельном потоке
                        HistoryOfChat.putInText(str);
                          ta.append(str + System.lineSeparator()); //если сообщение попало в стр то мы его добавляем в окно сообщений чтоб увидеть
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMsg(String str) {
        try {

            out.writeUTF(str);  //отправляем на сервер

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
