package com.sbitech.mapper;

import com.sbitech.entity.Move;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface MoveMapper {
    List<Move> getAll();

    String getMoveListByPlayerMatchesId(Long playerMatchesId);

    Float getByCode(String key);

    Collection<Move> getAllMoves();

    String getNameByCode(String s);
}
