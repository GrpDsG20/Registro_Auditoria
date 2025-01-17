package com.springboot.util.reportes;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springboot.model.Auditoria;

public class AuditoriaExporterPDF {
	
	private List<Auditoria> listaAuditoria;
	private long idAuditoria;

	public AuditoriaExporterPDF(List<Auditoria> listaAuditoria, long idauditoria) {
		super();
		this.listaAuditoria = listaAuditoria;
		this.idAuditoria = idauditoria;
	}
	
	private void escribirCabeceraFila1(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();
		
		celda.setBackgroundColor(Color.DARK_GRAY);
		celda.setPadding(5);
		
		Font fuente = FontFactory.getFont(FontFactory.HELVETICA,9);
		fuente.setColor(Color.WHITE);
		
		celda.setPhrase(new Phrase("TIPO DE LLAMADA",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);	
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("TIEMPO",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("CALIDAD",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("FECHA",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("ASESOR",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("CARTERA",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("COORDINADOR",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
	}
		
	private void escribirCabeceraFila2(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();
		
		celda.setBackgroundColor(Color.DARK_GRAY);
		celda.setPadding(5);
		
		Font fuente = FontFactory.getFont(FontFactory.HELVETICA,9);
		fuente.setColor(Color.WHITE);
		celda.setPhrase(new Phrase("OFICINA",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("NOMBRE  DEL CLIENTE",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("MOTIVO DE LLAMADA",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("TIPO DE CONTACTO",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("RESULTADO",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("TIPIFICACIÓN",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("CAMPO DE OBSERVACIONES",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
	}
	private void escribirCabeceraFila3(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();
		
		celda.setBackgroundColor(Color.DARK_GRAY);
		celda.setPadding(5);
		
		Font fuente = FontFactory.getFont(FontFactory.HELVETICA,9);
		fuente.setColor(Color.WHITE);		
		celda.setPhrase(new Phrase("SALUDO",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("ASESOR SE IDENTIFICA",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("IDENTIFICA AL CLIENTE",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("SONDEA EL MOTIVO DE INCUMPLIMIENTO",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("REBATE OBJECIONES/NEGOCIACIÓN",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("INFORMA SOBRE DEUDA",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("INFORMA SOBRE CAMPAÑA/NEGOCIA PAGO",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		
	}
	
	private void escribirCabeceraFila4(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();
		
		celda.setBackgroundColor(Color.DARK_GRAY);
		celda.setPadding(5);
		
		Font fuente = FontFactory.getFont(FontFactory.HELVETICA,9);
		fuente.setColor(Color.WHITE);		
		celda.setPhrase(new Phrase("INFORMA PROCESOS LEGALES",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("REALIZA SEGUIMIENTO EN EL PLAZO ACORDADO",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("INFORMA QUE SE ENVIARÁ UN MENSAJE WHATSAPP",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("ACUERDA COMPROMISO DE PAGO",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("ACUERDA PAGO EN 24/48 HORAS",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("SOLICITA NÚMERO DE CONTACTO ADICIONAL",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("EXPLICA EL PROCESO DE PAGO Y DOCUMENTACIÓN",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
	}
	private void escribirCabeceraFila5(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();
		
		celda.setBackgroundColor(Color.DARK_GRAY);
		celda.setPadding(5);
		
		Font fuente = FontFactory.getFont(FontFactory.HELVETICA,9);
		fuente.setColor(Color.WHITE);
		
		celda.setPhrase(new Phrase("APLICA SPEECH DE COMPROMISO DE PAGO",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("TONO DE VOZ",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("VOCALIZACIÓN",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("ARGUMENTOS/CONOCIMIENTOS",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("NEGOCIACIÓN",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("ESCUCHA ACTIVA/LECTURA DE HISTORIAL DE GESTIONES",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("EMPATÍA",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
	}
	private void escribirCabeceraFila6(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();
		
		celda.setBackgroundColor(Color.DARK_GRAY);
		celda.setPadding(5);
		
		Font fuente = FontFactory.getFont(FontFactory.HELVETICA,9);
		fuente.setColor(Color.WHITE);
		
		celda.setPhrase(new Phrase("DETALLE DE LLAMADA",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("FEEDBACK - PUNTO MEJORA",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("FEEDBACK - PUNTO RESALTANTE",fuente));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("AUDIO",fuente));
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("",fuente));
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("",fuente));
		tabla.addCell(celda);
		celda.setPhrase(new Phrase("",fuente));
		tabla.addCell(celda);
		
	}
	
	private void escribirDatosDeLaTabla1(PdfPTable tabla) {			
	    for(Auditoria auditoria : listaAuditoria) {
	    	if (auditoria.getID() == idAuditoria) {
	        tabla.addCell(auditoria.getTIPO_LLAMADA());
	        tabla.addCell(auditoria.getTIEMPO_LLAMADA()); 
	        tabla.addCell(auditoria.getCALIDAD()); 
	        tabla.addCell(auditoria.getFECHA().toString());
	        tabla.addCell(auditoria.getASESOR());
	        tabla.addCell(auditoria.getCARTERA());
	        tabla.addCell(auditoria.getCOORDINADOR());
	    }
	    }
	}
	    private void escribirDatosDeLaTabla2(PdfPTable tabla) {			
		    for(Auditoria auditoria : listaAuditoria) {
		    	if (auditoria.getID() == idAuditoria) {
	        tabla.addCell(auditoria.getOFICINA());
	        tabla.addCell(auditoria.getNOMBRE_DEL_CLIENTE());
	        tabla.addCell(auditoria.getMOTIVO_DE_LLAMADA());
	        tabla.addCell(auditoria.getTIPO_DE_CONTACTO());
	        tabla.addCell(auditoria.getRESULTADO());
	        tabla.addCell(auditoria.getTIPIFICACION());
	        tabla.addCell(auditoria.getCAMPO_DE_OBSERVACIONES());
		   }
		    }
	    }
	    private void escribirDatosDeLaTabla3(PdfPTable tabla) {			
		    for(Auditoria auditoria : listaAuditoria) {
		    	if (auditoria.getID() == idAuditoria) {
	        tabla.addCell(auditoria.getP1());
	        tabla.addCell(auditoria.getP2());
	        tabla.addCell(auditoria.getP3());
	        tabla.addCell(auditoria.getP4());
	        tabla.addCell(auditoria.getP5());
	        tabla.addCell(auditoria.getP6());
	        tabla.addCell(auditoria.getP7());
		    }
	    }
	    }
	    private void escribirDatosDeLaTabla4(PdfPTable tabla) {			
		    for(Auditoria auditoria : listaAuditoria) {
		    	if (auditoria.getID() == idAuditoria) {
	        tabla.addCell(auditoria.getP8());
	        tabla.addCell(auditoria.getP9());
	        tabla.addCell(auditoria.getP10());
	        tabla.addCell(auditoria.getP11());
	        tabla.addCell(auditoria.getP12());
	        tabla.addCell(auditoria.getP13());
	        tabla.addCell(auditoria.getP14());
		    }
		    }
	    }
	    private void escribirDatosDeLaTabla5(PdfPTable tabla) {			
		    for(Auditoria auditoria : listaAuditoria) {
		    	if (auditoria.getID() == idAuditoria) {
	        tabla.addCell(auditoria.getP15());
	        tabla.addCell(auditoria.getP16());
	        tabla.addCell(auditoria.getP17());
	        tabla.addCell(auditoria.getP18());
	        tabla.addCell(auditoria.getP19());
	        tabla.addCell(auditoria.getP20());
	        tabla.addCell(auditoria.getP21());
		    }
		    }
	    }
	    private void escribirDatosDeLaTabla6(PdfPTable tabla) {			
		    for(Auditoria auditoria : listaAuditoria) {
		    	if (auditoria.getID() == idAuditoria) {
		    		
	        tabla.addCell(auditoria.getDETALLE_DE_LLAMADA());
	        tabla.addCell(auditoria.getFEEDBACK_1());
	        tabla.addCell(auditoria.getFEEDBACK_2());
	        tabla.addCell(auditoria.getAUDIO());	        
	        tabla.addCell("");
	        tabla.addCell("");
	        tabla.addCell("");
		    }
	    }
	}
	    
	
	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4.rotate());
		PdfWriter.getInstance(documento, response.getOutputStream());
		
		documento.open();
		
		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLACK);
		fuente.setSize(18);
		
		documento.add(new Paragraph(" "));
		
		Paragraph titulo = new Paragraph("Detalles Auditoria", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);
		
		documento.add(new Paragraph(" "));
				
		int numeroColumnas = 7;		
		 PdfPTable tabla = new PdfPTable(numeroColumnas);
		    tabla.setWidthPercentage(100);
		    tabla.setSpacingBefore(10);
		   
		    float[] anchosCeldas = new float[numeroColumnas];
		    float anchoCelda = 100f / numeroColumnas;
		    Arrays.fill(anchosCeldas, anchoCelda);		   
		    tabla.setWidths(anchosCeldas);

		    escribirCabeceraFila1(tabla);
		    escribirDatosDeLaTabla1(tabla);
		    escribirCabeceraFila2(tabla);
		    escribirDatosDeLaTabla2(tabla);
		    escribirCabeceraFila3(tabla);
		    escribirDatosDeLaTabla3(tabla);
		    escribirCabeceraFila4(tabla);
		    escribirDatosDeLaTabla4(tabla);
		    escribirCabeceraFila5(tabla);
		    escribirDatosDeLaTabla5(tabla);
		    escribirCabeceraFila6(tabla);		    	    
		    escribirDatosDeLaTabla6(tabla);

		    documento.add(tabla);
		    documento.close();
	}
}
