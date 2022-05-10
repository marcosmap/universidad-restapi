package com.ibm.academia.universidadrest.entities;

import com.ibm.academia.universidadrest.enums.TipoEmpleado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Entity
//@Table(name = "empleados", schema = "universidad")
@Table(name = "empleados")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Empleado extends Persona {

    @Column(name = "salario")
    private BigDecimal salario;

    @Column(name = "tipo_empleado")
    @Enumerated(EnumType.STRING)
    private TipoEmpleado tipoEmpleado;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
    private Pabellon pabellon;

    public Empleado(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal salario, TipoEmpleado tipoEmpleado) {
        super(id, nombre, apellido, dni, direccion);
        this.salario = salario;
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEmpleado{" +
                "salario=" + salario +
                ", tipoEmpleado=" + tipoEmpleado +
                '}';
    }

    private static final long serialVersionUID = 3996930074987708137L;
}
