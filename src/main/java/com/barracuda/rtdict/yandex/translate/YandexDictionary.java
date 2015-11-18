package com.barracuda.rtdict.yandex.translate;

/**
 *
 * @author RT
 */
public class YandexDictionary extends YandexAbstract{
    private static final String HOST = "dictionary.yandex.net";
    private static final String PATH_XML = "api/v1/dicservice/lookup";
    private static final String PATH_JSON = "api/v1/dicservice.json/lookup";

    public YandexDictionary(String key, String lang) {
        super(HOST, PATH_XML, PATH_JSON, key, lang);
    }
    
    public YandexDictionary(String key) {
        super(HOST, PATH_XML, PATH_JSON, key, LANG);
    }

}
