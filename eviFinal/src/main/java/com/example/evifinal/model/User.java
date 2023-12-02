package com.example.evifinal.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.example.evifinal.IMCCalculator;

@Entity
@Table (name="personas")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private double estatura;
    private double peso;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha;

    @Column(name = "IMC")
    private double IMC;

    @Column(name = "categoria_imc")
    private String categoriaIMC;

    @Column(name="Username")
    private String Username;

    @Column(name="contraseña")
    private String contraseña;

     public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public String getUsername() { return Username; }

    public void setUsername(String email) { this.Username = Username;}

    public String getContraseña() {return contraseña;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}

    @PrePersist
    protected void onCreate() {
        IMC = IMCCalculator.calcularIMC(peso, estatura);
        categoriaIMC = IMCCalculator.obtenerCategoriaIMC(IMC);
        fecha = LocalDateTime.now().withSecond(0).withNano(0);
    }

}
