package com.springboot.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lowagie.text.DocumentException;
import com.springboot.model.Auditoria;
import com.springboot.service.AuditoriaService;
import com.springboot.util.reportes.AuditoriaExporterExcelTabla;
import com.springboot.util.reportes.AuditoriaExporterPDF;

@Controller
public class ControllerAuditoria {
	
	@Autowired
	private AuditoriaService serviceAuditoria;
	
	@GetMapping("/Menu")
	public String index(Model modelo) {
		List<Auditoria>lista = serviceAuditoria.listarTodos();
		modelo.addAttribute("listaAuditoria",lista);
		return "principal";
	}
	
	@GetMapping("/nuevoAudi")
	public String nuevo(Model modelo) {
		modelo.addAttribute("titulo","Registro Auditoria");
		modelo.addAttribute("auditoria", new Auditoria());		
		List<String> opcionTLL = Arrays.asList("Manual","Progresivo","Predictivo");
		modelo.addAttribute("opcionTipoLLamada",opcionTLL);
		List<String> opcionCali = Arrays.asList("YULEISY MIREYA SALCINES CARMEN", "JHOVANA KATHERIN ESPINOZA COCHACHI");
		modelo.addAttribute("opcionCalidad",opcionCali);
		List<String> opcionOF = Arrays.asList("JZG","ECL");
		modelo.addAttribute("opcionOficina",opcionOF);
		List<String> opcionMoti = Arrays.asList("SEGUIMIENTO DE LLAMADA","CONTACTO DIRECTO CON COMPROMISO DE PAGO","CONTACTO DIRECTO SIN COMPROMISO DE PAGO","INCUMPLIMIENTO DE PAGO","DERIVACIONES","CONTACTO INDIRECTO SIN COMPROMISO DE PAGO","CONTACTO INDIRECTO CON COMPROMISO DE PAGO");
		modelo.addAttribute("opcionMotivo",opcionMoti);
		List<String> opcionTipoCon = Arrays.asList("LLAMADAS SALIENTES CON CONTACTO","CLIENTE POR DERIVACION","INCUMPLIMIENTO DE PAGO","SEGUIMIENTO DE LLAMADA","LLAMADAS SALIENTES SIN CONTACTO","RECEPCION DE CLIENTES EN LLAMADAS");
        modelo.addAttribute("opcionTipoCon",opcionTipoCon);
        List<String> opcionRe = Arrays.asList("CITA PENDIENTE","CLIENTE CON RECLAMO EN INDECOPI O BAZ","CLIENTE FALLECIDO","CLIENTE PARA DEMANDAR","CLIENTE SOLVENTE","COMPROMISO INCUMPLIDO","COMPROMISO PENDIENTE CAMPO/TELEF","COMPROMISO PENDIENTE OFICINA","COMPROMISO PENDIENTE TOTAL","CONTESTA Y CORTA LA LLAMADA","CUENTA CANCELADA"
		,"MENSAJE A TERCERO","MENSAJE DE TEXTO","NUMERO EQUIVOCADO","POSIBLE ACUERDO DE PAGO","SE DEJO MENSAJE","SEGUIMIENTO PDP","VOLVER A LLAMAR","VOLVER A LLAMAR TITULAR/AVAL","VOLVER A LLAMAR TITULAR/AVAL - POSIBLE PAGO","VOLVER A LLAMAR","PAGO CONFIRMADO");
        modelo.addAttribute("opcionRe",opcionRe);
		List<String> opcionTipifi = Arrays.asList("CORRECTO","INCORRECTO");
		modelo.addAttribute("opcionTipificacion",opcionTipifi);
		List<String> opcionObs = Arrays.asList("CORRECTO","INCORRECTO");
		modelo.addAttribute("opcionObservaciones",opcionObs);
		List<String> opcioninfoDeu = Arrays.asList("COMPLETA","INCOMPLETA","ERRADA","N/A");
		modelo.addAttribute("opcionInfodeuda",opcioninfoDeu);
		List<String> opcionInfoCamp = Arrays.asList("ESCALONADO","DIRECTO","N/A");
		modelo.addAttribute("opcionInfoCamp",opcionInfoCamp);
		List<String> opcionTonov = Arrays.asList("CALIDO/TRANQUILO","PERSUASIVO / SUGESTIVO / SEGURO","AGRESIVO","APAGADO/LINEAL");
		modelo.addAttribute("opcionTonovoz",opcionTonov);
		List<String> opcionVoca = Arrays.asList("VOCALIZA","NO VOCALIZA","MULETILLAS(+3)","SILENCIOS","REGULAR");
		modelo.addAttribute("opcionVocalizacion",opcionVoca);
		List<String> opcionArgco = Arrays.asList("CONOCE","NO CONOCE","DUDA","REGULAR");
		modelo.addAttribute("opcionArgcono",opcionArgco);
		List<String> opcionActi = Arrays.asList("PROACTIVO","REACTIVO","INDIFERENTE","N/A");
		modelo.addAttribute("opcionActitud",opcionActi);				
		return "nuevoAuditoria";
	}
		
