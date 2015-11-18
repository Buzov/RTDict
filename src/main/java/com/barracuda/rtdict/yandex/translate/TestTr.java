/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.rtdict.yandex.translate;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author artur
 */
public class TestTr {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String dictKey = "";
        String trKey = "";
        YandexDictionary yandexDictionary = new YandexDictionary(dictKey);
        YandexTranslate yandexTranslate = new YandexTranslate(trKey);
        String word = "time";
        
        System.out.println("yandexDictionary.getJson(word)------------");
        System.out.println(yandexDictionary.getJson(word));
        System.out.println("yandexDictionary.getXml(word)------------");
        System.out.println(yandexDictionary.getXml(word));
        System.out.println("yandexTranslate.getJson(word)------------");
        System.out.println(yandexTranslate.getJson(word));
        System.out.println("yandexTranslate.getXml(word)------------");
        System.out.println(yandexTranslate.getXml(word));
        
    }
}
