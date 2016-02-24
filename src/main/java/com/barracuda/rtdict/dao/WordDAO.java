package com.barracuda.rtdict.dao;

import com.barracuda.rtdict.yandex.translate.parser.word.gson.Word;
import java.sql.SQLException;
import java.util.List;

public interface WordDAO {

    public void add(Word word) throws SQLException;

    public void update(Word word) throws SQLException;

    public Word getById(Long id) throws SQLException;

    public List getAll() throws SQLException;

    public void delete(Word word) throws SQLException;
}
