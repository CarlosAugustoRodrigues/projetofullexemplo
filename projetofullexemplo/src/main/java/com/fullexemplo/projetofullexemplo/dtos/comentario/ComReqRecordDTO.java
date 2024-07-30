package com.fullexemplo.projetofullexemplo.dtos.comentario;

import com.fullexemplo.projetofullexemplo.entity.Colaborador;
import com.fullexemplo.projetofullexemplo.entity.OS;

import java.time.LocalDate;

public record ComReqRecordDTO(LocalDate data_comentario, String comentario, OS os, Colaborador colaborador) {
}
