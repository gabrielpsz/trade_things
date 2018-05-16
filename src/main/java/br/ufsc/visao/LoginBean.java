package br.ufsc.visao;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ufsc.controle.UsuarioControle;
import br.ufsc.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private UsuarioControle usuarioControle = new UsuarioControle();
	private String email;
	private String senha;
	private Boolean logado;
	
	private Usuario usuarioLogado;
	
	public void autentica() {
		FacesContext context = FacesContext.getCurrentInstance();
		usuarioLogado = usuarioControle.autenticarUsuario(email, senha);
		System.out.println(usuarioLogado);
		if (usuarioLogado == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha inv�lido!", ""));
		} else {
			System.out.println("Logou");
			logado = true;
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void logout() {
		usuarioLogado = null;
		logado = false;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void abrirCadastroProduto() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("produto/cadastrarProduto.xhtml");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
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
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Boolean getLogado() {
		return logado;
	}

	public void setLogado(Boolean logado) {
		this.logado = logado;
	}
}
