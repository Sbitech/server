package com.sbitech.mapper;

import com.sbitech.entity.Move;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MoveMapper {
    List<Move> getAll();

    Float getByCode(String key);
}
