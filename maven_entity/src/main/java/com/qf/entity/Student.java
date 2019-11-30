package com.qf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Author Amos
 * Creat Time 2019 11 29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_student")
public class Student extends BaseEntity{

    private String sname;
    private Integer age;
    private Integer cid;
    @TableField(exist = false)
    private StuClass cls;

}
