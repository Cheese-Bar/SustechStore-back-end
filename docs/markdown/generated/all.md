# Api Documentation


<a name="overview"></a>
## 概览
Api Documentation


### 版本信息
*版本* : 1.0


### 许可信息
*许可证* : Apache 2.0  
*许可网址* : http://www.apache.org/licenses/LICENSE-2.0  
*服务条款* : urn:tos


### URI scheme
*域名* : localhost:8080  
*基础路径* : /


### 标签

* AES加解密测试接口 : AES Controller
* basic-error-controller : Basic Error Controller
* release-controller : Release Controller
* upload-controller : Upload Controller
* 分类界面接口 : Cat Controller
* 商品详情接口 : Good Controller
* 我的界面数据调用接口 : Collect Controller
* 接收发布表单 : Receive Controller
* 搜索接口 : Search Controller
* 用户信息修改接口 : Settings Controller
* 用户信息接口 : Login Controller
* 订单接口 : Order Controller
* 首页接口 : Toppage Controller




<a name="paths"></a>
## 资源

<a name="1c8e0186e5ca70c22d07c5183d72e971"></a>
### AES加解密测试接口
AES Controller


<a name="encryptparamtestusingpost"></a>
#### encryptParamTest
```
POST /encryptParamTest
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**s**  <br>*必填*|s|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/encryptParamTest
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="initenusingget"></a>
#### initen
```
GET /generateJsonArrayTest
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/generateJsonArrayTest
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getencryptusingget"></a>
#### getEncrypt
```
GET /generateJsonObjTest
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/generateJsonObjTest
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getparamhexdecrypttestusingget"></a>
#### getParamHexDecryptTest
```
GET /getParamHexDecryptTest/{param}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**param**  <br>*必填*|param|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/getParamHexDecryptTest/string
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="initen2usingget"></a>
#### initen2
```
GET /initen/{type}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**type**  <br>*必填*|type|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/initen/0
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="nextpageenusingget"></a>
#### nextPageEn
```
GET /nextPageEn/{time}/{pageNum}/{pageSize}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**pageNum**  <br>*必填*|pageNum|string|
|**Path**|**pageSize**  <br>*必填*|pageSize|string|
|**Path**|**time**  <br>*必填*|time|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/nextPageEn/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="testpostusingpost"></a>
#### testPost
```
POST /postJsonArrayDecryptTest
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**s**  <br>*必填*|s|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/postJsonArrayDecryptTest
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="testpost2usingpost"></a>
#### testPost2
```
POST /postJsonObjDecryptTest
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**s**  <br>*必填*|s|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/postJsonObjDecryptTest
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="testpost3usingpost"></a>
#### testPost3
```
POST /postParamDecryptTest
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**s**  <br>*必填*|s|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|string|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/postParamDecryptTest
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"string"
```


<a name="basic-error-controller_resource"></a>
### Basic-error-controller
Basic Error Controller


<a name="errorhtmlusingpost"></a>
#### errorHtml
```
POST /error
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `text/html`


##### HTTP请求示例

###### 请求 path
```
/error
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "empty" : true,
  "model" : "object",
  "modelMap" : {
    "string" : "object"
  },
  "reference" : true,
  "status" : "string",
  "view" : {
    "contentType" : "string"
  },
  "viewName" : "string"
}
```


<a name="errorhtmlusingget"></a>
#### errorHtml
```
GET /error
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `text/html`


##### HTTP请求示例

###### 请求 path
```
/error
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "empty" : true,
  "model" : "object",
  "modelMap" : {
    "string" : "object"
  },
  "reference" : true,
  "status" : "string",
  "view" : {
    "contentType" : "string"
  },
  "viewName" : "string"
}
```


<a name="errorhtmlusingput"></a>
#### errorHtml
```
PUT /error
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `text/html`


##### HTTP请求示例

###### 请求 path
```
/error
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "empty" : true,
  "model" : "object",
  "modelMap" : {
    "string" : "object"
  },
  "reference" : true,
  "status" : "string",
  "view" : {
    "contentType" : "string"
  },
  "viewName" : "string"
}
```


<a name="errorhtmlusingdelete"></a>
#### errorHtml
```
DELETE /error
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `text/html`


##### HTTP请求示例

###### 请求 path
```
/error
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "empty" : true,
  "model" : "object",
  "modelMap" : {
    "string" : "object"
  },
  "reference" : true,
  "status" : "string",
  "view" : {
    "contentType" : "string"
  },
  "viewName" : "string"
}
```


