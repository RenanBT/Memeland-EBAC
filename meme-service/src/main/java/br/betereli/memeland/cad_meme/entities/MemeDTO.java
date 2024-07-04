package br.betereli.memeland.cad_meme.entities;

import java.util.Date;

public class MemeDTO {
    private Long id;
    private String nome;
    private String url;
    private Date dataCadastro;
    private CategoriaMeme categoria;
    private Usuario usuario;

    //public MemeDTO() {}

    public MemeDTO(Meme meme, CategoriaMeme categoriaMeme, Usuario usuario) {
        setId(meme.getId());
        setNome(meme.getNome());
        setUrl(meme.getUrl());
        setDataCadastro(meme.getDataCadastro());
        setCategoria(categoriaMeme);
        setUsuario(usuario);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public CategoriaMeme getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaMeme categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
