package com.fullexemplo.projetofullexemplo.services;

import com.fullexemplo.projetofullexemplo.repository.OSRepository;
import org.springframework.stereotype.Service;

@Service
public class OsService {

    OSRepository osRepository;

    public OsService(OSRepository osRepository) {
        this.osRepository = osRepository;
    }

}
