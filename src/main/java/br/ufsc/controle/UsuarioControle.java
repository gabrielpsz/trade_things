package br.ufsc.controle;

import br.ufsc.dao.DaoFactory;
import br.ufsc.dao.UsuarioDao;
import br.ufsc.modelo.Usuario;

import java.util.List;

public class UsuarioControle {

    UsuarioDao usuarioDao = DaoFactory.getUsuarioDao();

    public void salvar(Usuario usuario) throws Exception {
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new Exception("O nome é obrigatório!");
        }

        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new Exception("O E-Mail é obrigatório!");
        }
        if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
            throw new Exception("A senha é obrigatória!");
        }
        if (usuario.getId() == 0) {
            usuarioDao.salvar(usuario);
        }else {
            usuarioDao.update();
        }
    }

    public Usuario buscarPorId(long idUsuario) throws Exception{
        if (idUsuario <= 0) {
            throw new Exception("O id deve ser maior que 0");
        }
        return usuarioDao.buscarPorId(idUsuario);
    }

    public List<Usuario> buscarTodos(){
        return usuarioDao.buscarTodos();
    }

    public List<Usuario> buscarPorCPF(String cpf) throws Exception {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new Exception("O cpf é obrigatório para a consulta!");
        }
        return usuarioDao.buscarPorCPF(cpf);
    }

    public void excluir(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("É obrigatório selecionar um usuario para excluir");
        }
        usuarioDao.excluir(usuario);
    }

    public Usuario autenticarUsuario(String login, String senha) {
        UsuarioDao usuarioDao = DaoFactory.getUsuarioDao();
        return usuarioDao.autenticarUsuario(login, senha);
    }

}
