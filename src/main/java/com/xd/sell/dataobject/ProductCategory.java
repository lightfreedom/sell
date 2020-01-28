package com.xd.sell.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: k
 * @Date: 2020/1/26 10:22
 * @Description:类目
 */
// 对于类名与表名不统一的情况，使用@Table（name="xxx"）注解。
// 对于表名与字段名的下划线_x，直接使用驼峰大写代替，系统可以自动匹配。
@Entity
@Data //性能不受影响
@DynamicUpdate   // 时间动态更新
public class ProductCategory {
    // 类目id.
    @Id  //主键
    @GeneratedValue  // 自增
    private Integer categoryId;
    // 类目名字.
    private String categoryName;
    // 类名编号.
    private Integer categoryType;

    public ProductCategory( String categoryName,Integer categoryType) {
        this.categoryName=categoryName;
        this.categoryType=categoryType;
    }

    public ProductCategory() {
    }
}
