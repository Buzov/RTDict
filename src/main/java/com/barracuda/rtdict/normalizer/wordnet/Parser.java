package com.barracuda.rtdict.normalizer.wordnet;

import java.util.Map;

/**
 *
 * @author RT
 */
public interface Parser {
    public void parse(String s, Map<String, Object> map);
}
