# sb-blog
## API设计

GET /users : 返回用于展现用户列表的list.html页面

GET /users/{id} : 返回用于展现用户的view.html页面；

GET /users/form : 返回用于新增或者修改用户的form.html页面；

POST /users : 新增或者修改用户，成功后重定向到list.html页面；

GET /users/delete/{id} : 根据id删除相应的用户数据，成功后重定向到list.html页面；

GET /users/modify/{id} : 根据id获取相应的用户数据并返回form.html页面用来执行修改。