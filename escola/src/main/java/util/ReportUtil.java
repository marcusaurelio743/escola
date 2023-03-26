package util;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.servlet.ServletContext;

import org.apache.commons.collections.map.HashedMap;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportUtil implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	public byte[] gerarMatriculaPdf(List listadados,String nomerelatorio,ServletContext servletContext)throws Exception {
		//cria nossa lista de dados que vem do sql da consulta feita 
		JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listadados);
		
		//String caminhojasper = servletContext.getRealPath("relatorio") + File.separator + nomerelatorio + ".jasper";
		String caminhojasper =  "C:\\Users\\Mayara\\git\\repository\\escola\\src\\main\\webapp\\relatorio\\Matricula.jasper";
		
		JasperPrint impressoraJasper  = JasperFillManager.fillReport(caminhojasper,new HashedMap(),jrbcds);
		
		return JasperExportManager.exportReportToPdf(impressoraJasper);
	}

}
