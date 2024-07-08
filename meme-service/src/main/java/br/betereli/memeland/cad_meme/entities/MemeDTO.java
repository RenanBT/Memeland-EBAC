package br.betereli.memeland.cad_meme.entities;

import java.util.Date;

public class MemeDTO {
    private Long id;
    private String name;
    private String url;
    private Date registryDate;
    private memeCategory category;
    private User user;

    //public MemeDTO() {}

    public MemeDTO(Meme meme, memeCategory memeCategory, User user) {
        setId(meme.getId());
        setName(meme.getName());
        setUrl(meme.getUrl());
        setRegistryDate(meme.getRegistryDate());
        setCategory(memeCategory);
        setUsuario(user);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDataCadastro() {
        return registryDate;
    }

    public void setRegistryDate(Date dataCadastro) {
        this.registryDate = dataCadastro;
    }

    public memeCategory getCategory() {
        return category;
    }

    public void setCategory(memeCategory category) {
        this.category = category;
    }

    public User getUsuario() {
        return user;
    }

    public void setUsuario(User user) {
        this.user = user;
    }


}
