#Shiro配置

###Shiro与Spring整合

1，首先进行数据源的配置MyRealm继承AuthorizingRealm类，
实现里面的认证和授权这两个方法。

2，进配置spring配置文件，实现