	@PostMapping("/guardarAudi")
	public String guardarAudi(@Valid Auditoria auditoria, BindingResult result, Model modelo, RedirectAttributes flash, SessionStatus status) {
		if(result.hasErrors()) {
			modelo.addAttribute("titulo", "Registro de Auditoria");
			return "nuevoAuditoria";
		}
		
		LocalDateTime fechaHoraActual = LocalDateTime.now();
	    Timestamp fechaActual = Timestamp.valueOf(fechaHoraActual);
	    
	    
	    auditoria.setFECHA(fechaActual);
	    
		String mensaje = (auditoria.getID() != null) ? "La Auditoria ha sido Editado con exito" : "Auditoria Registrada con Exito";
		serviceAuditoria.guardar(auditoria);
		status.setComplete();
		flash.addFlashAttribute("success", mensaje);
		return "redirect:/Menu";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleAudi(@PathVariable(value = "id") Long id, Map<String, Object> modelo, RedirectAttributes flash)  {
		Auditoria auditoria = serviceAuditoria.findOne(id);
		if(auditoria == null) {
			flash.addFlashAttribute("error", "La auditoría no existe en la base de datos");
			return "redirect:/Menu";
		}
		modelo.put("auditoria", auditoria);
		modelo.put("title", "Detalles de Auditoria");
		return "detalleAudi";		
	}
	
	@GetMapping("/edit/{id}")
	public String editarAudi(@PathVariable(value = "id") Long id, Model modelo, RedirectAttributes flash) {
	    Auditoria auditoria = null;
	    if (id > 0) {
	        auditoria = serviceAuditoria.findOne(id);
	        if (auditoria == null) {
	            flash.addFlashAttribute("error", "El ID no existe en la base de datos");
	            return "redirect:/Menu";
	        }
	    } else {
	        flash.addFlashAttribute("error", "El ID de la auditoria no puede ser cero");
	        return "redirect:/Menu";
	    }

	    modelo.addAttribute("auditoria", auditoria);
	    modelo.addAttribute("titulo", "Edición de Auditoria");
	    List<String> opcionTLL = Arrays.asList("Manual","Progresivo","Predictivo");
		modelo.addAttribute("opcionTipoLLamada",opcionTLL);
		List<String> opcionCali = Arrays.asList("YULEISY MIREYA SALCINES CARMEN", "JHOVANA KATHERIN ESPINOZA COCHACHI");
		modelo.addAttribute("opcionCalidad",opcionCali);
		List<String> opcionOF = Arrays.asList("JZG","ECL");
		modelo.addAttribute("opcionOficina",opcionOF);
		List<String> opcionMoti = Arrays.asList("SEGUIMIENTO DE LLAMADA","CONTACTO DIRECTO CON COMPROMISO DE PAGO","CONTACTO DIRECTO SIN COMPROMISO DE PAGO","INCUMPLIMIENTO DE PAGO","DERIVACIONES","CONTACTO INDIRECTO SIN COMPROMISO DE PAGO","CONTACTO INDIRECTO CON COMPROMISO DE PAGO");
		modelo.addAttribute("opcionMotivo",opcionMoti);
		List<String> opcionTipoCon = Arrays.asList("LLAMADAS SALIENTES CON CONTACTO","CLIENTE POR DERIVACION","INCUMPLIMIENTO DE PAGO","SEGUIMIENTO DE LLAMADA","LLAMADAS SALIENTES SIN CONTACTO","RECEPCION DE CLIENTES EN LLAMADAS");
        modelo.addAttribute("opcionTipoCon",opcionTipoCon);
         List<String> opcionRe = Arrays.asList("CITA PENDIENTE","CLIENTE CON RECLAMO EN INDECOPI O BAZ","CLIENTE FALLECIDO","CLIENTE PARA DEMANDAR","CLIENTE SOLVENTE","COMPROMISO INCUMPLIDO","COMPROMISO PENDIENTE CAMPO/TELEFONICO","COMPROMISO PENDIENTE OFICINA","COMPROMISO PENDIENTE TOTAL","CONTESTA Y CORTA LA LLAMADA","CUENTA CANCELADA"
		,"MENSAJE A TERCERO","MENSAJE DE TEXTO","NUMERO EQUIVOCADO","POSIBLE ACUERDO DE PAGO","SE DEJO MENSAJE","SEGUIMIENTO PDP","VOLVER A LLAMAR", "VOLVER A LLAMAR TITULAR/AVAL","VOLVER A LLAMAR TITULAR/AVAL - POSIBLE PAGO","VOLVER A LLAMAR","PAGO CONFIRMADO");
        modelo.addAttribute("opcionRe",opcionRe);
		List<String> opcionTipifi = Arrays.asList("CORRECTO","INCORRECTO");
		modelo.addAttribute("opcionTipificacion",opcionTipifi);
		List<String> opcionObs = Arrays.asList("CORRECTO","INCORRECTO");
		modelo.addAttribute("opcionObservaciones",opcionObs);
		List<String> opcioninfoDeu = Arrays.asList("COMPLETA","INCOMPLETA","ERRADA","N/A");
		modelo.addAttribute("opcionInfodeuda",opcioninfoDeu);
		List<String> opcionInfoCamp = Arrays.asList("ESCALONADO","DIRECTO","N/A");
		modelo.addAttribute("opcionInfoCamp",opcionInfoCamp);
		List<String> opcionTonov = Arrays.asList("CALIDO/TRANQUILO","PERSUASIVO / SUGESTIVO / SEGURO","AGRESIVO","APAGADO/LINEAL");
		modelo.addAttribute("opcionTonovoz",opcionTonov);
		List<String> opcionVoca = Arrays.asList("VOCALIZA","NO VOCALIZA","MULETILLAS(+3)","SILENCIOS","REGULAR");
		modelo.addAttribute("opcionVocalizacion",opcionVoca);
		List<String> opcionArgco = Arrays.asList("CONOCE","NO CONOCE","DUDA","REGULAR");
		modelo.addAttribute("opcionArgcono",opcionArgco);
		List<String> opcionActi = Arrays.asList("PROACTIVO","REACTIVO","INDIFERENTE","N/A");
		modelo.addAttribute("opcionActitud",opcionActi);
	    return "editAuditoria";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarAudi(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if(id > 0) {
			serviceAuditoria.eliminar(id);
			flash.addFlashAttribute("success", "Cliente Eliminado con exito");
		}
		return "redirect:/Menu";
	}
	
	@GetMapping("/expExcel")
	public void exportarListadoDeAuditoriasEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Auditoria_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Auditoria> auditorias = serviceAuditoria.listarTodos();
		
		AuditoriaExporterExcelTabla exporter = new AuditoriaExporterExcelTabla(auditorias);
		exporter.exportar(response);		
	}	

	@GetMapping("/expPDF/{id}")
    public void exportarAuditoriaEnPDF(@PathVariable("id") Long id, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Auditoria" + id + "_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        Optional<Auditoria> auditoriaOptional = serviceAuditoria.buscarId(id);
        List<Auditoria> auditorias = new ArrayList<>();
        auditoriaOptional.ifPresent(auditorias::add);

        AuditoriaExporterPDF exporter = new AuditoriaExporterPDF(auditorias, id);
        exporter.exportar(response);
    }
	
}


