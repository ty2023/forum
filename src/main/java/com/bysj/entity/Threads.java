package com.bysj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 29029
 * @Version 1.0
 * @Time 11:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Threads implements Serializable {
    /**
     * 评论编号
     */
    private Integer id;

    /**
     * 帖子相关信息
     */
    private Integer topicId;

    /**
     *评论内容
     */
    private String centext;

    /**
     * 评论人
     */
    private Integer userId;
    private String userName;

    /**
     * 评论时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
