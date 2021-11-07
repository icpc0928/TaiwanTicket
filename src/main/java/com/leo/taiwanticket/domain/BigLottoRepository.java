package com.leo.taiwanticket.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BigLottoRepository extends JpaRepository<BigLotto, Long> {

    //尋找該使用者所買的所有樂透號碼
    List<BigLotto> findByUserId(long userId);

    //刪除所有數據
    void deleteAll();

    //查詢這個號碼有沒有使用過
    List<BigLotto> findByLottoNumEquals (String lottoNum);
}
