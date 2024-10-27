package org.example.productservice.member.category.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetSubCategoriesResponseVo {
    private String categoryName;
    private String categoryUuid;

    @Builder
    public GetSubCategoriesResponseVo(String categoryName, String categoryUuid) {
        this.categoryName = categoryName;
        this.categoryUuid = categoryUuid;
    }
}

