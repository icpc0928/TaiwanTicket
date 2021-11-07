package com.leo.taiwanticket.service;

import com.leo.taiwanticket.domain.BigLotto;
import com.leo.taiwanticket.domain.BigLottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigLottoService {

    @Autowired
    private BigLottoRepository bigLottoRepository;

    //查詢所有樂透
    public List<BigLotto> findAll(){
        return bigLottoRepository.findAll();
    }

    //儲存(新增)一組號碼
    public BigLotto save(BigLotto bigLotto){
        return bigLottoRepository.save(bigLotto);
    }

    //回傳使用者所有買過的號碼
    public List<BigLotto> findByUserId(long userId){
        return bigLottoRepository.findByUserId(userId);
    }

    //回傳是否重複
    public List<BigLotto> findByLottoNumEquals(String lottoNum){
        return bigLottoRepository.findByLottoNumEquals(lottoNum);
    }


}