<a name="errorhtmlusingpatch"></a>
#### errorHtml
```
PATCH /error
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `text/html`


##### HTTP请求示例

###### 请求 path
```
/error
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "empty" : true,
  "model" : "object",
  "modelMap" : {
    "string" : "object"
  },
  "reference" : true,
  "status" : "string",
  "view" : {
    "contentType" : "string"
  },
  "viewName" : "string"
}
```


<a name="errorhtmlusinghead"></a>
#### errorHtml
```
HEAD /error
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `text/html`


##### HTTP请求示例

###### 请求 path
```
/error
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "empty" : true,
  "model" : "object",
  "modelMap" : {
    "string" : "object"
  },
  "reference" : true,
  "status" : "string",
  "view" : {
    "contentType" : "string"
  },
  "viewName" : "string"
}
```


<a name="errorhtmlusingoptions"></a>
#### errorHtml
```
OPTIONS /error
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ModelAndView](#modelandview)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `text/html`


##### HTTP请求示例

###### 请求 path
```
/error
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "empty" : true,
  "model" : "object",
  "modelMap" : {
    "string" : "object"
  },
  "reference" : true,
  "status" : "string",
  "view" : {
    "contentType" : "string"
  },
  "viewName" : "string"
}
```


<a name="release-controller_resource"></a>
### Release-controller
Release Controller


<a name="findmyrelease2usingget"></a>
#### findMyRelease2
```
GET /myRelease/{id}/{pageNum}/{pageSize}/{timestamp}/{type}/{orderNum}/{goodState}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**goodState**  <br>*必填*|goodState|string|
|**Path**|**id**  <br>*必填*|id|string|
|**Path**|**orderNum**  <br>*必填*|orderNum|string|
|**Path**|**pageNum**  <br>*必填*|pageNum|string|
|**Path**|**pageSize**  <br>*必填*|pageSize|string|
|**Path**|**timestamp**  <br>*必填*|timestamp|string|
|**Path**|**type**  <br>*必填*|type|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/myRelease/string/string/string/string/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="upload-controller_resource"></a>
### Upload-controller
Upload Controller


<a name="delimgusingdelete"></a>
#### delImg
```
DELETE /delImg
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**imgPath**  <br>*必填*|imgPath|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/delImg
```


###### 请求 query
```
json :
{
  "imgPath" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "login" : true,
  "message" : "string",
  "success" : true
}
```


<a name="uploadimgusingpost"></a>
#### uploadImg
```
POST /uploadImg
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**FormData**|**file**  <br>*必填*|file|file|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/uploadImg
```


###### 请求 formData
```
json :
"file"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "login" : true,
  "message" : "string",
  "success" : true
}
```


<a name="6420a6c8879972ba168742d058f53f6b"></a>
### 分类界面接口
Cat Controller


<a name="findcatpagedetail2usingget"></a>
#### 商品简略信息显示
```
GET /category/buy/{cat_id}/{pageNum}/{pageSize}/{type}/{time}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**cat_id**  <br>*必填*|分类编号|string|
|**Path**|**pageNum**  <br>*必填*|pageNum|string|
|**Path**|**pageSize**  <br>*必填*|pageSize|string|
|**Path**|**time**  <br>*必填*|time|string|
|**Path**|**type**  <br>*必填*|type|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/category/buy/string/string/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="initusingget"></a>
#### 分类界面初始化
```
GET /init/{type}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**type**  <br>*必填*|type|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/init/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="7e090d97c5e13fd9e713968ff00e2ab0"></a>
### 商品详情接口
Good Controller


