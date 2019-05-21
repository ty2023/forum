package com.bysj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 29029
 * @Version 1.0
 * @Time 9:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forums implements Serializable {
    private Integer id;

    private String type = "group";

    private String name;

    private Integer fid;

    private Integer start;

    private String fname;
}
