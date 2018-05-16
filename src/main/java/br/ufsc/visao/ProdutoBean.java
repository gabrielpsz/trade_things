package br.ufsc.visao;

import br.ufsc.controle.ProdutoControle;
import br.ufsc.modelo.Produto;
import br.ufsc.modelo.Status;
import br.ufsc.modelo.Tipo;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProdutoBean extends _Bean {

    ProdutoControle produtoControle = new ProdutoControle();
    List<Produto> produtos = produtoControle.queryAll();
    List<Tipo> tipos = Arrays.asList(Tipo.values());
    List<Status> status = Arrays.asList(Status.values());
    Produto produtoEdit = new Produto();

    String displayedLogo = "";

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

    public void trocarProduto() {
        Produto p = (Produto)getJsfParam("entity");

    }

    public void visualizarProduto() {
        produtoEdit = (Produto)getJsfParam("entity");
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

    public String getDisplayedLogo() {
        return displayedLogo;
    }

    public void setDisplayedLogo(String displayedLogo) {
        this.displayedLogo = displayedLogo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
