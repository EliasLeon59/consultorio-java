package service;

import model.Administrador;

public class LoginService {

    private Administrador admin;

    public LoginService() {

        admin = new Administrador(
                "admin",
                "admin123"
        );

    }

    public boolean autenticar(
            String usuario,
            String password) {

        return admin.getUsuario().equals(usuario)
                && admin.getPassword().equals(password);

    }
}