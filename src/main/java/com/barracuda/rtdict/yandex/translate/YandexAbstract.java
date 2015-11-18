package com.barracuda.rtdict.yandex.translate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author RT
 */
public abstract class YandexAbstract implements YandexInterface {
    
    protected static final String LANG = "en";

    protected String scheme = "https";
    protected String host;
    protected String pathXml;
    protected String pathJson;
    protected String key;
    protected String lang;

    public YandexAbstract(String host, String pathXml, String pathJson, String key, String lang) {
        this.host = host;
        this.pathXml = pathXml;
        this.pathJson = pathJson;
        this.key = key;
        this.lang = lang;
    }
   

    public YandexAbstract(String key, String lang) {
        this.key = key;
        this.lang = lang;
    }

    protected String getPath(DocType docType) {
        String path = pathXml;
        if (docType != null) {
            switch (docType) {
                case XML:
                    path = pathXml;
                    break;
                case JSON:
                    path = pathJson;
                    break;
            }
        }
        return path;
    }

    protected URI getUrl(String text, DocType docType) throws URISyntaxException {
        return getUrl(key, lang, text, docType);
    }
    
    protected URI getUrl(String key, String lang, String text, DocType docType) throws URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme(scheme).setHost(host).setPath(getPath(docType))
                .setParameter("key", key)
                .setParameter("lang", lang)
                .setParameter("text", text);
        URI uri = builder.build();
        return uri;//String.format(getUrl(docType), text);
    }
    
    protected String getResponse(URI uri) throws IOException {
        String responseAsString = null;
        HttpGet httpget = new HttpGet(uri);

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instream = null;
            try {
                instream = entity.getContent();
                responseAsString = IOUtils.toString(instream);
            } finally {
                if (instream != null)
                    instream.close();
            }

        }
        return responseAsString;
    }
        
    @Override
    public String getXml(String word) throws IOException, URISyntaxException {
        return getResponse(getUrl(word, DocType.XML));
    }

    @Override
    public String getJson(String word) throws IOException, URISyntaxException {
        return getResponse(getUrl(word, DocType.JSON));
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPathXml() {
        return pathXml;
    }

    public void setPathXml(String pathXml) {
        this.pathXml = pathXml;
    }

    public String getPathJson() {
        return pathJson;
    }

    public void setPathJson(String pathJson) {
        this.pathJson = pathJson;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

}
