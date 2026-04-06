package PhelipeProject.EncurtadorDeUrl.repository;

import PhelipeProject.EncurtadorDeUrl.entity.EntityUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositoryUrl extends JpaRepository<EntityUrl, UUID> {
    Optional<EntityUrl> findByUrl(String url);
}
