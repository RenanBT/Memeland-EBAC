package br.betereli.memeland.cad_meme.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_meme")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "categoria_meme_id", nullable = false)
    private Long categoriaMemeId;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    public Meme() {}

    public Long getCategoriaMemeId() {
        return categoriaMemeId;
    }

    public void setCategoriaMemeId(Long categoriaMemeId) {
        this.categoriaMemeId = categoriaMemeId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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
}
