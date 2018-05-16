package br.ufsc.visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.ufsc.controle.UsuarioControle;
import br.ufsc.modelo.Usuario;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	
	private Usuario usuarioEdit = new Usuario();
	private UsuarioControle usuarioControle = new UsuarioControle();
	private String confirmaSenha;

	FacesContext context = FacesContext.getCurrentInstance();
	LoginBean loginBean = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
	
	
	public void salvar() {
		FacesContext faces = FacesContext.getCurrentInstance();
		if (!usuarioEdit.getSenha().equals(confirmaSenha)) {
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas n�o conferem!", ""));
		}
		try {
			usuarioControle.salvar(usuarioEdit);
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
			FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
		} catch (Exception e) {
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public void editar() {
		usuarioEdit = loginBean.getUsuarioLogado();
	}
	
	public void abreCadastroUsuario() {
		try {
		FacesContext.getCurrentInstance().getExternalContext().redirect("cadastrarUsuario.xhtml");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void abreMeusProdutos() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("produto/meusProdutos.xhtml");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void abreTelaInicial() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//
	// Getters and setters
	//
	public Usuario getUsuarioEdit() {
		return usuarioEdit;
	}

	public void setUsuarioEdit(Usuario usuarioEdit) {
		this.usuarioEdit = usuarioEdit;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	


}
