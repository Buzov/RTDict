package com.barracuda.rtdict.yandex.translate;

/**
 *
 * @author RT
 */
public class YandexDictionary extends YandexAbstract{
    private final String HTTP_XML = "https://dictionary.yandex.net/api/v1/dicservice/lookup?key=" + YandexKeys.YANDEX_API_KEY + "&lang=en-ru&text=%s";
    private final String HTTP_JSON = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=" + YandexKeys.YANDEX_API_KEY + "&lang=en-ru&text=%s";

    @Override
    protected String getUrl(DocType docType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getXml(String word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJson(String word) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
