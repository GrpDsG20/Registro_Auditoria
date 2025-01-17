package com.springboot.util.reportes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.springboot.model.Auditoria;

public class AuditoriaExporterExcelTabla {
	
	private XSSFWorkbook libro;
	private XSSFSheet hoja;
	
	private List<Auditoria> listaAuditoria;

	public AuditoriaExporterExcelTabla(List<Auditoria> listaAuditoria) {
		this.listaAuditoria = listaAuditoria;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Auditoria");
	}
	
	private void escribirCabeceraTabla() {
		Row fila = hoja.createRow(0);
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(9);
		estilo.setFont(fuente);
		
		Cell celda = fila.createCell(0);
		celda.setCellValue("TIPO DE LLAMADA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(1);
		celda.setCellValue("TIEMPO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(2);
		celda.setCellValue("CALIDAD");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(3);
		celda.setCellValue("FECHA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(4);
		celda.setCellValue("ASESOR");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(5);
		celda.setCellValue("CARTERA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(6);
		celda.setCellValue("COORDINADOR");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(7);
		celda.setCellValue("OFICINA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(8);
		celda.setCellValue("NOMBRE DEL CLIENTE");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(9);
		celda.setCellValue("MOTIVO DE LLAMADA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(10);
		celda.setCellValue("TIPO DE CONTACTO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(11);
		celda.setCellValue("RESULTADO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(12);
		celda.setCellValue("TIPIFICACIÓN");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(13);
		celda.setCellValue("CAMPO DE OBSERVACIONES");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(14);
		celda.setCellValue("SALUDO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(15);
		celda.setCellValue("ASESOR SE IDENTIFICA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(16);
		celda.setCellValue("IDENTIFICA AL CLIENTE");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(17);
		celda.setCellValue("SONDEA EL MOTIVO DE INCUMPLIMIENTO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(18);
		celda.setCellValue("REBATE OBJECIONES/NEGOCIACION");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(19);
		celda.setCellValue("INFORMA DOBRE DEUDA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(20);
		celda.setCellValue("INFORMA SOBRE CAMPAÑA/NEGOCIA PAGO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(21);
		celda.setCellValue("INFORMA PROCESOS LEGALES");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(22);
		celda.setCellValue("REALIZA SEGUIMIENTO EN EL PLAZO ACORDADO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(23);
		celda.setCellValue("INFORMA QUE SE ENVIARÁ UN MENSAJE WHATSAPP");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(24);
		celda.setCellValue("ACUERDA COMPROMISO DE PAGO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(25);
		celda.setCellValue("ACUERDA PAGO EN 24/48HORAS");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(26);
		celda.setCellValue("SOLICITA NÚMERO DE CONTACTO ADICIONAL");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(27);
		celda.setCellValue("EXPLICA EL PROCESO DE PAGO Y DOCUMENTACIÓN");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(28);
		celda.setCellValue("APLICA SPEECH DE COMPROMISO DE PAGO");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(29);
		celda.setCellValue("TONO DE VOZ");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(30);
		celda.setCellValue("VOCALIZACIÓN");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(31);
		celda.setCellValue("ARGUMENTOS/CONOCIMIENTOS");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(32);
		celda.setCellValue("NEGOCIACIÓN");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(33);
		celda.setCellValue("ESCUCHA ACTIVA/LECTURA DE HISTORIAL DE GESTIONES");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(34);
		celda.setCellValue("EMPATÍA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(35);
		celda.setCellValue("DETALLE DE LLAMADA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(36);
		celda.setCellValue("FEEDBACK- PUNTO DE MEJORA");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(37);
		celda.setCellValue("FEEDBACK- PUNTO RESALTANTE ");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(38);
		celda.setCellValue("AUDIO");
		celda.setCellStyle(estilo);
	}
	
	private void escribirDatosDeLaTabla() {
		int numeroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(10);
		estilo.setFont(fuente);
		
		CellStyle estiloFechaHora = libro.createCellStyle();
	    estiloFechaHora.cloneStyleFrom(estilo);
	    CreationHelper creationHelper = libro.getCreationHelper();
	    short formatoFechaHoraIndex = creationHelper.createDataFormat().getFormat("dd/MM/yyyy HH:mm");
	    estiloFechaHora.setDataFormat(formatoFechaHoraIndex);   
	    	    
	    
		for(Auditoria auditoria : listaAuditoria) {
			Row fila = hoja.createRow(numeroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(auditoria.getTIPO_LLAMADA());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(1);
			celda.setCellValue(auditoria.getTIEMPO_LLAMADA());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(2);
			celda.setCellValue(auditoria.getCALIDAD());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(3);
			celda.setCellValue(auditoria.getFECHA());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estiloFechaHora);
			
			celda = fila.createCell(4);
			celda.setCellValue(auditoria.getASESOR());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(5);
			celda.setCellValue(auditoria.getCARTERA());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(6);
			celda.setCellValue(auditoria.getCOORDINADOR());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(7);
			celda.setCellValue(auditoria.getOFICINA());
			hoja.autoSizeColumn(7);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(8);
			celda.setCellValue(auditoria.getNOMBRE_DEL_CLIENTE());
			hoja.autoSizeColumn(8);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(9);
			celda.setCellValue(auditoria.getMOTIVO_DE_LLAMADA());
			hoja.autoSizeColumn(9);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(10);
			celda.setCellValue(auditoria.getTIPO_DE_CONTACTO());
			hoja.autoSizeColumn(10);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(11);
			celda.setCellValue(auditoria.getRESULTADO());
			hoja.autoSizeColumn(11);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(12);
			celda.setCellValue(auditoria.getTIPIFICACION());
			hoja.autoSizeColumn(12);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(13);
			celda.setCellValue(auditoria.getCAMPO_DE_OBSERVACIONES());
			hoja.autoSizeColumn(13);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(14);
			celda.setCellValue(auditoria.getP1());
			hoja.autoSizeColumn(14);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(15);
			celda.setCellValue(auditoria.getP2());
			hoja.autoSizeColumn(15);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(16);
			celda.setCellValue(auditoria.getP3());
			hoja.autoSizeColumn(16);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(17);
			celda.setCellValue(auditoria.getP4());
			hoja.autoSizeColumn(17);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(18);
			celda.setCellValue(auditoria.getP5());
			hoja.autoSizeColumn(18);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(19);
			celda.setCellValue(auditoria.getP6());
			hoja.autoSizeColumn(19);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(20);
			celda.setCellValue(auditoria.getP7());
			hoja.autoSizeColumn(20);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(21);
			celda.setCellValue(auditoria.getP8());
			hoja.autoSizeColumn(21);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(22);
			celda.setCellValue(auditoria.getP9());
			hoja.autoSizeColumn(22);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(23);
			celda.setCellValue(auditoria.getP10());
			hoja.autoSizeColumn(23);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(24);
			celda.setCellValue(auditoria.getP11());
			hoja.autoSizeColumn(24);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(25);
			celda.setCellValue(auditoria.getP12());
			hoja.autoSizeColumn(25);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(26);
			celda.setCellValue(auditoria.getP13());
			hoja.autoSizeColumn(26);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(27);
			celda.setCellValue(auditoria.getP14());
			hoja.autoSizeColumn(27);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(28);
			celda.setCellValue(auditoria.getP15());
			hoja.autoSizeColumn(28);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(29);
			celda.setCellValue(auditoria.getP16());
			hoja.autoSizeColumn(29);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(30);
			celda.setCellValue(auditoria.getP17());
			hoja.autoSizeColumn(30);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(31);
			celda.setCellValue(auditoria.getP18());
			hoja.autoSizeColumn(31);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(32);
			celda.setCellValue(auditoria.getP19());
			hoja.autoSizeColumn(32);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(33);
			celda.setCellValue(auditoria.getP20());
			hoja.autoSizeColumn(33);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(34);
			celda.setCellValue(auditoria.getP21());
			hoja.autoSizeColumn(34);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(35);
			celda.setCellValue(auditoria.getDETALLE_DE_LLAMADA());
			hoja.autoSizeColumn(35);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(36);
			celda.setCellValue(auditoria.getFEEDBACK_1());
			hoja.autoSizeColumn(36);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(37);
			celda.setCellValue(auditoria.getFEEDBACK_2());
			hoja.autoSizeColumn(37);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(38);
			celda.setCellValue(auditoria.getAUDIO());
			hoja.autoSizeColumn(38);
			celda.setCellStyle(estilo);	
		}
	}
	
	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraTabla();
		escribirDatosDeLaTabla();
		
		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);
		
		libro.close();
		outPutStream.close();
		
		
	}
	
	

}
