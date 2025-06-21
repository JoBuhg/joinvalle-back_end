package com.joinvalle.backend.services;

import com.joinvalle.backend.models.MapPointModel;
import com.joinvalle.backend.repositories.MapPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapPointService {

    @Autowired
    private MapPointRepository mapPointRepository;

    public List<MapPointModel> getApprovedPoints() {
        return mapPointRepository.findByApprovedTrue();
    }

    public Optional<MapPointModel> getById(Long id) {
        return mapPointRepository.findById(id);
    }

    public MapPointModel create(MapPointModel point) {
        point.setApproved(false); // Must be reviewed
        return mapPointRepository.save(point);
    }

    public Optional<MapPointModel> update(Long id, MapPointModel updated) {
        return mapPointRepository.findById(id).map(existing -> {
            existing.setTitle(updated.getTitle());
            existing.setDescription(updated.getDescription());
            existing.setLatitude(updated.getLatitude());
            existing.setLongitude(updated.getLongitude());
            existing.setType(updated.getType());
            existing.setApproved(false); // Reapproval required
            return mapPointRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (!mapPointRepository.existsById(id)) return false;
        mapPointRepository.deleteById(id);
        return true;
    }
}
