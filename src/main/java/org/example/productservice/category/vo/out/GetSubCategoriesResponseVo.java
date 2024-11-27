package org.example.productservice.category.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GetSubCategoriesResponseVo {
    private String categoryName;
    private String categoryUuid;
}

