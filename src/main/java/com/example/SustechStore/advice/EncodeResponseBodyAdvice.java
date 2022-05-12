package com.example.SustechStore.advice;

import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.util.AESUtil;
import com.example.SustechStore.util.NeedEncryption;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 对响应体进行加密
 *
 * @author Administrator
 */
@ControllerAdvice
public class EncodeResponseBodyAdvice implements ResponseBodyAdvice<ResponseBean<Object>> {

    static final Logger LOGGER = LoggerFactory.getLogger(EncodeResponseBodyAdvice.class);

    @Autowired
    Gson gson;

    /**
     * 128位AES密钥
     */
//    @Value("${aes.key}")
//    private static String key;
    public static final byte[] KEY = "9f5d54580044d478".getBytes();

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        /**
         * 返回对象必须是  Message 并且使用了 GsonHttpMessageConverter
         */
        return NeedEncryption.needEncrypt(returnType);

    }

    @Override
    public ResponseBean<Object> beforeBodyWrite(ResponseBean<Object> body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        assert body != null;
        Object data = body.getData();
        if (data != null) {
            body.setData(this.encode(data));
        }
        return body;
    }

    private String encode(Object data) {
        String jsonValue = gson.toJson(data);
        System.out.println(jsonValue);
        try {
            AESUtil aesUtil = new AESUtil();
            String cipher = Base64.getEncoder()
                    .encodeToString(aesUtil.encrypt(jsonValue.getBytes(StandardCharsets.UTF_8), KEY));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("响应体AES加密：raw={},cipher={}", jsonValue, cipher);
            }
            return cipher;
        } catch (Exception e) {
            return "";
        }
    }
}