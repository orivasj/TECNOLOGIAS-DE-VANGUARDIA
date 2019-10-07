import java.io.ObjectOutputStream;
import java.net.Socket;

//Declaracion de la clase Cleinte
public class Cliente {
    //Declaracion de una variable de tipo socket

    private Socket cliente;
    //Declaracion de una variable de tipo ObjectOutputStream que permite crear un flujo de salida a traves del socket
    private ObjectOutputStream flujo_de_salida;

    //Creacion del metodo mensaje saliente
    //Metodo que sirve para recibir un mensaje y enviarlo al socket
    public void mensaje_Saliente(String ip, String mensaje, int puerto) {
        //Todo lo que se encuentra entre las sensencias try y catch pueden lanzar una excepcion
        try {
            //Levanta un objeto de tipo Socket, y lo construye a traves de los parametros ip de conecxion
            //y el puerto que abre por el cual viajaran los datos
            cliente = new Socket(ip, puerto);
            //Se crea el objeto que permite escribir en un flujo lleva como parametro
            //el flujo que le pertenece al socket --> cliente
            flujo_de_salida = new ObjectOutputStream(cliente.getOutputStream());
            //Escribo sobre el flujo de salida la palabra Pc y le concateno la direccion ip del cleinte, concateno la direccion
            //del cliente  y el mensaje, para ser enviados a traves del flujo, por medio del socket abierto anteriormente.
            flujo_de_salida.writeObject(mensaje);
            //Cierro el socket
            cliente.close();

        }//Cacha las excepciones
        catch (Exception ex) {
            //Imprime la secuencia del lanzamiento de la exception
            ex.printStackTrace();
        }

    }
}




