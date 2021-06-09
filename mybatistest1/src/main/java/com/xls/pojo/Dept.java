package com.xls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data/*编译时自动生成get、set方法*/
@AllArgsConstructor/*添加所有带参构造方法*/
@NoArgsConstructor/*无参构造方法*/
public class Dept implements Serializable {
    private int deptno;
    private String dname;
    private String loc;
}
