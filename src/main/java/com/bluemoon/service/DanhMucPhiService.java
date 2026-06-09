package com.bluemoon.service;

import com.bluemoon.model.DanhMucPhi;
import com.bluemoon.repository.DanhMucPhiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DanhMucPhiService {
    private final DanhMucPhiRepository repository;

    public List<DanhMucPhi> findAll() {
        return repository.findAll();
    }
}
