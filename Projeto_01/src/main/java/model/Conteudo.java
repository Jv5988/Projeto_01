package model;

import java.util.List;

public class Conteudo {
    private int id;
    private int usuarioId;
    private List<String> conteudos;

    public Conteudo() {
    }

    public Conteudo(int usuarioId, List<String> conteudos) {
        this.usuarioId = usuarioId;
        this.conteudos = conteudos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<String> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<String> conteudos) {
        this.conteudos = conteudos;
    }
}
