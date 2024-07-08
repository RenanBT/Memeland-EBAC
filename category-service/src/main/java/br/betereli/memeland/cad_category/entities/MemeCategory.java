package br.betereli.memeland.cad_category.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "MEME_CATEGORY")
public class MemeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meme_category_sequence")
    @SequenceGenerator(name = "meme_category_sequence", sequenceName = "meme_category_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "registry_date", nullable = false)
    private Date registryDate;

    public Date getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
    }

    public MemeCategory() {}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
