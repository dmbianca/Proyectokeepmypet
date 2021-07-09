package com.eoi.modelo;
public class Usuarios {
    private int UsuId;
    private String UsuNombre;
    private String UsuApellido;
    private String UsuNacimiento;
    private int UsuAlta;
    private String UsuMail;
    private String UsuPass;
    private String UsuRol;
    private String UsuCiudad;
    private String UsuDNI;
    private int UsuTelf;

    public Usuarios() {
        super();

    }
    public Usuarios(String UsuNombre, String UsuApellido, String UsuNacimiento, String UsuMail, String UsuPass, String UsuCiudad, String UsuDNI, int UsuTelf) {
    	super();
  
        this.UsuNombre = UsuNombre;
        this.UsuApellido = UsuApellido;
        this.UsuNacimiento = UsuNacimiento;
        this.UsuMail = UsuMail;
        this.UsuPass = UsuPass;
        this.UsuCiudad = UsuCiudad;
        this.UsuDNI = UsuDNI;
        this.UsuTelf = UsuTelf;
    }
    
    
    public Usuarios(int usuId, String usuNombre, String usuApellido, String usuNacimiento, int usuAlta, String usuMail,
            String usuPass, String usuRol, String usuCiudad, String usuDNI, int UsuTelf) {
        super();
        UsuId = usuId;
        UsuNombre = usuNombre;
        UsuApellido = usuApellido;
        UsuNacimiento = usuNacimiento;
        UsuAlta = usuAlta;
        UsuMail = usuMail;
        UsuPass = usuPass;
        UsuRol = usuRol;
        UsuCiudad = usuCiudad;
        UsuDNI = usuDNI;
        UsuTelf = UsuTelf;
    }
    public Usuarios(int UsuId, String UsuNombre, String UsuApellido, String UsuNacimiento, String UsuCiudad, String UsuDNI, String UsuMail,
			int UsuTelf) {
    	 UsuId = UsuId;
         UsuNombre = UsuNombre;
         UsuApellido = UsuApellido;
         UsuNacimiento = UsuNacimiento;
         UsuCiudad = UsuCiudad;
         UsuDNI = UsuDNI;
         UsuMail = UsuMail;
         UsuTelf = UsuTelf;
	}
	public int getUsuTelf() {
        return UsuTelf;
    }
    public void setUsuTelf(int usuTelf) {
        UsuTelf = usuTelf;
    }
    public int getUsuId() {
        return UsuId;
    }
    public void setUsuId(int usuId) {
        UsuId = usuId;
    }
    public String getUsuNombre() {
        return UsuNombre;
    }
    public void setUsuNombre(String usuNombre) {
        UsuNombre = usuNombre;
    }
    public String getUsuApellido() {
        return UsuApellido;
    }
    public void setUsuApellido(String usuApellido) {
        UsuApellido = usuApellido;
    }
    public String getUsuNacimiento() {
        return UsuNacimiento;
    }
    public void setUsuNacimiento(String usuNacimiento) {
        UsuNacimiento = usuNacimiento;
    }
    public int getUsuAlta() {
        return UsuAlta;
    }
    public void setUsuAlta(int usuAlta) {
        UsuAlta = usuAlta;
    }
    public String getUsuMail() {
        return UsuMail;
    }
    public void setUsuMail(String usuMail) {
        UsuMail = usuMail;
    }
    public String getUsuPass() {
        return UsuPass;
    }
    public void setUsuPass(String usuPass) {
        UsuPass = usuPass;
    }
    public String getUsuRol() {
        return UsuRol;
    }
    public void setUsuRol(String usuRol) {
        UsuRol = usuRol;
    }
    public String getUsuCiudad() {
        return UsuCiudad;
    }
    public void setUsuCiudad(String usuCiudad) {
        UsuCiudad = usuCiudad;
    }
    public String getUsuDNI() {
        return UsuDNI;
    }
    public void setUsuDNI(String usuDNI) {
        UsuDNI = usuDNI;
    }
    @Override
    public String toString() {
        return "Usuarios [UsuId=" + UsuId + ", UsuNombre=" + UsuNombre + ", UsuApellido=" + UsuApellido
                + ", UsuNacimiento=" + UsuNacimiento + ", UsuAlta=" + UsuAlta + ", UsuMail=" + UsuMail + ", UsuPass="
                + UsuPass + ", UsuRol=" + UsuRol + ", UsuCiudad=" + UsuCiudad + ", UsuDNI=" + UsuDNI + "]";
    }
    
}