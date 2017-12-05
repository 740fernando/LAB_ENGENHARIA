package edu.curso.dao;

import java.util.Date;
import java.util.List;

import edu.curso.entidade.Impressora;

public interface ImpressoraDAO {

	public void adicionar(Impressora a);
	public void remover(long id);
	public void atualizar(long id, Impressora a);
	public Impressora pesquisarPorPatrimonio(String patrimonio);
	public List<Impressora> pesquisarDtContador(Date dtContador);
	public List<Impressora> pesquisarTodos();
	public List<Impressora> pesquisarPorModeolo(String Modelo);
	
}
