CREATE TABLE `t_business` (
`id`  varchar(128) NOT NULL DEFAULT '' COMMENT '编号' ,
`name`  varchar(255) NULL DEFAULT '' COMMENT '名称' ,
`display_name`  varchar(128) NULL DEFAULT '' COMMENT '显示名称' ,
`create_user`  varchar(128) NULL DEFAULT '' COMMENT '创建用户' ,
`create_time`  datetime NULL DEFAULT NOW() COMMENT '创建时间' ,
`modify_user`  varchar(128) NULL DEFAULT '' COMMENT '修改用户' ,
`modify_time`  datetime NULL DEFAULT NOW() COMMENT '修改时间' ,
`memo`  varchar(255) NULL DEFAULT '' COMMENT '备注' ,
`is_custom`  tinyint(1) NOT NULL DEFAULT TRUE COMMENT '是否自定义' ,
PRIMARY KEY (`id`),
UNIQUE KEY `uk_name` (`name`)
)comment='企业信息';

CREATE TABLE `t_user` (
`id`  varchar(128) NOT NULL COMMENT '编号' ,
`name`  varchar(255) NULL COMMENT '名称' ,
`display_name`  varchar(128) NULL COMMENT '显示名称' ,
`status`  tinyint(1) NULL COMMENT '状态' ,
`modify_user`  varchar(128) NULL COMMENT '修改用户' ,
`create_user`  varchar(128) NULL COMMENT '创建用户' ,
`create_time`  datetime NULL COMMENT '创建时间' ,
`modify_time`  datetime NULL COMMENT '修改时间' ,
`account`  varchar(255) NULL COMMENT '账号' ,
`password`  varchar(255) NULL COMMENT '密码' ,
`sex`  varchar(16) NULL COMMENT '性别' ,
`icon`  varchar(255) NULL COMMENT '头像' ,
`email`  varchar(255) NULL COMMENT '邮箱' ,
`phone`  varchar(16) NULL COMMENT '电话' ,
`is_custom`  tinyint(1) NULL COMMENT '是否自定义' ,
`memo`  varchar(255) NULL COMMENT '备注' ,
`business_id`  varchar(128) NULL COMMENT '企业编号' ,
PRIMARY KEY (`id`) ,
UNIQUE KEY `uk_account` (`account`),
CONSTRAINT `fk_user_bid` FOREIGN KEY (`business_id`) REFERENCES `t_business` (`id`) ON UPDATE CASCADE
)comment='用户信息';

CREATE TABLE `t_function` (
`id`  varchar(128) NOT NULL COMMENT '编号' ,
`name`  varchar(255) NULL COMMENT '名称' ,
`display_name`  varchar(128) NULL COMMENT '显示名称' ,
`status`  tinyint(1) NULL COMMENT '状态' ,
`modify_user`  varchar(128) NULL COMMENT '修改用户' ,
`create_user`  varchar(128) NULL COMMENT '创建用户' ,
`create_time`  datetime NULL COMMENT '创建时间' ,
`modify_time`  datetime NULL COMMENT '修改时间' ,
`parent`  varchar(128) NULL COMMENT '上级菜单' ,
`icon`  varchar(255) NULL COMMENT '图标' ,
`url`  varchar(255) NULL COMMENT '地址' ,
`code`  varchar(128) NULL COMMENT '字符串' ,
`index`  int(255) NULL COMMENT '排序' ,
`is_custom`  tinyint(1) NULL COMMENT '是否自定义' ,
`memo`  varchar(255) NULL COMMENT '备注',
PRIMARY KEY (`id`),
UNIQUE KEY `uk_function_code` (`code`)
)comment='菜单表';

CREATE TABLE `t_role` (
`id`  varchar(128) NOT NULL COMMENT '编号' ,
`name`  varchar(255) NULL COMMENT '名称' ,
`display_name`  varchar(128) NULL COMMENT '显示名称' ,
`status`  tinyint(1) NULL COMMENT '状态' ,
`modify_user`  varchar(128) NULL COMMENT '修改用户' ,
`create_user`  varchar(128) NULL COMMENT '创建用户' ,
`create_time`  datetime NULL COMMENT '创建时间' ,
`modify_time`  datetime NULL COMMENT '修改时间' ,
`is_custom`  tinyint(1) NULL COMMENT '是否自定义' ,
`memo`  varchar(255) NULL COMMENT '备注' ,
PRIMARY KEY (`id`)
)comment='角色表';

