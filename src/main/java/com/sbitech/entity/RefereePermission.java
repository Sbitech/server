package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefereePermission {
    private Long id;            // 主键ID
    private Long refereeId;     // 裁判ID
    private Long permissionId;  // 权限ID
    private Boolean isEnabled;  // 是否启用
}