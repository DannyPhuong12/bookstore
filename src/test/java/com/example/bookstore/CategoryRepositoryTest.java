package com.example.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void createCategory() {
        Category category = new Category("Sci-Fi");
        categoryRepository.save(category);

        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    void deleteCategory() {
        Category category = categoryRepository.save(new Category("Comic"));
        Long id = category.getCategoryid();

        categoryRepository.deleteById(id);

        assertThat(categoryRepository.findById(id)).isEmpty();
    }

    @Test
    void findByNameShouldReturnCategory() {
        categoryRepository.save(new Category("Fantasy"));

        List<Category> categories = categoryRepository.findByName("Fantasy");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
    }
}