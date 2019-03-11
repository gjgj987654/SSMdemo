package com.chaoxing.model.po;

import com.chaoxing.mybatis.annotation.Column;
import com.chaoxing.mybatis.annotation.Id;
import com.chaoxing.mybatis.annotation.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by sxc on 2018/9/3.
 * email sunxu@chaoxing.com
 */
@Getter
@Setter
@Table("test")
public class TestPo {
    @Id
    @Column(insertable = false)
    private int id;

    @Column("msg")
    private String msg;

    @Column(insertable = false)
    private Date inserttime;
}
