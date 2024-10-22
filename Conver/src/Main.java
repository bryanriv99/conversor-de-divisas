import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);


        String direccion = "https://v6.exchangerate-api.com/v6/9aa2c69733a6b9e443a333d8/latest/MXN";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Gson gson = new GsonBuilder().create();

        Datos datos = gson.fromJson(json,Datos.class);
        Moneda operacion = new Moneda(datos);







        int moneda;
        do {
            System.out.println("******************************");
            System.out.println("Bienvenido");
            System.out.println("Ecoge el tipo de cambio que quieres");
            System.out.println("1.- Peso mexicano a Dolar\n2.- Dolar a Peso mexicano\n" +
                    "3.- Peso mexicano a Peso Argentino\n" +
                    "4.- Peso Argentino a Peso mexicano\n" +
                    "5.- Yen a Peso mexicano\n6.- Peso mexicano a Yen\n" +
                    "7.- Peso mexicano a sol\n8.- Sol a peso mexicano\n" +
                    "9.- Salir");

            Scanner conversion = new Scanner(System.in);
            double conv;
            double a;
            moneda = lectura.nextInt();

            switch(moneda){
                case 1:
                    System.out.println("Cantidar a convertir: ");
                    conv = conversion.nextDouble();
                    a = operacion.pesoADolar(conv);
                    System.out.println(conv + "pesos a Dolar es: " + a);
                    break;
                case 2:
                    System.out.println("Cantidar a convertir: ");
                    conv = conversion.nextDouble();
                    a = operacion.DolarAPeso(conv);
                    System.out.println(conv + "Dolares a Peso es: " + a);
                    break;
                case 3:
                    System.out.println("Cantidar a convertir: ");
                    conv = conversion.nextDouble();
                    a = operacion.PesoAPesoArg(conv);
                    System.out.println(conv + "Pesos a Pesos argentinos: " + a);
                    break;
                case 4:
                    System.out.println("Cantidar a convertir: ");
                    conv = conversion.nextDouble();
                    a = operacion.PesoArgAPeso(conv);
                    System.out.println(conv + "Pesos argentinos a peso: " + a);
                    break;
                case 5:
                    System.out.println("Cantidar a convertir: ");
                    conv = conversion.nextDouble();
                    a = operacion.yenAPeso(conv);
                    System.out.println(conv + "Yenes a pesos: " + a);
                    break;
                case 6:
                    System.out.println("Cantidar a convertir: ");
                    conv = conversion.nextDouble();
                    a = operacion.peroAYen(conv);
                    System.out.println(conv + "Pesos a yenes es: " + a);
                    break;
                case 7:
                    System.out.println("Cantidar a convertir: ");
                    conv = conversion.nextDouble();
                    a = operacion.pesoASol(conv);
                    System.out.println(conv + "Pesos a Sol es: " + a);
                    break;
                case 8:
                    System.out.println("Cantidar a convertir: ");
                    conv = conversion.nextDouble();
                    a = operacion.solAPeso(conv);
                    System.out.println(conv + "Sol a peso es: " + a);
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
            }

        }while(moneda != 9);
    }
}