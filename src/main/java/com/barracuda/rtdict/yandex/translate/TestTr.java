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
        String dictKey = "dict.1.1.20151014T112649Z.36a0cda4022040a7.9b9f5602220606208bcbe2a65ca0aa0513f0c736";
        String trKey = "trnsl.1.1.20151014T105905Z.8db55b8c8bfbb2c0.16a40a0210e9f962ab4f6e8b69a986c978005aa9";
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
