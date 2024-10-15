package gm.rh.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmpleadoDTO {
    private Integer id;
    private String nombre;
    private Double salario;
    private Boolean estado;
    private String nombreDepartamento;

    // Constructor
    public EmpleadoDTO(Integer id, String nombre, Double salario, Boolean estado, String nombreDepartamento) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.estado = estado;
        this.nombreDepartamento = nombreDepartamento;
    }

}
