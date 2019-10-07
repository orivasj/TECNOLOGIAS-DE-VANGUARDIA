public class TestServer {
    public static void main(String[] args) {
        Servidor servidor = new Servidor(9001);
        String msj = servidor.mensajeEntrante();
        System.out.println(msj);

    }
}