CREATE TABLE `t_role_function_rel` (
`id`  varchar(128) NOT NULL COMMENT '编号' ,
`role_id`  varchar(128) NOT NULL COMMENT '角色编号' ,
`function_id`  varchar(128) NOT NULL COMMENT '菜单编号' ,
`permissions`  varchar(128) NOT NULL COMMENT '授权功能' ,
PRIMARY KEY (`id`),
CONSTRAINT `fk_role_function_rel_fid` FOREIGN KEY (`function_id`) REFERENCES `t_function` (`id`) ON UPDATE CASCADE
)comment='角色与菜单';

CREATE TABLE `t_role_user_rel` (
`id`  varchar(128) NOT NULL COMMENT '编号' ,
`role_id`  varchar(128) NOT NULL COMMENT '角色编号' ,
`user_id`  varchar(128) NOT NULL COMMENT '用户编号' ,
`business_id`  varchar(128) NULL COMMENT '企业编号' ,
PRIMARY KEY (`id`),
CONSTRAINT `fk_role_user_rel_rid` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON UPDATE CASCADE,
CONSTRAINT `fk_role_user_rel_uid` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON UPDATE CASCADE,
CONSTRAINT `fk_role_user_rel_bid` FOREIGN KEY (`business_id`) REFERENCES `t_business` (`id`) ON UPDATE CASCADE
)comment='角色与用户';

CREATE TABLE `t_wx_app` (
`id`  varchar(128) NOT NULL COMMENT '编号' ,
`app_type`  varchar(128) NOT NULL COMMENT '应用类型' ,
`web_url`  varchar(128) NOT NULL COMMENT 'web地址' ,
`data_url`  varchar(128) NULL COMMENT '数据地址' ,
`wx_type`  varchar(128) NULL COMMENT '微信类型' ,
`app_id`  int(255) NULL COMMENT '微信应用编号' ,
`corpid_appid`  varchar(128) NULL COMMENT '企业号的corpid,服务号appid' ,
`secret`  varchar(128) NULL COMMENT '微信密钥' ,
`business_id`  varchar(128) NULL COMMENT '企业编号' ,
PRIMARY KEY (`id`),
CONSTRAINT `fk_wx_app_bid` FOREIGN KEY (`business_id`) REFERENCES `t_business` (`id`) ON UPDATE CASCADE
)comment='微信app';

CREATE TABLE `t_wx_message` (
`id`  varchar(128) NOT NULL COMMENT '编号' ,
`app_type`  varchar(128) NOT NULL COMMENT '应用类型' ,
`create_time`  datetime NULL COMMENT '创建时间' ,
`message`  varchar(5000) NOT NULL COMMENT '消息内容' ,
`receive_time`  datetime NULL COMMENT '消息收到时间' ,
`send_time`  datetime NULL COMMENT '发送时间' ,
`wx_error_code`  int(10) NULL COMMENT '微信状态码' ,
`wx_error_msg`  varchar(256) NULL COMMENT '微信消息结果' ,
`wx_msg_id`  bigint(10) NULL COMMENT '微信消息编号' ,
`app_id`  varchar(128) NULL COMMENT '应用编号' ,
`business_id`  varchar(128) NULL COMMENT '企业编号' ,
PRIMARY KEY (`id`),
CONSTRAINT `fk_wx_message_aid` FOREIGN KEY (`app_id`) REFERENCES `t_wx_app` (`id`) ON UPDATE CASCADE,
CONSTRAINT `fk_wx_message_bid` FOREIGN KEY (`business_id`) REFERENCES `t_business` (`id`) ON UPDATE CASCADE
)comment='微信消息';

CREATE TABLE `t_wx_msg_template` (
`id`  varchar(128) NOT NULL COMMENT '编号',
`template_id`  varchar(128) NOT NULL COMMENT '模板编号',
`msg_type`  varchar(128) NULL COMMENT '消息类型',
`modify_user`  varchar(128) NULL COMMENT '修改用户' ,
`create_user`  varchar(128) NULL COMMENT '创建用户' ,
`create_time`  datetime NULL COMMENT '创建时间' ,
`modify_time`  datetime NULL COMMENT '修改时间' ,
`app_id`  varchar(128) NULL COMMENT '应用编号' ,
`business_id`  varchar(128) NULL COMMENT '企业编号' ,
PRIMARY KEY (`id`),
CONSTRAINT `t_wx_msg_template_aid` FOREIGN KEY (`app_id`) REFERENCES `t_wx_app` (`id`) ON UPDATE CASCADE,
CONSTRAINT `t_wx_msg_template_bid` FOREIGN KEY (`business_id`) REFERENCES `t_business` (`id`) ON UPDATE CASCADE
)comment='微信消息模板';

