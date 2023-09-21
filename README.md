# 项目架构
框架基于spring MVC +Mybatis，权限框架用的是shiro，前端使用jsp技术
把之前初学java的demo整理下。

- Controller层有点乱

# 数据库脚本
dump-book-202309211645.sql


# 登录页面
![img.png](img.png)

# 注册页面
- 邮箱手机号前端做了正则效验
- 密码是md5加盐，盐字段是用户名
![img_1.png](img_1.png)

# 管理员主页
- 管理员才会显示增删改选项
![img_2.png](img_2.png)

# 个人中心
![img_3.png](img_3.png)

# 权限管理中心
- 未完成 后续更新
![img_4.png](img_4.png)
