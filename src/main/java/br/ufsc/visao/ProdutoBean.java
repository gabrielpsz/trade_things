package br.ufsc.visao;

import br.ufsc.controle.ProdutoControle;
import br.ufsc.modelo.Produto;
import br.ufsc.modelo.Status;
import br.ufsc.modelo.Tipo;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProdutoBean {

    List<Tipo> tipos = Arrays.asList(Tipo.values());
    List<Status> status = Arrays.asList(Status.values());
    Produto produtoEdit = new Produto();
    ProdutoControle produtoControle = new ProdutoControle();

    FacesContext context = FacesContext.getCurrentInstance();
    LoginBean loginBean = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);

    public String salvar() {
        FacesContext faces = FacesContext.getCurrentInstance();
        try {
            System.out.println(loginBean.getUsuarioLogado());
            produtoEdit.setStatus(Status.DISPONIVEL);
            produtoEdit.setUsuario(loginBean.getUsuarioLogado());
            produtoControle.salvar(produtoEdit);
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", ""));
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } catch (Exception e) {
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
            e.printStackTrace();
        }
        return "";
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public Produto getProdutoEdit() {
        return produtoEdit;
    }

    public void setProdutoEdit(Produto produtoEdit) {
        this.produtoEdit = produtoEdit;
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }
}
