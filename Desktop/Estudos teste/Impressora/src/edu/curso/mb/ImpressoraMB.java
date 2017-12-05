package edu.curso.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.curso.dao.ImpressoraDAO;
import edu.curso.dao.ImpressoraDAOImplementation;
import edu.curso.entidade.Impressora;

@ManagedBean
@ViewScoped
public class ImpressoraMB implements Serializable {

	private static final long serialVersionUID = 1402178303413714619L;
	private Impressora ImpressoraAtual;
	private List<Impressora> impressoras;
	private String selecao;
	
	public ImpressoraMB() { 
		setImpressoraAtual( new Impressora() );
		setImpressoras( new ArrayList<Impressora>() );
	}
	
	public String remover( long id ) {
		
		FacesContext.getCurrentInstance()
		.addMessage(null, 
		new FacesMessage("Impressora com ID " + 
							id + 
							" foi removido com sucesso") );
		
		// Codigo para remover o Impressora com o Id recebido como parametro..
		
		return " ";
	}
	
	public String adicionar() { 
		ImpressoraDAO aDao = new ImpressoraDAOImplementation();
		aDao.adicionar( ImpressoraAtual );
		
		FacesContext.getCurrentInstance()
			.addMessage(null, 
			new FacesMessage("Contador da impressora " + 
								ImpressoraAtual.getModelo() + 
								" cadastrado com sucesso") );
		
		ImpressoraAtual = new Impressora();
		return " ";
	}
	
	public String atualizar() { 
		ImpressoraDAO aDao = new ImpressoraDAOImplementation();
		aDao.atualizar( ImpressoraAtual.getId(), ImpressoraAtual );
		
		FacesContext.getCurrentInstance()
			.addMessage(null, 
			new FacesMessage("Impressora " + 
								ImpressoraAtual.getModelo() + 
								" atualizado com sucesso") );
		
		//ImpressoraAtual = new Impressora();
		return " ";
	}
	
	public String pesquisar() {
		ImpressoraDAO aDao = new ImpressoraDAOImplementation();
		if ("todos".equals(selecao)) { 
			impressoras = aDao.pesquisarTodos();
		} else if ("pornome".equals(selecao)) { 
			impressoras = aDao.pesquisarPorModelo( ImpressoraAtual.getModelo() );
		} else if ("porra".equals(selecao)) { 
			ImpressoraAtual = aDao.pesquisarPorPatrimonio( ImpressoraAtual.getPatrimonio() );
		}
		return " ";
	}
	
	public Impressora getImpressoraAtual() {
		return ImpressoraAtual;
	}
	public void setImpressoraAtual(Impressora ImpressoraAtual) {
		this.ImpressoraAtual = ImpressoraAtual;
	}
	public List<Impressora> getImpressoras() {
		return impressoras;
	}
	public void setImpressoras(List<Impressora> impressoras) {
		this.impressoras = impressoras;
	}

	public String getSelecao() {
		return selecao;
	}

	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}	
}
