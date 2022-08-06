package site.itseasy.jpabook1.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.itseasy.jpabook1.domain.Category;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private final EntityManager em;

    public Category save(Category category) {
        if (category.getId() != null) {
            em.persist(category);
        } else {
            em.merge(category);
        }
        return category;
    }

    public List<Category> findAll() {
        return em.createQuery("select c from Category c", Category.class)
                .getResultList();
    }

    public Category findOne(Long id) {
        return em.find(Category.class, id);
    }
}
