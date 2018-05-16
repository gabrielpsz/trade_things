package br.ufsc.controle;

import br.ufsc.dao.DaoFactory;
import br.ufsc.dao.ProdutoDao;
import br.ufsc.modelo.Produto;
import br.ufsc.modelo.Usuario;

import java.util.List;

public class ProdutoControle {

    ProdutoDao produtoDao = DaoFactory.getProdutoDao();

    public void salvar(Produto produto) throws Exception {
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            throw new Exception("O nome � obrigat�rio!");
        }
        if (produto.getId() == null) {
            produtoDao.salvar(produto);
        }else {
            produtoDao.update();
        }
    }

    public void excluir(Produto p) throws Exception {
        if (p == null) {
            throw new Exception("É obrigatório escolher um produto para excluir");
        }
        produtoDao.excluir(p);
    }



    public List<Produto> queryAll() {
        return produtoDao.queryAll();
    }
}
