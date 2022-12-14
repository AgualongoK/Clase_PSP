import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
    public static void main(String[] args) throws Exception {
        byte[] bufer = new byte[1024]; // bufer para recibir el datagrama
        // ASOCIO EL SOCKET AL PUERTO 12345
        DatagramSocket socket = new DatagramSocket(12345);
        // ESPERANDO DATAGRAMA
        System.out.println("Esperando Datagrama .......... ");
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibo);// recibo datagrama
        int bytesRec = recibo.getLength(); // obtengo n�mero de bytes
        String paquete = new String(recibo.getData()); // obtengo String
        // VISUALIZO INFORMACI�N
        System.out.println("N�mero de Bytes  recibidos:  " + bytesRec);
        System.out.println("Contenido del Paquete  " + paquete);
        System.out.println("Puert o origen del mensaje:  " + recibo.getPort());
        System.out.println("IP de  origen  " + recibo.getAddress().getHostAddress());
        System.out.println("Puerto destino del mensaje:" + socket.getLocalPort());
        socket.close(); // cierro el socket
    }
}