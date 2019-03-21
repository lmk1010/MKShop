package com.nexus.manager.dto.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName EsInfo
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-02-18 16:14
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EsInfo implements Serializable {
    private String cluster_name;

    private String status;

    private String number_of_nodes;

    private Integer count;


    @Override
    public String toString() {
        return "EsInfo{" +
                "cluster_name='" + cluster_name + '\'' +
                ", status='" + status + '\'' +
                ", number_of_nodes='" + number_of_nodes + '\'' +
                ", count=" + count +
                '}';
    }
}