CREATE TABLE `t_wx_rmmessage` (
	`id` VARCHAR (128) NOT NULL COMMENT '编号',
	`unique_message` VARCHAR (128) NULL COMMENT '消息唯一计算方法',
	`status`  VARCHAR (128)  NULL COMMENT '状态' ,
	`rmid` INT (10) NULL COMMENT 'RMC消息编号',
	`requ_no` VARCHAR (128) NULL COMMENT '工单编号',
	`mobile_no` VARCHAR (20) NULL COMMENT '电话号码',
	`opend_id` VARCHAR (128) NULL COMMENT 'openID',
	`user_id` VARCHAR (128) NULL COMMENT '用户编号',
	`seconds` INT (10) NULL COMMENT 'RMC消息产生时间',
	`message` VARCHAR (500) NULL COMMENT 'RMC消息',
	`create_time` datetime NULL COMMENT '创建时间',
	`modify_time` datetime NULL COMMENT '修改时间',
	`app_id` VARCHAR (128) NULL COMMENT '应用编号',
	`business_id` VARCHAR (128) NULL COMMENT '企业编号',
	PRIMARY KEY (`id`),
	CONSTRAINT `t_wx_rmmessage_aid` FOREIGN KEY (`app_id`) REFERENCES `t_wx_app` (`id`) ON UPDATE CASCADE,
	CONSTRAINT `t_wx_rmmessage_bid` FOREIGN KEY (`business_id`) REFERENCES `t_business` (`id`) ON UPDATE CASCADE
) COMMENT = 'RMC消息采集';

CREATE TABLE `t_wx_department` (
	`id` VARCHAR (128) NOT NULL COMMENT '编号',
	`department_id` INT (10) NULL COMMENT '微信部门编号',
	`name`  VARCHAR (256)  NULL COMMENT '部门名称' ,
	`parentid` INT (10) NULL COMMENT '微信父部门编号',
	`order` INT (16) NULL COMMENT '排序编号',
	`version` INT (16) NULL COMMENT '版本号',
	`create_time` datetime NULL COMMENT '创建时间',
	`modify_time` datetime NULL COMMENT '修改时间',
	`app_id` VARCHAR (128) NULL COMMENT '应用编号',
	`business_id` VARCHAR (128) NULL COMMENT '企业编号',
	PRIMARY KEY (`id`),
	CONSTRAINT `t_wx_department_aid` FOREIGN KEY (`app_id`) REFERENCES `t_wx_app` (`id`) ON UPDATE CASCADE,
	CONSTRAINT `t_wx_department_bid` FOREIGN KEY (`business_id`) REFERENCES `t_business` (`id`) ON UPDATE CASCADE
) COMMENT = '微信部门';

