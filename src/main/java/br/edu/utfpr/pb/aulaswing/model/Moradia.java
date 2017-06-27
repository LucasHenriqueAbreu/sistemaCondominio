package br.edu.utfpr.pb.aulaswing.model;

import br.edu.utfpr.pb.aulaswing.util.BooleanConverter;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Lucas Henrique de Abreu
 */

@Entity
@Table(name = "moradia")
public class Moradia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "sobrenome",length = 100, nullable = false)
    private String sobrenome;
    
    @Column(name = "quantidade_moradores", nullable = false)
    private Integer quantidadeMoradores;
    
    @ManyToOne
    @JoinColumn(name = "condominio", referencedColumnName = "id")
    private Condominio condominio;
    
    @Convert(converter = BooleanConverter.class)
    @Column(columnDefinition = "char(1) default 'T'")
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getQuantidadeMoradores() {
        return quantidadeMoradores;
    }

    public void setQuantidadeMoradores(Integer quantidadeMoradores) {
        this.quantidadeMoradores = quantidadeMoradores;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.sobrenome);
        hash = 83 * hash + Objects.hashCode(this.quantidadeMoradores);
        hash = 83 * hash + Objects.hashCode(this.condominio);
        hash = 83 * hash + Objects.hashCode(this.ativo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Moradia other = (Moradia) obj;
        if (!Objects.equals(this.sobrenome, other.sobrenome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.quantidadeMoradores, other.quantidadeMoradores)) {
            return false;
        }
        if (!Objects.equals(this.condominio, other.condominio)) {
            return false;
        }
        if (!Objects.equals(this.ativo, other.ativo)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return id + " - " + sobrenome;
    }    
}
