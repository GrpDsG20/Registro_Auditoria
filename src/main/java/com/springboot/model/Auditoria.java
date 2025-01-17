package com.springboot.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "auditoria")
public class Auditoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long ID;
	
	@Column
	private String TIPO_LLAMADA;
	
	@Column
	private String TIEMPO_LLAMADA;
	
	@Column
	private String CALIDAD;
	
	@Column
	private Timestamp FECHA;
	
	@Column
	private String ASESOR;
	
	@Column
	private String CARTERA;
	
	@Column
	private String COORDINADOR;
	
	@Column
	private String OFICINA;
	
	@Column
	private String NOMBRE_DEL_CLIENTE;
	
	@Column
	private String MOTIVO_DE_LLAMADA;
	
	@Column
	private String TIPO_DE_CONTACTO;
	
	@Column
	private String RESULTADO;
	
	@Column
	private String TIPIFICACION;
	
	@Column
	private String CAMPO_DE_OBSERVACIONES;
	
	@Column
	private String P1;
	
	@Column 
	private String P2;
	
	@Column 
	private String P3;
	
	@Column 
	private String P4;
	
	@Column 
	private String P5;
	
	@Column 
	private String P6;
	
	@Column 
	private String P7;
	
	@Column 
	private String P8;
	
	@Column 
	private String P9;
	
	@Column 
	private String P10;
	
	@Column 
	private String P11;
	
	@Column 
	private String P12;
	
	@Column 
	private String P13;
	
	@Column 
	private String P14;
	
	@Column 
	private String P15;
	
	@Column 
	private String P16;
	
	@Column 
	private String P17;
	
	@Column 
	private String P18;
	
	@Column 
	private String P19;
	
	@Column 
	private String P20;
	
	@Column 
	private String P21;
	
	@Column
	private String DETALLE_DE_LLAMADA;
	
	@Column
	private String FEEDBACK_1;
	
	@Column
	private String FEEDBACK_2;
	
	@Column
	private String AUDIO;
	
	
	

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		this.ID = iD;
	}

	public String getTIPO_LLAMADA() {
		return TIPO_LLAMADA;
	}

	public void setTIPO_LLAMADA(String tIPO_LLAMADA) {
		TIPO_LLAMADA = tIPO_LLAMADA;
	}

	public String getTIEMPO_LLAMADA() {
		return TIEMPO_LLAMADA;
	}

	public void setTIEMPO_LLAMADA(String tIEMPO_LLAMADA) {
		TIEMPO_LLAMADA = tIEMPO_LLAMADA;
	}

	public String getCALIDAD() {
		return CALIDAD;
	}

	public void setCALIDAD(String cALIDAD) {
		CALIDAD = cALIDAD;
	}
	
	public Timestamp getFECHA() {
		return FECHA;
	}

	public void setFECHA(Timestamp fECHA) {
		this.FECHA = fECHA;
	}

	public String getASESOR() {
		return ASESOR;
	}

	public void setASESOR(String aSESOR) {
		ASESOR = aSESOR;
	}

	public String getCARTERA() {
		return CARTERA;
	}

	public void setCARTERA(String cARTERA) {
		CARTERA = cARTERA;
	}

	public String getCOORDINADOR() {
		return COORDINADOR;
	}

	public void setCOORDINADOR(String cOORDINADOR) {
		COORDINADOR = cOORDINADOR;
	}

	public String getOFICINA() {
		return OFICINA;
	}

	public void setOFICINA(String oFICINA) {
		OFICINA = oFICINA;
	}

	public String getNOMBRE_DEL_CLIENTE() {
		return NOMBRE_DEL_CLIENTE;
	}

	public void setNOMBRE_DEL_CLIENTE(String nOMBRE_DEL_CLIENTE) {
		NOMBRE_DEL_CLIENTE = nOMBRE_DEL_CLIENTE;
	}

	public String getMOTIVO_DE_LLAMADA() {
		return MOTIVO_DE_LLAMADA;
	}

	public void setMOTIVO_DE_LLAMADA(String mOTIVO_DE_LLAMADA) {
		MOTIVO_DE_LLAMADA = mOTIVO_DE_LLAMADA;
	}

	public String getTIPO_DE_CONTACTO() {
		return TIPO_DE_CONTACTO;
	}

	public void setTIPO_DE_CONTACTO(String tIPO_DE_CONTACTO) {
		TIPO_DE_CONTACTO = tIPO_DE_CONTACTO;
	}

	public String getRESULTADO() {
		return RESULTADO;
	}

	public void setRESULTADO(String rESULTADO) {
		RESULTADO = rESULTADO;
	}

	public String getTIPIFICACION() {
		return TIPIFICACION;
	}

	public void setTIPIFICACION(String tIPIFICACION) {
		TIPIFICACION = tIPIFICACION;
	}

	public String getCAMPO_DE_OBSERVACIONES() {
		return CAMPO_DE_OBSERVACIONES;
	}

	public void setCAMPO_DE_OBSERVACIONES(String cAMPO_DE_OBSERVACIONES) {
		CAMPO_DE_OBSERVACIONES = cAMPO_DE_OBSERVACIONES;
	}

	public String getP1() {
		return P1;
	}

	public void setP1(String p1) {
		P1 = p1;
	}

	public String getP2() {
		return P2;
	}

	public void setP2(String p2) {
		P2 = p2;
	}

	public String getP3() {
		return P3;
	}

	public void setP3(String p3) {
		P3 = p3;
	}

	public String getP4() {
		return P4;
	}

	public void setP4(String p4) {
		P4 = p4;
	}

	public String getP5() {
		return P5;
	}

	public void setP5(String p5) {
		P5 = p5;
	}

	public String getP6() {
		return P6;
	}

	public void setP6(String p6) {
		P6 = p6;
	}

	public String getP7() {
		return P7;
	}

	public void setP7(String p7) {
		P7 = p7;
	}

	public String getP8() {
		return P8;
	}

	public void setP8(String p8) {
		P8 = p8;
	}

	public String getP9() {
		return P9;
	}

	public void setP9(String p9) {
		P9 = p9;
	}

	public String getP10() {
		return P10;
	}

	public void setP10(String p10) {
		P10 = p10;
	}

	public String getP11() {
		return P11;
	}

	public void setP11(String p11) {
		P11 = p11;
	}

	public String getP12() {
		return P12;
	}

	public void setP12(String p12) {
		P12 = p12;
	}

	public String getP13() {
		return P13;
	}

	public void setP13(String p13) {
		P13 = p13;
	}

	public String getP14() {
		return P14;
	}

	public void setP14(String p14) {
		P14 = p14;
	}

	public String getP15() {
		return P15;
	}

	public void setP15(String p15) {
		P15 = p15;
	}

	public String getP16() {
		return P16;
	}

	public void setP16(String p16) {
		P16 = p16;
	}

	public String getP17() {
		return P17;
	}

	public void setP17(String p17) {
		P17 = p17;
	}

	public String getP18() {
		return P18;
	}

	public void setP18(String p18) {
		P18 = p18;
	}

	public String getP19() {
		return P19;
	}

	public void setP19(String p19) {
		P19 = p19;
	}

	public String getP20() {
		return P20;
	}

	public void setP20(String p20) {
		P20 = p20;
	}

	public String getP21() {
		return P21;
	}

	public void setP21(String p21) {
		P21 = p21;
	}

	public String getDETALLE_DE_LLAMADA() {
		return DETALLE_DE_LLAMADA;
	}

	public void setDETALLE_DE_LLAMADA(String dETALLE_DE_LLAMADA) {
		DETALLE_DE_LLAMADA = dETALLE_DE_LLAMADA;
	}

	public String getFEEDBACK_1() {
		return FEEDBACK_1;
	}

	public void setFEEDBACK_1(String fEEDBACK_1) {
		FEEDBACK_1 = fEEDBACK_1;
	}

	public String getFEEDBACK_2() {
		return FEEDBACK_2;
	}

	public void setFEEDBACK_2(String fEEDBACK_2) {
		FEEDBACK_2 = fEEDBACK_2;
	}

	public String getAUDIO() {
		return AUDIO;
	}

	public void setAUDIO(String aUDIO) {
		AUDIO = aUDIO;
	}
		
}
