package com.barracuda.rtdict.yandex.translate;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author RT
 */
public interface YandexInterface {
    String getXml(String word) throws IOException, URISyntaxException;
    String getJson(String word) throws IOException, URISyntaxException;
}
