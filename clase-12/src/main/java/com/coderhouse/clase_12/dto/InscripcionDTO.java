package com.coderhouse.clase_12.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InscripcionDTO {
    private Long alumnoId;
    private List<Long> cursosId;
}
