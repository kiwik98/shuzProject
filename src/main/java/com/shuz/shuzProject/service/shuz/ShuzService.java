package com.shuz.shuzProject.service.shuz;

import com.shuz.shuzProject.domain.shuz.Shuz;
import com.shuz.shuzProject.domain.shuz.ShuzRepository;
import com.shuz.shuzProject.web.dto.ShuzListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShuzService {

    private final ShuzRepository shuzRepository;

    public List<ShuzListResponseDto> findByShoesTypeAll(char shoes_type) {
        return shuzRepository.findByShoesTypeAll(shoes_type).stream()
                .map(ShuzListResponseDto::new)	// {2}
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ShuzListResponseDto> findAllDesc() {
        return shuzRepository.findAllDesc().stream()
                .map(ShuzListResponseDto::new)	// {2}
                .collect(Collectors.toList());
    }
}
