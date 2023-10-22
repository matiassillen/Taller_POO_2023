/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nomUsuario;
    private String passw;
    @ManyToMany
    @JoinColumn(name="id_rol")
    private List<Rol> rol; 
    @OneToOne(mappedBy="usu")
    private FuncionarioGeneral funcionarioGeneral;

    public Usuario() {
    }

    public Usuario(long id, String nomUsuario, String passw, List<Rol> rol, FuncionarioGeneral funcionarioGeneral) {
        this.id = id;
        this.nomUsuario = nomUsuario;
        this.passw = passw;
        this.rol = rol;
        this.funcionarioGeneral = funcionarioGeneral;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public List<Rol> getRol() {
        return rol;
    }

    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }

    public FuncionarioGeneral getFuncionarioGeneral() {
        return funcionarioGeneral;
    }

    public void setFuncionarioGeneral(FuncionarioGeneral funcionarioGeneral) {
        this.funcionarioGeneral = funcionarioGeneral;
    }
     
}
