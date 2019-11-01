package com.duker.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author xiebq
 * @since 2019-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("b_cus_tab_field_info")
public class BCusTabFieldInfoEntity extends Model<BCusTabFieldInfoEntity> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "table_id")
    private String tableId;

    /**
     * 客户字段名称
     */
    @TableField(value = "cus_field")
    private String cusField;

    /**
     * 本地字段名称
     */
    @TableField(value = "local_field")
    private String localField;

    /**
     * 字段类型
     */
    @TableField(value = "field_type")
    private String fieldType;

    /**
     * 字段长度
     */
    @TableField(value = "field_length")
    private String fieldLength;

    /**
     * 字段顺序
     */
    @TableField(value = "field_order")
    private String fieldOrder;

    /**
     * 字段别名
     */
    @TableField(value = "field_alias")
    private String fieldAlias;

    /**
     * 字段说明
     */
    @TableField(value = "field_explain")
    private String fieldExplain;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 创建人
     */
    @TableField(value = "crate_by")
    private String crateBy;

    /**
     * 创建时间
     */
    @TableField(value = "crate_date")
    private Date crateDate;

    /**
     * 修改人
     */
    @TableField(value = "modified_by")
    private String modifiedBy;

    @TableField(value = "modified_date")
    private Date modifiedDate;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
