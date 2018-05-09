package br.ufsc.dao;

public abstract class DaoFactory {

    private static UsuarioDao usuarioDao;

    public static UsuarioDao getUsuarioDao() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDaoImp();
        }
        return usuarioDao;
    }

    private static ProdutoDao produtoDao;

    public static ProdutoDao getProdutoDao() {
        if (produtoDao == null) {
            produtoDao = new ProdutoDaoImp();
        }
        return produtoDao;
    }

}
