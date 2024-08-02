package com.fullexemplo.projetofullexemplo.services.colaborador;

import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColReqRecordDTO;
import com.fullexemplo.projetofullexemplo.dtos.colaborador.ColResRecordDTO;
import com.fullexemplo.projetofullexemplo.entity.colaborador.Colaborador;
import com.fullexemplo.projetofullexemplo.entity.os.OS;
import com.fullexemplo.projetofullexemplo.repository.ColaboradorRepository;
import com.fullexemplo.projetofullexemplo.repository.ComentarioRepository;
import com.fullexemplo.projetofullexemplo.repository.OSRepository;
import com.fullexemplo.projetofullexemplo.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ColServices {


    ColaboradorRepository colaboradorRepository;
    UsuarioRepository usuarioRepository;
    ComentarioRepository comentarioRepository;
    OSRepository osRepository;

    public ColServices(
            ColaboradorRepository colaboradorRepository,
            UsuarioRepository usuarioRepository,
            ComentarioRepository comentarioRepository,
            OSRepository osRepository
    ) {
        this.colaboradorRepository = colaboradorRepository;
        this.usuarioRepository = usuarioRepository;
        this.comentarioRepository = comentarioRepository;
        this.osRepository = osRepository;
    }

    public ResponseEntity<List<ColResRecordDTO>> readAll() {
        List<ColResRecordDTO> listaCol = colaboradorRepository
                .findAll()
                .stream()
                .map(ColResRecordDTO::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(listaCol);
    }

    public ResponseEntity<Colaborador> create(ColReqRecordDTO data) {
        var colaborador = new Colaborador(data);

        colaboradorRepository.save(colaborador);

        return ResponseEntity.status(HttpStatus.CREATED).body(colaborador);
    }

    public ResponseEntity<Object> update(UUID id, ColReqRecordDTO data) {
        Optional<Colaborador> col0 = colaboradorRepository.findById(id);

        if (col0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("COLABORADOR NÃO ENCONTRADO!");
        }

        var colaborador = col0.get();

        colaborador.setNome(data.nome());
        colaborador.setCargo(data.cargo());
        colaborador.setSetor(data.setor());

        colaboradorRepository.save(colaborador);

        return ResponseEntity.status(HttpStatus.OK).body(colaborador);
    }

    public ResponseEntity<Object> delete(UUID id) {
       Optional<Colaborador> col0 = colaboradorRepository.findById(id);

       if (col0.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("COLABORADOR NÃO ENCONTRADO!");
       }

       colaboradorRepository.delete(col0.get());

       return ResponseEntity.status(HttpStatus.OK).body("COLABORADOR EXCLUIDO COM SUCESSO!");
    }
}
