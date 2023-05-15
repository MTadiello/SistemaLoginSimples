package com.cursoandroidudemy.telalogin;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String senha;
    private String usuario;

    public Usuario() {
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuario(String senha, String usuario) {
        this.senha = senha;
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return usuario;
    }
}
