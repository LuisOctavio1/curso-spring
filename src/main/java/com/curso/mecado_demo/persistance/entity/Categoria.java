package com.curso.mecado_demo.persistance.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Column(name = "id_categoria")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer idCategoria;

    private String description;
    private Boolean estado;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
