package Server;

import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
//Start ,Error ,ClientJoin ,ClientSendCommand
public class ClientHandler {
    //к каждому клиенту сокета создается свой поток ввывода и ввода данных ин и оут
    private Server server;
    private Socket socket;
    private static final Logger log = Logger.getLogger(ClientHandler.class);
    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;

            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream()); //формируется входящий и исходящий поток данных
            //для ввода DataOutput это способ чтоб работала кодировка более правильный чем в эхосервере
            new Thread(() -> {
                boolean flagAuto=false;
                try {
                    String lNikName="_";
                    while (true) {

                            String str = in.readUTF();
                        if(flagAuto==true) {
                           String[] newNikname=str.split(" ");
                            System.out.println("Сообщение от клиента_" + lNikName + ": " + str);
                            if (str.equals("/end")) {
                                log.info("ClientSendCommand");
                                break;
                            }
                            if ( newNikname[0].equals("/newNik")){
                                log.info("ClientSendCommand");
                                DataBass.findAndCheang(lNikName,newNikname[1]);
                                lNikName=newNikname[1];
                            }
                            // String idS=String.valueOf(id);
                            //  str=idS+str;
                            server.broadcastMsg(str, lNikName); //рассылка сообщений и для этого в констрктор мы передаем обьект сервера
                        }else{


                            String[] autors=str.split(" ");
                            boolean exFlag=true;
                             lNikName=DataBass.Search(autors[0], autors[1]);
                            if(lNikName.equals("error")!=true) {
                                flagAuto = true;

                            }

                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {  //чистим данные и закрываем за собой все потоки
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                }
            }).start();
        } catch (IOException e) {
            log.error("ClientSendCommand");
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg,String Nikname) {
        try {
            out.writeUTF("Nik_"+Nikname+" ECHO: " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}