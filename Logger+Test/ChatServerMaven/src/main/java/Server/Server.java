package Server;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clients;//используем вектор потому что он потоко безопасный в отличии от других
    //private String Nikname="_";
    private static final Logger log = Logger.getLogger(Server.class);
    public Server() {
        try {        //пишется в эксепшене изза того что могут возникнуть проблеммы с водом и выводом
            ServerSocket serverSocket = new ServerSocket(8189);      //создаем порт куда подрубаются все
            clients = new Vector<>(); //инициализируем наших клиентов
            while (true) {   //бесконечно ожидаем подключение нового клиента
                System.out.println("Ждем подключения клиента");
                Socket socket = serverSocket.accept();//это то как клиенты будут подключаться (блокирующая часть,пока клиент чтото не сделает то будем тут стоять)
                //сокет установленное соединение между сервером и клиентом
                ClientHandler c = new ClientHandler(this, socket);//сложная хрень тип через this он передает ссылку на себя крч погуглить


                subscribe(c);  //подписываем клиента

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler client) {

        clients.add(client);
        log.info("ClientJoin");
    } //добавляем клиента в список рассылок (подписался)

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public void broadcastMsg(String msg, String Nikname) {  //рассылаем всем клиентам
        for (ClientHandler c : clients) {  //бегаем по всей коллекции и каждому отсылаем сообщение
            c.sendMsg(msg, Nikname);
        }
    }
}