/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasDuaBelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Lyra Geyska
 */
@Entity
@Table(name = "matakuliah")
@NamedQueries({
    @NamedQuery(name = "Matakuliah.findAll", query = "SELECT m FROM Matakuliah m"),
    @NamedQuery(name = "Matakuliah.findByKodemk", query = "SELECT m FROM Matakuliah m WHERE m.kodemk = :kodemk"),
    @NamedQuery(name = "Matakuliah.findBySks", query = "SELECT m FROM Matakuliah m WHERE m.sks = :sks"),
    @NamedQuery(name = "Matakuliah.findByNamamk", query = "SELECT m FROM Matakuliah m WHERE m.namamk = :namamk"),
    @NamedQuery(name = "Matakuliah.findBySemesterajar", query = "SELECT m FROM Matakuliah m WHERE m.semesterajar = :semesterajar")})
public class Matakuliah implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kodemk")
    private String kodemk;
    @Column(name = "sks")
    private Integer sks;
    @Column(name = "namamk")
    private String namamk;
    @Column(name = "semesterajar")
    private Integer semesterajar;

    public Matakuliah() {
    }

    public Matakuliah(String kodemk) {
        this.kodemk = kodemk;
    }

    public String getKodemk() {
        return kodemk;
    }

    public void setKodemk(String kodemk) {
        this.kodemk = kodemk;
    }

    public Integer getSks() {
        return sks;
    }

    public void setSks(Integer sks) {
        this.sks = sks;
    }

    public String getNamamk() {
        return namamk;
    }

    public void setNamamk(String namamk) {
        this.namamk = namamk;
    }

    public Integer getSemesterajar() {
        return semesterajar;
    }

    public void setSemesterajar(Integer semesterajar) {
        this.semesterajar = semesterajar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodemk != null ? kodemk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matakuliah)) {
            return false;
        }
        Matakuliah other = (Matakuliah) object;
        if ((this.kodemk == null && other.kodemk != null) || (this.kodemk != null && !this.kodemk.equals(other.kodemk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TugasDuaBelas.Matakuliah[ kodemk=" + kodemk + " ]";
    }
    
}
