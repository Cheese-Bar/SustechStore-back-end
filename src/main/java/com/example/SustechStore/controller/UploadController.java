package com.example.SustechStore.controller;

import com.example.SustechStore.util.GiteeImgBed;
import com.example.SustechStore.util.Result;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 上传图床
 */
@RestController
@Transactional(rollbackFor = Exception.class)
public class UploadController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 上传图片
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/uploadImg")
    @ResponseBody
    public Result uploadImg(@RequestParam("file") MultipartFile file) throws Exception {
        logger.info("请求成功");
        String originaFileName = file.getOriginalFilename();

        //测试图片受到没
//        System.out.println(originaFileName);

        //上传图片不存在时
        if(originaFileName == null){
            return Result.fail(Result.IMG_EXIST_ERROR,Result.IMG_EXIST_ERROR_MSG);
        }

        String suffix = originaFileName.substring(originaFileName.lastIndexOf("."));
        //设置图片名字
        String fileName = System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + suffix;

        String paramImgFile = Base64.encode(file.getBytes());
        //设置转存到Gitee仓库参数
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("access_token", GiteeImgBed.ACCESS_TOKEN);
        paramMap.put("message", GiteeImgBed.ADD_MESSAGE);
        paramMap.put("content", paramImgFile);

        //测试图片内容
//        System.out.println(paramImgFile);

        //转存文件路径
        String targetDir = GiteeImgBed.PATH + fileName;
        //设置请求路径
        String requestUrl = String.format(GiteeImgBed.CREATE_REPOS_URL, GiteeImgBed.OWNER,
                GiteeImgBed.REPO_NAME, targetDir);
        logger.info("请求Gitee仓库路径:{}",requestUrl);
        String resultJson = HttpUtil.post(requestUrl, paramMap);
        //
        System.out.println(requestUrl);

        JSONObject jsonObject = JSONUtil.parseObj(resultJson);
        //表示操作失败
        if (jsonObject==null || jsonObject.getObj("commit") == null) {
            return Result.fail(Result.SERVE_ERROR,Result.SERVE_ERROR_MSG);
        }
        JSONObject content = JSONUtil.parseObj(jsonObject.getObj("content"));
        return Result.success("",content.getObj("download_url"));
    }

    /**
     * 删除图片
     * @param imgPath
     * @return
     * @throws Exception
     */
    @DeleteMapping("/delImg")
    @ResponseBody
    public Result delImg(@RequestParam(value = "imgPath") String imgPath) throws Exception {
        //路径不存在不存在时
        if(imgPath == null || imgPath.trim().equals("")){
            return Result.fail(Result.SERVE_ERROR,"删除失败");
        }
        String path = imgPath.split("master/")[1];
        //上传图片不存在时
        if(path == null || path.trim().equals("")){
            return Result.fail(Result.IMG_EXIST_ERROR,Result.IMG_EXIST_ERROR_MSG);
        }
        //设置请求路径
        String requestUrl = String.format(GiteeImgBed.GET_IMG_URL, GiteeImgBed.OWNER,
                GiteeImgBed.REPO_NAME, path);
        logger.info("请求Gitee仓库路径:{}",requestUrl);

        //获取图片所有信息
        String resultJson = HttpUtil.get(requestUrl);

        JSONObject jsonObject = JSONUtil.parseObj(resultJson);
        if (jsonObject == null) {
            logger.error("Gitee服务器未响应,message:{}",jsonObject);
            return Result.fail(Result.SERVE_ERROR,Result.SERVE_ERROR_MSG);
        }
        //获取sha,用于删除图片
        String sha = jsonObject.getStr("sha");
        //设置删除请求参数
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("access_token", GiteeImgBed.ACCESS_TOKEN);
        paramMap.put("sha", sha);
        paramMap.put("message", GiteeImgBed.DEl_MESSAGE);
        //设置删除路径
        requestUrl = String.format(GiteeImgBed.DEL_IMG_URL, GiteeImgBed.OWNER,
                GiteeImgBed.REPO_NAME, path);
        logger.info("请求Gitee仓库路径:{}",requestUrl);
        //删除文件请求路径
        resultJson = HttpRequest.delete(requestUrl).form(paramMap).execute().body();
        HttpRequest.put(requestUrl).form(paramMap).execute().body();
        jsonObject = JSONUtil.parseObj(resultJson);
        //请求之后的操作
        if(jsonObject.getObj("commit") == null){
            logger.error("Gitee服务器未响应,message:{}",jsonObject);
            return Result.fail(Result.SERVE_ERROR,Result.SERVE_ERROR_MSG);
        }
        return Result.success("删除成功");
    }

}

