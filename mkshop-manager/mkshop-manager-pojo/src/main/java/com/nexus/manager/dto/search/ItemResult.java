package com.nexus.manager.dto.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName ItemResult
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-02-18 17:37
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResult {

    private long count;

    private int totalPages;

    private List<ItemSearch> itemSearchList;


}
