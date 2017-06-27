/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pb.aulaswing.model;

import br.edu.utfpr.pb.aulaswing.util.BooleanConverter;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lucas.henrique
 */
@Entity
@Table(name = "despesa")
public class Despesa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Convert(converter = BooleanConverter.class)
    @Column(columnDefinition = "char(1) default 'T'")
    private Boolean paga;
    
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    
    @ManyToOne
    @JoinColumn(name = "moradia", referencedColumnName = "id")
    private Moradia moradia;
    
    @OneToMany
    @JoinColumn(name = "despesa", referencedColumnName = "id")
    private List<DespesaItem> despesas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPaga() {
        return paga;
    }

    public void setPaga(Boolean paga) {
        this.paga = paga;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Moradia getMoradia() {
        return moradia;
    }

    public void setMoradia(Moradia moradia) {
        this.moradia = moradia;
    }

    public List<DespesaItem> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<DespesaItem> despesas) {
        this.despesas = despesas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.paga);
        hash = 71 * hash + Objects.hashCode(this.dataLancamento);
        hash = 71 * hash + Objects.hashCode(this.dataVencimento);
        hash = 71 * hash + Objects.hashCode(this.moradia);
        hash = 71 * hash + Objects.hashCode(this.despesas);
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
        final Despesa other = (Despesa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.paga, other.paga)) {
            return false;
        }
        if (!Objects.equals(this.dataLancamento, other.dataLancamento)) {
            return false;
        }
        if (!Objects.equals(this.dataVencimento, other.dataVencimento)) {
            return false;
        }
        if (!Objects.equals(this.moradia, other.moradia)) {
            return false;
        }
        if (!Objects.equals(this.despesas, other.despesas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " - " + dataLancamento;
    }  
    
}
