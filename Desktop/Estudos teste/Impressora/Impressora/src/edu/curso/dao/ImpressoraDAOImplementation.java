package edu.curso.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.curso.entidade.Impressora;

public class ImpressoraDAOImplementation 
		implements ImpressoraDAO {

	@Override
	public void adicionar(Impressora a) {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist( a );
		em.getTransaction().commit();
		
		em.close();
		
		
	}

	@Override
	public void remover(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(long id, Impressora a) {
		EntityManager em = JPAUtil.getEntityManager();
		Impressora oldImpressora = em.getReference(Impressora.class, id);
		if (oldImpressora != null) { 
			em.getTransaction().begin();
			oldImpressora.setIdade( a.getContador() );
			oldImpressora.setNome( a.getModelo() );
			oldImpressora.setRa( a.getPatrimonio() );
			oldImpressora.setNascimento( a.getDtContador() );
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public Impressora pesquisarPorPatrimonio(String ra) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Impressora> qry = em.
			createQuery("select a from impressas a where a.patrimonio = :p", 
						Impressora.class);
			qry.setParameter("p", patrimonio);
		Impressora a = qry.getSingleResult();
		if (a == null) {
			a = new Impressora();
		}
		em.close();
		return a;
	}

	@Override
	public List<Impressora> pesquisarPorNascimento(Date dtContador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Impressora> pesquisarTodos() {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Impressora> qry = em.
				createQuery("select a from impressras a", Impressora.class);
		List<Impressora> lista = qry.getResultList();
		if (lista == null) {
			lista = new ArrayList<Impressora>();
		}
		em.close();
		return lista;
	}

	@Override
	public List<Impressora> pesquisarPorModelo(String nome) {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Impressora> qry = em.
			createQuery("select a from impressoras a where a.nome like :n", 
						Impressora.class);
			qry.setParameter("n", nome);
		List<Impressora> lista = qry.getResultList();
		if (lista == null) {
			lista = new ArrayList<Impressora>();
		}
		em.close();
		return lista;
	}

}
