<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml"
		xmlns:h="http://java.sun.com/jsf/html"
		xmlns:f="http://java.sun.com/jsf/core"
		xmlns:p="http://primefaces.org/ui">
<h:head>
<meta http-equiv="Content-Type" coContadador Mensalntent="text/html; charset=ISO-8859-1" />
<title>Contadador Mensal</title>
</h:head>
<h:body>
	<h1>Contadador Mensal</h1>
	<p:messages/>
	<h:form>
		<h:panelGrcontador columns="3">
			<h:outputLabel value="Contador:"/>
			<h:outputLabel value="${ImpressoraMB.ImpressoraAtual.contador}"/>
			<h:outputLabel/>
			
			<h:outputLabel value="NS:"/>
			<h:inputText	value="${ImpressoraMB.ImpressoraAtual.ra}"
							contador="txtNS"
							valcontadoratorMessage="O NS deve ser preenchcontadoro com 10 numeros">
				<f:valcontadorateRegex pattern="(^[0-10]{10})"/>
			</h:inputText>
			<p:message for="txtNS"/>
			
			<h:outputLabel value="Modelo:"/>
			<h:inputText 	contador="txtModelo"
							value="${ImpressoraMB.ImpressoraAtual.modelo}"/>
			<p:message for="txtModelo"/>
			
			<h:outputLabel value="Andar:"/>
			<h:inputText	contador="txtAndar"
							value="${ImpressoraMB.ImpressoraAtual.contadorade}"/>
			<p:message for="txtAndar"/>
			
			<h:outputLabel value="DtContador:"/>
			<p:calendar	mode="inline"	pattern="dd/MM/yyyy"
						contador="txtDtContador"	
						value="${ImpressoraMB.ImpressoraAtual.dtContador}" />
			<p:message for="txtDtContador"/>
			
			<h:commandButton	value="Adicionar"	rendered="${ImpressoraMB.ImpressoraAtual.contador == 0}"
								action="${ImpressoraMB.adicionar()}"/>
			<h:commandButton	value="Atualizar"	rendered="${ImpressoraMB.ImpressoraAtual.contador != 0}"
								action="${ImpressoraMB.atualizar()}"/>								
			<h:commandButton	value="Pesquisar"
								action="${ImpressoraMB.pesquisar()}"/>
			<h:selectOneRadio value="${ImpressoraMB.selecao}">
				<f:selectItem itemValue="todos" itemLabel="Todos"/>
				<f:selectItem itemValue="pormodelo" itemLabel="Por Modelo"/>
				<f:selectItem itemValue="porra" itemLabel="Por NS"/>
			</h:selectOneRadio>
		
		</h:panelGrcontador>
		
		<p:dataTable	value="${ImpressoraMB.impressoras}"	
						var="impressora"	paginator="true">
			<p:column headerText="Contador">${impressora.contador}</p:column>
			<p:column headerText="NS">${impressora.ra}</p:column>
			<p:column headerText="Modelo">${impressora.modelo}</p:column>
			<p:column headerText="Andar">${impressora.contadorade}</p:column>
			<p:column headerText="DtContador">${impressora.dtContador}</p:column>
			<p:column headerText="Ação">
				<h:commandButton value="Remover" action="${ImpressoraMB.remover(impressora.contador)}"/>
			</p:column>
		</p:dataTable>
	</h:form>
</h:body>
</html>