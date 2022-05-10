package com.ibm.academia.universidadrest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
//@Table(name = "profesores", schema = "universidad")
@Table(name = "profesores")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Profesor extends Persona {

    @Column(name = "sueldo")
    private BigDecimal sueldo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "profesor_carrera", schema = "universidad",      // nombre de la tabla y schema al que pertenece
            joinColumns = @JoinColumn(name = "profesor_id"),        // columna principal de la tabla
            inverseJoinColumns = @JoinColumn(name = "carrera_id")   // con quien se va a crear la relacion
    )
    private Set<Carrera> carreras;

    public Profesor(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + "Profesor{" +
                "sueldo=" + sueldo +
                '}';
    }

    private static final long serialVersionUID = -1535862203910460886L;
}
