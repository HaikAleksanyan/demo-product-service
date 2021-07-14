package am.demo.product.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category_tbl", schema = "v1")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class Category extends AuditEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_category_id", referencedColumnName = "id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
    private Set<Category> subCategories = new HashSet<>();

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    public Category addSubCategory(String categoryName) {
        Category sub = new Category();
        sub.setName(categoryName);
        this.subCategories.add(sub);
        sub.setParentCategory(this);
        return sub;
    }

    public void moveCategory(Category newParent) {
        this.getParentCategory().getSubCategories().remove(this);
        this.setParentCategory(newParent);
        newParent.getSubCategories().add(this);
    }
}
