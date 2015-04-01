1，本压缩包中，只有QQAppointment的源代码，不含其它工程文件，相关工程文件会在后续更新中添加。

2，QQAppointment的页面源码全部在QQAppointment\WebContent中，Java类文件全部在src中。

3，数据库连接信息在QQAppointment\WebContent\classes\hibernate.cfg.xml中配置。

4，本网站目前已完成大体架构，数据库访问层，用户登录、注册、appointment新建等功能，其余功能目前暂未完成，将在后续时间里尽快添加。

5，部署方法：
	(1)，所需环境：Tomcat 6.0，MySQL 5.0；

	(2)，在Tomcat的server.xml文件的<host></host>标签中，添加：<Context path="" docBase="{your path}\QQAppointment\WebContent" workDir ="{your path}\QQAppointment\work" reloadable="true"></Context>
；
	(3)，启动MySQL，添加database中的数据库qqappointment；

	(4)，修改QQAppointment\WebContent\classes\hibernate.cfg.xml中的数据库连接信息；

	(5)，启动Tomcat，使用根路径"/"访问：如http://localhost/