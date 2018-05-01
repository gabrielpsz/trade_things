package br.ufsc.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries({
		@NamedQuery(name = "Usuario.buscarTodos", query = "SELECT u FROM Usuario u"),
		@NamedQuery(name = "Usuario.buscarPorEmailSenha", query = "SELECT u FROM Usuario u WHERE u.email = :login AND u.senha = :senha") })
public class Usuario {

	@Id
    @Column
    @SequenceGenerator(name="usuario_id_seq",sequenceName="usuario_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
    private Long id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String senha;

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
}
