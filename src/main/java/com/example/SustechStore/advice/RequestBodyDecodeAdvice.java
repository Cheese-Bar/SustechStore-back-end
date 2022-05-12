package com.example.SustechStore.advice;

import com.example.SustechStore.util.AESUtil;
import com.example.SustechStore.util.NeedDecryption;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestControllerAdvice
public class RequestBodyDecodeAdvice extends RequestBodyAdviceAdapter {

    /**
     * 128位的AESkey
     */
//    @Value("${aes.key}")
//    private  String key;
    private static final byte[] AES_KEY = "9f5d54580044d478".getBytes(StandardCharsets.UTF_8);

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        /**
         * 系统使用的是Gson作为json数据的Http消息转换器
         */
        return NeedDecryption.needDecrypt(methodParameter);
    }

    @SneakyThrows
    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
                                           Class<? extends HttpMessageConverter<?>> converterType) {

        // 读取加密的请求体
        byte[] body = new byte[inputMessage.getBody().available()];
        inputMessage.getBody().read(body);

        // 使用AES解密
        AESUtil aesUtil =new AESUtil();
        body = aesUtil.decrypt(Base64.getDecoder().decode(body), AES_KEY);

        // 使用解密后的数据，构造新的读取流
        InputStream rawInputStream = new ByteArrayInputStream(body);
        return new HttpInputMessage() {
            @Override
            public HttpHeaders getHeaders() {
                return inputMessage.getHeaders();
            }

            @Override
            public InputStream getBody() {
                return rawInputStream;
            }
        };
    }
}