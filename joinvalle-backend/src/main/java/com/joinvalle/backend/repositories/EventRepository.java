package com.joinvalle.backend.repositories;

import com.joinvalle.backend.models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<EventModel, Long> {

    // Search events by category name (case-insensitive)
    List<EventModel> findByCategoriaNomeContainingIgnoreCase(String categoria);

    // Search events by title keyword (case-insensitive)
    List<EventModel> findByTituloContainingIgnoreCase(String keyword);

    // Get all draft events from a specific user
    List<EventModel> findByRascunhoTrueAndCreatorUserId(Long userId);

    // Get all events from a specific user, sorted by start date
    List<EventModel> findByCreatorUserIdOrderByDataInicioDesc(Long userId);

    // For admin: list events that are pending approval
    List<EventModel> findByAprovedFalseAndRejectedFalse();

    // For public display: only approved events
    List<EventModel> findByAprovadoTrue();

    // For search: approved events by title keyword
    List<EventModel> findByTituloContainingIgnoreCaseAndAprovadoTrue(String keyword);

    // (Optional) For statistics: count how many events are approved
    Long countByAprovadoTrue();

}
