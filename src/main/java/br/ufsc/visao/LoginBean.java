package br.ufsc.visao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufsc.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private String email;
	private String senha;
	
	private Usuario usuarioLogado;
	
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
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	

}
