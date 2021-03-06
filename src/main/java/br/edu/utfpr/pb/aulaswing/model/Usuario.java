package br.edu.utfpr.pb.aulaswing.model;

import br.edu.utfpr.pb.aulaswing.util.BooleanConverter;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findByEmailAndSenha",
            query = "from Usuario u "
                + " where u.email=:email AND u.senha=:senha"),
    @NamedQuery(name = "Usuario.findAll",
            query = "Select u from Usuario u")
})
public class Usuario implements Serializable{
    public static final String FIND_ALL = "Usuario.findAll";
    public static final String FIND_BY_EMAIL_AND_SENHA=
            "Usuario.findByEmailAndSenha";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 11, nullable = false)
    private String cpf;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 512, nullable = false)
    private String senha;
    
    @Convert(converter = BooleanConverter.class)
    @Column(columnDefinition = "char(1) default 'T'")
    private Boolean ativo;
    
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
       

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
