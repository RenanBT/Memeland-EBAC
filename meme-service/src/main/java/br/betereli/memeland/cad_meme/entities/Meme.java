package br.betereli.memeland.cad_meme.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_meme")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "registry_date", nullable = false)
    private Date registryDate;

    @Column(name = "categoria_meme_id", nullable = false)
    private Long memeCategoryId;

    @Column(name = "usuario_id", nullable = false)
    private Long userId;

    public Meme() {}

    public Long getMemeCategoryId() {
        return memeCategoryId;
    }

    public void setMemeCategoryId(Long memeCategoryId) {
        this.memeCategoryId = memeCategoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
    }

    public void setUser(User user) {
    }

    public void setCategory(memeCategory categoria) {
    }
}
