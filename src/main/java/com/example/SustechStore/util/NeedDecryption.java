package com.example.SustechStore.util;


import com.example.SustechStore.annotations.NeedDecrypt;
import com.example.SustechStore.annotations.NeedEncrypt;
import org.springframework.core.MethodParameter;

/**
 * 是否需要加密解密
 */
public class NeedDecryption {

    /**
     * 判断是否需要加密
     *
     * @param returnType
     * @return boolean
     */
    public static boolean needDecrypt(MethodParameter returnType) {
        boolean encrypt = false;
        // 获取类上的注解
        final boolean classPresentAnno = returnType.getContainingClass().isAnnotationPresent(NeedDecrypt.class);
        // 获取方法上的注解
        final boolean methodPresentAnno = returnType.getMethod().isAnnotationPresent(NeedDecrypt.class);
        if (classPresentAnno) {
            // 类上标注的是否需要加密
            encrypt = returnType.getContainingClass().getAnnotation(NeedDecrypt.class).value();
            // 类不加密，所有都不加密
            if (!encrypt) {
                return false;
            }
        }
        if (methodPresentAnno) {
            // 方法上标注的是否需要加密
            encrypt = returnType.getMethod().getAnnotation(NeedDecrypt.class).value();
        }
        return encrypt;
    }

}