<a name="getgooddetail2usingget"></a>
#### 为当前用户获得该商品的详细信息
```
GET /good_detail/{user_id}/{good_id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**good_id**  <br>*必填*|good_id|string|
|**Path**|**user_id**  <br>*必填*|user_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/good_detail/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="499301caf144a28c7e3c3cb77939732e"></a>
### 我的界面数据调用接口
Collect Controller


<a name="deletegoodusingget"></a>
#### 下架商品
```
GET /Collect/deleteGood/{userId}/{goodId}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**goodId**  <br>*必填*|goodId|string|
|**Path**|**userId**  <br>*必填*|userId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/Collect/deleteGood/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getfavoriteusingget"></a>
#### 获取用户喜欢的商品列表,并根据所选参数排序
```
GET /Collect/favorite/{userId}/{time}/{pageNum}/{pageSize}/{orderNum}/{goodState}/{type}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**goodState**  <br>*必填*|商品状态码： -1不适用该属性筛选/1在售商品/2已完成交易的商品/3主动下架的商品|string|
|**Path**|**orderNum**  <br>*必填*|排序方法码：10时间降序/11时间升序/20价格降序/21价格升序|string|
|**Path**|**pageNum**  <br>*必填*|pageNum|string|
|**Path**|**pageSize**  <br>*必填*|pageSize|string|
|**Path**|**time**  <br>*必填*|时间戳|string|
|**Path**|**type**  <br>*必填*|商品类别： -1不使用该属性筛选/1货架商品/2求购商品|string|
|**Path**|**userId**  <br>*必填*|userId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/Collect/favorite/string/string/string/string/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getfootprintusingget"></a>
#### 获取用户浏览足迹的商品列表,并根据所选参数排序
```
GET /Collect/footPrint/{userId}/{time}/{pageNum}/{pageSize}/{orderNum}/{goodState}/{type}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**goodState**  <br>*必填*|商品状态码： -1不适用该属性筛选/1在售商品/2已完成交易的商品/3主动下架的商品|string|
|**Path**|**orderNum**  <br>*必填*|排序方法码：10时间降序/11时间升序/20价格降序/21价格升序|string|
|**Path**|**pageNum**  <br>*必填*|pageNum|string|
|**Path**|**pageSize**  <br>*必填*|pageSize|string|
|**Path**|**time**  <br>*必填*|时间戳|string|
|**Path**|**type**  <br>*必填*|商品类别： -1不使用该属性筛选/1货架商品/2求购商品|string|
|**Path**|**userId**  <br>*必填*|userId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/Collect/footPrint/string/string/string/string/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="initstaticusingget"></a>
#### 界面初始化
```
GET /Collect/init/{userId}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**userId**  <br>*必填*|用户的userId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/Collect/init/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="resubmitgoodusingget"></a>
#### 重新发布商品
```
GET /Collect/resubmitGood/{userId}/{goodId}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**goodId**  <br>*必填*|goodId|string|
|**Path**|**userId**  <br>*必填*|userId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/Collect/resubmitGood/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatefavoriteusingget"></a>
#### 更新当前用户-商品的喜欢状态
```
GET /Collect/updateFavorite/{userId}/{goodId}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**goodId**  <br>*必填*|goodId|string|
|**Path**|**userId**  <br>*必填*|userId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/Collect/updateFavorite/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="4ac92e9e5d2a8c738fe4755ca99b411e"></a>
### 接收发布表单
Receive Controller


<a name="addgooddetailusingpost"></a>
#### 发布商品
```
POST /receive/add-goods-detail
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**stringJson**  <br>*必填*|stringJson|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/receive/add-goods-detail
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getaddressesusingget"></a>
#### 获取所有地址
```
GET /receive/getAddresses
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/receive/getAddresses
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="getlabelsusingget"></a>
#### 获取所有地址
```
GET /receive/getLabels
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/receive/getLabels
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="d2a0eaa95166c60ed624d089a612a438"></a>
### 搜索接口
Search Controller


<a name="fuzzysearchusingget"></a>
#### 简单模糊搜索
```
GET /Search/fuzzy/{time}/{string}/{pageNum}/{pageSize}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**pageNum**  <br>*必填*|pageNum|string|
|**Path**|**pageSize**  <br>*必填*|pageSize|string|
|**Path**|**string**  <br>*必填*|string|string|
|**Path**|**time**  <br>*必填*|time|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/Search/fuzzy/string/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="fuzzysearchplusorderusingget"></a>
#### 带有筛选与排序的模糊搜索
```
GET /Search/fuzzyPlus/{time}/{string}/{pageNum}/{pageSize}/{orderNum}/{goodState}/{type}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**goodState**  <br>*必填*|goodState|string|
|**Path**|**orderNum**  <br>*必填*|orderNum|string|
|**Path**|**pageNum**  <br>*必填*|pageNum|string|
|**Path**|**pageSize**  <br>*必填*|pageSize|string|
|**Path**|**string**  <br>*必填*|string|string|
|**Path**|**time**  <br>*必填*|time|string|
|**Path**|**type**  <br>*必填*|type|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/Search/fuzzyPlus/string/string/string/string/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="5c17ea1ed26bc14c5ffda29f58c7e71a"></a>
### 用户信息修改接口
Settings Controller


