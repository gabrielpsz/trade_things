package br.ufsc.visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ufsc.controle.UsuarioControle;
import br.ufsc.modelo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	
	private Usuario usuarioEdit = new Usuario();
	private List<Usuario> listUsuario = new ArrayList<Usuario>();
	private UsuarioControle usuarioControle = new UsuarioControle();
	private Usuario usuarioSelecionado = new Usuario();
	private String confirmaSenha;
	private boolean skip;
	
	public String salvar() {
		FacesContext faces = FacesContext.getCurrentInstance();
		if (!usuarioEdit.getSenha().equals(confirmaSenha)) {
			faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas não conferem!", ""));
			return "";
		}
			try {
				usuarioControle.salvar(usuarioEdit);
				faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
			} catch (Exception e) {
				faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
				e.printStackTrace();
				return "";
			}	
			return "index";
	}
	
	public String abreCadastroUsuario() {
		return "cadastroUsuario";
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


}
