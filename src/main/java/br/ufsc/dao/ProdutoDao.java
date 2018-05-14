package br.ufsc.dao;

import br.ufsc.modelo.Produto;

import java.util.List;

public interface ProdutoDao extends Dao<Produto> {

    List<Produto> queryAll();

}