<a name="modifyimgusingget"></a>
#### modifyImg
```
GET /settings/modify_image/{image_url}/{user_id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**image_url**  <br>*必填*|image_url|string|
|**Path**|**user_id**  <br>*必填*|user_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/settings/modify_image/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="modifynicknameusingget"></a>
#### modifyNickname
```
GET /settings/modify_nickname/{nickname}/{user_id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**nickname**  <br>*必填*|nickname|string|
|**Path**|**user_id**  <br>*必填*|user_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/settings/modify_nickname/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="topupusingget"></a>
#### topUp
```
GET /settings/topUp/{user_id}/{money}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**money**  <br>*必填*|money|string|
|**Path**|**user_id**  <br>*必填*|user_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/settings/topUp/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="6b4083c1d179d4c2928abe628ab60489"></a>
### 用户信息接口
Login Controller


<a name="selectrealnamebywxusingget"></a>
#### 登录初始化
```
GET /login/init/{wx_id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**wx_id**  <br>*必填*|wx_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/login/init/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="initinfousingget"></a>
#### initInfo
```
GET /login/init_info/{s_id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**s_id**  <br>*必填*|s_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/login/init_info/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="login1usingget"></a>
#### login1
```
GET /login/login1/{s_id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**s_id**  <br>*必填*|s_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/login/login1/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="login2usingget"></a>
#### login2
```
GET /login/login2/{s_id}/{code}/{wx_id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**code**  <br>*必填*|code|string|
|**Path**|**s_id**  <br>*必填*|s_id|string|
|**Path**|**wx_id**  <br>*必填*|wx_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/login/login2/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="login2testusingpost"></a>
#### login2Test
```
POST /login/login2Test
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**stringJson**  <br>*必填*|stringJson|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/login/login2Test
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="logoutusingget"></a>
#### logOut
```
GET /login/logout/{s_id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**s_id**  <br>*必填*|s_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/login/logout/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="register1usingget"></a>
#### register1
```
GET /login/register1/{s_id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**s_id**  <br>*必填*|s_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/login/register1/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="register2usingget"></a>
#### register2
```
GET /login/register2/{s_id}/{code}/{nickname}/{wx_id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**code**  <br>*必填*|code|string|
|**Path**|**nickname**  <br>*必填*|nickname|string|
|**Path**|**s_id**  <br>*必填*|s_id|string|
|**Path**|**wx_id**  <br>*必填*|wx_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/login/register2/string/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="register2testusingpost"></a>
#### register2Test
```
POST /login/register2Test
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**stringJson**  <br>*必填*|stringJson|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/login/register2Test
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="quitusingget"></a>
#### quit
```
GET /quit/{wx_id}/{s_id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**s_id**  <br>*必填*|s_id|string|
|**Path**|**wx_id**  <br>*必填*|wx_id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/quit/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="33be1f1e9f5622971ec234e687e3229a"></a>
### 订单接口
Order Controller


<a name="buygoodusingget"></a>
#### 购买商品
```
GET /order/buyGood/{userId}/{goodId}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**goodId**  <br>*必填*|goodId|string|
|**Path**|**userId**  <br>*必填*|userId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/order/buyGood/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="selectbybuyerid2usingget"></a>
#### 我买入的
```
GET /order/byBuyer/{id}/{pageNum}/{pageSize}/{timestamp}/{type}/{orderNum}/{goodState}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**goodState**  <br>*必填*|goodState|string|
|**Path**|**id**  <br>*必填*|id|string|
|**Path**|**orderNum**  <br>*必填*|orderNum|string|
|**Path**|**pageNum**  <br>*必填*|pageNum|string|
|**Path**|**pageSize**  <br>*必填*|pageSize|string|
|**Path**|**timestamp**  <br>*必填*|timestamp|string|
|**Path**|**type**  <br>*必填*|type|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/order/byBuyer/string/string/string/string/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="selectbysellerid2usingget"></a>
#### 我卖出的
```
GET /order/bySeller/{id}/{pageNum}/{pageSize}/{timestamp}/{type}/{orderNum}/{goodState}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**goodState**  <br>*必填*|goodState|string|
|**Path**|**id**  <br>*必填*|id|string|
|**Path**|**orderNum**  <br>*必填*|orderNum|string|
|**Path**|**pageNum**  <br>*必填*|pageNum|string|
|**Path**|**pageSize**  <br>*必填*|pageSize|string|
|**Path**|**timestamp**  <br>*必填*|timestamp|string|
|**Path**|**type**  <br>*必填*|type|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/order/bySeller/string/string/string/string/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="25464286358e1229829b3d44bd7065a7"></a>
### 首页接口
Toppage Controller


<a name="nextpageusingget"></a>
#### nextPage
```
GET /toppage/nextPage/{time}/{pageNum}/{pageSize}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**pageNum**  <br>*必填*|pageNum|string|
|**Path**|**pageSize**  <br>*必填*|pageSize|string|
|**Path**|**time**  <br>*必填*|time|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBean«object»](#a5c50b7e092e566f888529d938b13d82)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/toppage/nextPage/string/string/string
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```




<a name="definitions"></a>
## 定义

<a name="modelandview"></a>
### ModelAndView

|名称|说明|类型|
|---|---|---|
|**empty**  <br>*可选*|**样例** : `true`|boolean|
|**model**  <br>*可选*|**样例** : `"object"`|object|
|**modelMap**  <br>*可选*|**样例** : `{<br>  "string" : "object"<br>}`|< string, object > map|
|**reference**  <br>*可选*|**样例** : `true`|boolean|
|**status**  <br>*可选*|**样例** : `"string"`|enum (100 CONTINUE, 101 SWITCHING_PROTOCOLS, 102 PROCESSING, 103 CHECKPOINT, 200 OK, 201 CREATED, 202 ACCEPTED, 203 NON_AUTHORITATIVE_INFORMATION, 204 NO_CONTENT, 205 RESET_CONTENT, 206 PARTIAL_CONTENT, 207 MULTI_STATUS, 208 ALREADY_REPORTED, 226 IM_USED, 300 MULTIPLE_CHOICES, 301 MOVED_PERMANENTLY, 302 FOUND, 302 MOVED_TEMPORARILY, 303 SEE_OTHER, 304 NOT_MODIFIED, 305 USE_PROXY, 307 TEMPORARY_REDIRECT, 308 PERMANENT_REDIRECT, 400 BAD_REQUEST, 401 UNAUTHORIZED, 402 PAYMENT_REQUIRED, 403 FORBIDDEN, 404 NOT_FOUND, 405 METHOD_NOT_ALLOWED, 406 NOT_ACCEPTABLE, 407 PROXY_AUTHENTICATION_REQUIRED, 408 REQUEST_TIMEOUT, 409 CONFLICT, 410 GONE, 411 LENGTH_REQUIRED, 412 PRECONDITION_FAILED, 413 PAYLOAD_TOO_LARGE, 413 REQUEST_ENTITY_TOO_LARGE, 414 URI_TOO_LONG, 414 REQUEST_URI_TOO_LONG, 415 UNSUPPORTED_MEDIA_TYPE, 416 REQUESTED_RANGE_NOT_SATISFIABLE, 417 EXPECTATION_FAILED, 418 I_AM_A_TEAPOT, 419 INSUFFICIENT_SPACE_ON_RESOURCE, 420 METHOD_FAILURE, 421 DESTINATION_LOCKED, 422 UNPROCESSABLE_ENTITY, 423 LOCKED, 424 FAILED_DEPENDENCY, 425 TOO_EARLY, 426 UPGRADE_REQUIRED, 428 PRECONDITION_REQUIRED, 429 TOO_MANY_REQUESTS, 431 REQUEST_HEADER_FIELDS_TOO_LARGE, 451 UNAVAILABLE_FOR_LEGAL_REASONS, 500 INTERNAL_SERVER_ERROR, 501 NOT_IMPLEMENTED, 502 BAD_GATEWAY, 503 SERVICE_UNAVAILABLE, 504 GATEWAY_TIMEOUT, 505 HTTP_VERSION_NOT_SUPPORTED, 506 VARIANT_ALSO_NEGOTIATES, 507 INSUFFICIENT_STORAGE, 508 LOOP_DETECTED, 509 BANDWIDTH_LIMIT_EXCEEDED, 510 NOT_EXTENDED, 511 NETWORK_AUTHENTICATION_REQUIRED)|
|**view**  <br>*可选*|**样例** : `"[view](#view)"`|[View](#view)|
|**viewName**  <br>*可选*|**样例** : `"string"`|string|


<a name="a5c50b7e092e566f888529d938b13d82"></a>
### ResponseBean«object»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `0`|integer (int32)|
|**data**  <br>*可选*|**样例** : `"object"`|object|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="result"></a>
### Result

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `0`|integer (int32)|
|**data**  <br>*可选*|**样例** : `"object"`|object|
|**login**  <br>*可选*|**样例** : `true`|boolean|
|**message**  <br>*可选*|**样例** : `"string"`|string|
|**success**  <br>*可选*|**样例** : `true`|boolean|


<a name="view"></a>
### View

|名称|说明|类型|
|---|---|---|
|**contentType**  <br>*可选*|**样例** : `"string"`|string|





