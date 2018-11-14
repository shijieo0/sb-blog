# sb-blog
## API设计

GET /users : 返回用于展现用户列表的list.html页面

GET /users/{id} : 返回用于展现用户的view.html页面；

GET /users/form : 返回用于新增或者修改用户的form.html页面；

POST /users : 新增或者修改用户，成功后重定向到list.html页面；

GET /users/delete/{id} : 根据id删除相应的用户数据，成功后重定向到list.html页面；

GET /users/modify/{id} : 根据id获取相应的用户数据并返回form.html页面用来执行修改。

## 后台编码

* 实体 User

* 资源库 UserRepository

* 控制器 UserController

## 前端编码

* list.html ：用于展现用户列表
* form.html：用于新增或者修改用户的资料
* view.html：用户查看某个用户的资料

* header.html：共用的头部页面
* footer.html：共用的底部页面

## 

