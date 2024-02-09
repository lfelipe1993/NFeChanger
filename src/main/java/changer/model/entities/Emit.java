package changer.model.entities;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Emit {
	
	@XStreamAsAttribute
	String cCNPJ = "";
	@XStreamAsAttribute
	String xNome = "";
	
	//enderEmit
	@XStreamAsAttribute
	String xFant = "";
	@XStreamAsAttribute
	String xLgr = "";
	@XStreamAsAttribute
	String nNro = "";
	@XStreamAsAttribute
    String xCpl = "";
	@XStreamAsAttribute
    String xBairro = "";
	@XStreamAsAttribute
    String cMun = "";
	@XStreamAsAttribute
    String xMun = "";
	@XStreamAsAttribute
    String UF = "";
	@XStreamAsAttribute
    String CEP = "";
	@XStreamAsAttribute
    String cPais = "";
	@XStreamAsAttribute
    String xPais = "";
	@XStreamAsAttribute
    String fFone = "";
	
	@XStreamAsAttribute
    String iIE = "";
	@XStreamAsAttribute
    String cCRT = "";
    
    
	public String getcCNPJ() {
		return cCNPJ;
	}
	public void setcCNPJ(String cCNPJ) {
		this.cCNPJ = cCNPJ;
	}
	public String getxNome() {
		return xNome;
	}
	public void setxNome(String xNome) {
		this.xNome = xNome;
	}
	public String getxFant() {
		return xFant;
	}
	public void setxFant(String xFant) {
		this.xFant = xFant;
	}
	public String getxLgr() {
		return xLgr;
	}
	public void setxLgr(String xLgr) {
		this.xLgr = xLgr;
	}
	public String getnNro() {
		return nNro;
	}
	public void setnNro(String nNro) {
		this.nNro = nNro;
	}
	public String getxCpl() {
		return xCpl;
	}
	public void setxCpl(String xCpl) {
		this.xCpl = xCpl;
	}
	public String getxBairro() {
		return xBairro;
	}
	public void setxBairro(String xBairro) {
		this.xBairro = xBairro;
	}
	public String getcMun() {
		return cMun;
	}
	public void setcMun(String cMun) {
		this.cMun = cMun;
	}
	public String getxMun() {
		return xMun;
	}
	public void setxMun(String xMun) {
		this.xMun = xMun;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getcPais() {
		return cPais;
	}
	public void setcPais(String cPais) {
		this.cPais = cPais;
	}
	public String getxPais() {
		return xPais;
	}
	public void setxPais(String xPais) {
		this.xPais = xPais;
	}
	public String getfFone() {
		return fFone;
	}
	public void setfFone(String fFone) {
		this.fFone = fFone;
	}
	public String getiIE() {
		return iIE;
	}
	public void setiIE(String iIE) {
		this.iIE = iIE;
	}
	public String getcCRT() {
		return cCRT;
	}
	public void setcCRT(String cCRT) {
		this.cCRT = cCRT;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emit [cCNPJ=");
		builder.append(cCNPJ);
		builder.append(", xNome=");
		builder.append(xNome);
		builder.append(", xFant=");
		builder.append(xFant);
		builder.append(", xLgr=");
		builder.append(xLgr);
		builder.append(", nNro=");
		builder.append(nNro);
		builder.append(", xCpl=");
		builder.append(xCpl);
		builder.append(", xBairro=");
		builder.append(xBairro);
		builder.append(", cMun=");
		builder.append(cMun);
		builder.append(", xMun=");
		builder.append(xMun);
		builder.append(", UF=");
		builder.append(UF);
		builder.append(", CEP=");
		builder.append(CEP);
		builder.append(", cPais=");
		builder.append(cPais);
		builder.append(", xPais=");
		builder.append(xPais);
		builder.append(", fFone=");
		builder.append(fFone);
		builder.append(", iIE=");
		builder.append(iIE);
		builder.append(", cCRT=");
		builder.append(cCRT);
		builder.append("]");
		return builder.toString();
	}
    
    

}
