package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
//
//@SqlResultSetMapping(
//        name="findres",
//        classes = {
//                @ConstructorResult(targetClass =ClothesResult.class,
//                        columns = { @ColumnResult( name = "id", type = Integer.class),
//                                @ColumnResult( name = "price", type = Integer.class),
//                                @ColumnResult( name = "styles", type = String.class),
//                                @ColumnResult( name = "colors", type = String.class),
//                                @ColumnResult( name = "materials", type = String.class),
//                                @ColumnResult( name = "sex", type = String.class),
//                                @ColumnResult( name = "size", type = String.class),
//                                @ColumnResult( name = "clothes", type = String.class),
//                                @ColumnResult( name = "state", type = String.class),
//                                @ColumnResult( name = "remarks", type = String.class),
//                                @ColumnResult( name = "make", type = String.class),
//                })
//        }
//)
@Data
public class ClothesResult {
    private Integer id;
    private Integer price;
    private String styles;
    private String colors;
    private String materials;
    private String sex;
    private String size;
    private String clothes;
    private String state;
    private String remarks;
    private String make;
}
