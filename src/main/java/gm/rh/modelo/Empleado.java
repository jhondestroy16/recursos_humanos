package gm.rh.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "departamento")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Double salario;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "departamento", referencedColumnName = "id", insertable = true, updatable = true)
    @JsonBackReference
    private Departamento departamento;
}
