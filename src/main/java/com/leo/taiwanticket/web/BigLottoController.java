package com.leo.taiwanticket.web;

import com.leo.taiwanticket.domain.BigLotto;
import com.leo.taiwanticket.model.BigLottoModel;
import com.leo.taiwanticket.service.BigLottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bigLotto")
public class BigLottoController {

    @Autowired
    private BigLottoService bigLottoService;

    BigLottoModel bigLottoModel = new BigLottoModel();

    //大樂透首頁
    @GetMapping("/")
    public String index(){
        return "bigLotto";
    }


    //取得一組隨機選號
    @GetMapping("/getRandomNum")
    public String getRandom(Model model){
        boolean isRepeat = true;
        String randomNum;
        do{
            randomNum = bigLottoModel.getRandomNum();
            System.out.println("RandomNum: " + randomNum);
//            List<BigLotto> bigLottoList = bigLottoService.findByLottoNumEquals(randomNum);
//            System.out.println("bigLottoList: "+bigLottoList);
            if(bigLottoService.findByLottoNumEquals(randomNum).size() == 0){
                isRepeat = false;
            }
        }while (isRepeat);
        model.addAttribute("randomNum", randomNum);

        return "bigLottoRandom";
    }

    //儲存這組號碼進bigLotto資料庫
    @GetMapping("/saveRandomNum/{randomNum}")
    public String saveRandomNum(@PathVariable String randomNum){
        System.out.println("randomNum: " + randomNum);
        BigLotto bigLotto = new BigLotto();
        bigLotto.setLottoNum(randomNum);
        System.out.println("BigLotto: " + bigLotto.toString());
        bigLottoService.save(bigLotto);
        return "bigLotto";
    }



}
