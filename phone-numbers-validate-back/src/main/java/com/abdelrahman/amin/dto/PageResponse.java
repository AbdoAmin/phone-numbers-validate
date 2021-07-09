package com.abdelrahman.amin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {

    private T content;

    private Integer page;

    private Integer totalPages;

    private Long totalElements;

}
