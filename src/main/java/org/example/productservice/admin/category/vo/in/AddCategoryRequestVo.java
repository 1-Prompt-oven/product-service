package org.example.productservice.admin.category.vo.in;

import org.example.productservice.admin.category.dto.in.AddCategoryRequestDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddCategoryRequestVo {
    private String categoryName;
    private String parentCategoryUuid;

    @Builder
    public AddCategoryRequestDto toDto() {
        return AddCategoryRequestDto.builder()
                .categoryName(categoryName)
                .parentCategoryUuid(parentCategoryUuid)
                .build();
    }
}