CREATE TABLE `t_wx_user` (
	`id` VARCHAR (128) NOT NULL COMMENT '编号',
	`userid` VARCHAR (256) NULL COMMENT '成员UserID。对应管理端的帐号',
	`name`  VARCHAR (256)  NULL COMMENT '成员名称' ,
	`mobile`  VARCHAR (256)  NULL COMMENT '手机号码' ,
	`department`  VARCHAR (256)  NULL COMMENT '成员所属部门id列表' ,
	`order`  VARCHAR (256)  NULL COMMENT '部门内的排序值，默认为0。数量必须和department一致，数值越大排序越前面。值范围是[0, 2^32)' ,
	`position`  VARCHAR (256)  NULL COMMENT '职位信息' ,
	`gender`  VARCHAR (10)  NULL COMMENT '性别。0表示未定义，1表示男性，2表示女性' ,
	`email`  VARCHAR (256)  NULL COMMENT '邮箱，第三方仅通讯录套件可获取' ,
	`isleader` INT (10) NULL COMMENT '标示是否为上级',
	`avatar`  VARCHAR (256)  NULL COMMENT '头像url。注：如果要获取小图将url最后的”/0”改成”/100”即可' ,
	`telephone`  VARCHAR (20)  NULL COMMENT '座机。第三方仅通讯录套件可获取' ,
	`english_name`  VARCHAR (256)  NULL COMMENT '英文名' ,
	`status`  INT (10)  NULL COMMENT '激活状态: 1=已激活，2=已禁用，4=未激活 已激活代表已激活企业微信或已关注微信插件。未激活代表既未激活企业微信又未关注微信插件。' ,
	`extattr`  VARCHAR (256)  NULL COMMENT '扩展属性，第三方仅通讯录套件可获取' ,
	`version` INT (16) NULL COMMENT '版本号',
	`create_time` datetime NULL COMMENT '创建时间',
	`modify_time` datetime NULL COMMENT '修改时间',
	`app_id` VARCHAR (128) NULL COMMENT '应用编号',
	`business_id` VARCHAR (128) NULL COMMENT '企业编号',
	PRIMARY KEY (`id`),
	CONSTRAINT `t_wx_user_aid` FOREIGN KEY (`app_id`) REFERENCES `t_wx_app` (`id`) ON UPDATE CASCADE,
	CONSTRAINT `t_wx_user_bid` FOREIGN KEY (`business_id`) REFERENCES `t_business` (`id`) ON UPDATE CASCADE
) COMMENT = '微信用户信息';

CREATE TABLE `t_dictionary` (
	`id`  varchar(128) NOT NULL COMMENT '编号',
	`key`  varchar(128) NULL COMMENT '名称' ,
	`value`  varchar(255) NULL COMMENT '值' ,
	`type`  varchar(128) NULL COMMENT '字典分类' ,
	`create_user`  varchar(128) NULL COMMENT '创建用户' ,
	`create_time`  datetime NULL COMMENT '创建时间' ,
	`modify_user`  varchar(128) NULL COMMENT '修改用户' ,
	`modify_time`  datetime NULL COMMENT '修改时间' ,
	`index`  int(255) NULL COMMENT '排序' ,
	PRIMARY KEY (`id`)
)comment='数据字典表';

CREATE TABLE `t_wx_bmaccount` (
	`id` VARCHAR (128) NOT NULL COMMENT '编号',
	`openid`  VARCHAR (256)  NULL DEFAULT '' COMMENT '微信账号' ,
	`account`  VARCHAR (256)  NULL  DEFAULT '' COMMENT 'BMC账号',
	`password`  VARCHAR (256)  NULL DEFAULT '' COMMENT 'BMC密码',
	`create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
	`modify_time` datetime NOT NULL DEFAULT NOW() COMMENT '修改时间',
	`app_id` VARCHAR (128) NOT NULL COMMENT '应用编号',
	`business_id` VARCHAR (128) NOT NULL COMMENT '企业编号',
	PRIMARY KEY (`id`),
	CONSTRAINT ` t_wx_bmaccount_aid` FOREIGN KEY (`app_id`) REFERENCES `t_wx_app` (`id`) ON UPDATE CASCADE,
	CONSTRAINT ` t_wx_bmaccount_bid` FOREIGN KEY (`business_id`) REFERENCES `t_business` (`id`) ON UPDATE CASCADE
) COMMENT = 'BMC账号信息';

CREATE TABLE `t_wx_bmrelation` (
	`id` VARCHAR (128) NOT NULL COMMENT '编号',
	`openid`  VARCHAR (256)  NULL DEFAULT '' COMMENT '微信账号' ,
	`account`  VARCHAR (256)  NULL DEFAULT '' COMMENT 'BMC APP 账号',
	`create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
	`modify_time` datetime NOT NULL DEFAULT NOW() COMMENT '修改时间',
	`app_id` VARCHAR (128) NOT NULL COMMENT '应用编号',
	`business_id` VARCHAR (128)  NOT NULL COMMENT '企业编号',
	PRIMARY KEY (`id`),
	CONSTRAINT ` t_wx_bm relation_aid` FOREIGN KEY (`app_id`) REFERENCES `t_wx_app` (`id`) ON UPDATE CASCADE,
	CONSTRAINT ` t_wx_bmrelation_bid` FOREIGN KEY (`business_id`) REFERENCES `t_business` (`id`) ON UPDATE CASCADE
) COMMENT = 'BMC用户关系';
