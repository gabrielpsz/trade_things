package br.ufsc.dao;

public interface Dao<E> {

    void salvar(E e);
    void update();
    void excluir(E e);

}