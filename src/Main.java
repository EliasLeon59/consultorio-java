import service.LoginService;
import ui.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();

        System.out.println("===== INICIO DE SESIÓN =====");

        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        if (loginService.autenticar(usuario, password)) {

            System.out.println("Acceso concedido.");

            Menu menu = new Menu();
            menu.mostrarMenu();

        } else {

            System.out.println("Usuario o contraseña incorrectos.");

        }

    }

}