## todo
### 页面静态化
- 静态化流程
    - 1.填写页面DataUrl
        - 在编辑cms页面信息界面填写DataUrl，将此字段保存到cms_page集合中。
    - 2.静态化程序获取页面的DataUrl
        - findDataUrlById();
    - 3.静态化程序远程请求DataUrl获取数据模型。
        - url = "cms/config/getmodel/..."
    - 4.静态化程序获取页面的模板信息
        - 通过GridFs从fs.files获取html数据,转换成模板
    - 5.执行页面静态化
        - 将获取的数据模型存入map中返回给模板