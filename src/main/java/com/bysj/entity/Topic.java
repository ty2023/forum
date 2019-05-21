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
 * @Time 10:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic implements Serializable {
    /**
     * 帖子编号
     */
    private Integer id;

    /**
     * 帖子所属板块
     */
    private Integer forumId;
    private String forumName;

    /**
     * 发帖人
     */
    private Integer userId;
    private String userName;

    /**
     * 贴子名
     */
    private String title;

    /**
     * 贴子内容
     */
    private String context;

    /**
     * 评论数量
     */
    private Integer repliesNum;

    /**
     * 贴子发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}


