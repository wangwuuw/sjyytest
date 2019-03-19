package com.test.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
@Controller
public class RestTemplateTest {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/getCoinRate/{coinId}")
    @ResponseBody
    public  void metadataTable(@PathVariable("coinId")String coinId) {//@PathVariable("urls") String urls,@RequestParam MultiValueMap value
//    	BTCExchangeRate(coinId);
//    	LTCExchangeRate();
//    	ETHExchangeRate();
//    	BCHExchangeRate();
//    	USDTExchangeRate();
    	ExchangeRate();

    }
    private void BTCExchangeRate(String coinId){
   	 String url = new String("https://api.coinmarketcap.com/v2/ticker/{coinId}/?convert=BTC");
        String jsonStr =restTemplate.getForObject(url,String.class,coinId);
        JSONObject parseObject = JSON.parseObject(jsonStr);
        JSONObject data = parseObject.getJSONObject("data");
        JSONObject quotes = data.getJSONObject("quotes");
        JSONObject USDObject = quotes.getJSONObject("USD");
        //LTC对美元的汇率
        BigDecimal LTC_USDexchangeRate = USDObject.getBigDecimal("price");
        JSONObject BTCObject = quotes.getJSONObject("BTC");
        //LTC对比特币的汇率
        BigDecimal LTC_BTCexchangeRate = BTCObject.getBigDecimal("price");
        System.out.println("BTC对美元和比特币的汇率为"+LTC_USDexchangeRate+","+LTC_BTCexchangeRate);
   }
    /**
     * 获取USD对CNY的汇率
     * @param coinId
     */
    private void ExchangeRate(){
      	 String url = new String("http://free.currencyconverterapi.com/api/v5/convert?q=USD_CNY&compact=y");
           String jsonStr =restTemplate.getForObject(url,String.class);
           JSONObject parseObject = JSON.parseObject(jsonStr);
           JSONObject data = parseObject.getJSONObject("USD_CNY");
           BigDecimal rate = data.getBigDecimal("val");
           System.out.println("美元对人民币的汇率");
      }
    @RequestMapping("/")
    @ResponseBody
    String index(){
      return "Hello Spring Boot";
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
