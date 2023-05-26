package com.cursoandroidudemy.telalogin;

import java.io.Serializable;

public class Usuario implements Serializable {





    private Integer id;
    private String senha;


    private String email;

    private String apelido;

    public Usuario() {
    }


    public void setId(Integer id) { this.id = id; }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setApelido(String apelido){this.apelido = apelido; }

    public Usuario(String senha, String email, String apelido) {


        this.senha = senha;
        this.email = email;
        this.apelido = apelido;
    }


    public Integer getId() {return id;}
    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getApelido() { return apelido; }

    @Override
    public String toString() {
        return apelido;
    }
}
