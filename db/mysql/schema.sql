CREATE TABLE `t_business` (
`c_id`  varchar(128) NOT NULL DEFAULT '' COMMENT '编号' ,
`c_name`  varchar(255) NULL DEFAULT '' COMMENT '名称' ,
`c_display_name`  varchar(128) NULL DEFAULT '' COMMENT '显示名称' ,
`c_create_user`  varchar(128) NULL DEFAULT '' COMMENT '创建用户' ,
`c_create_time`  datetime NULL DEFAULT NOW() COMMENT '创建时间' ,
`c_modify_user`  varchar(128) NULL DEFAULT '' COMMENT '修改用户' ,
`c_modify_time`  datetime NULL DEFAULT NOW() COMMENT '修改时间' ,
`c_memo`  varchar(255) NULL DEFAULT '' COMMENT '备注' ,
`c_is_custom`  tinyint(1) NOT NULL DEFAULT TRUE COMMENT '是否自定义' ,
PRIMARY KEY (`c_id`),
UNIQUE KEY `uk_name` (`c_name`)
)comment='企业信息';

CREATE TABLE `t_user` (
`c_id`  varchar(128) NOT NULL COMMENT '编号' ,
`c_name`  varchar(255) NULL COMMENT '名称' ,
`c_display_name`  varchar(128) NULL COMMENT '显示名称' ,
`c_status`  tinyint(1) NULL COMMENT '状态' ,
`c_modify_user`  varchar(128) NULL COMMENT '修改用户' ,
`c_create_user`  varchar(128) NULL COMMENT '创建用户' ,
`c_create_time`  datetime NULL COMMENT '创建时间' ,
`c_modify_time`  datetime NULL COMMENT '修改时间' ,
`c_account`  varchar(255) NULL COMMENT '账号' ,
`c_password`  varchar(255) NULL COMMENT '密码' ,
`c_sex`  varchar(16) NULL COMMENT '性别' ,
`c_icon`  varchar(255) NULL COMMENT '头像' ,
`c_email`  varchar(255) NULL COMMENT '邮箱' ,
`c_phone`  varchar(16) NULL COMMENT '电话' ,
`c_is_custom`  tinyint(1) NULL COMMENT '是否自定义' ,
`c_memo`  varchar(255) NULL COMMENT '备注' ,
`c_business_id`  varchar(128) NULL COMMENT '企业编号' ,
PRIMARY KEY (`c_id`) ,
UNIQUE KEY `uk_account` (`c_account`),
CONSTRAINT `fk_user_bid` FOREIGN KEY (`c_business_id`) REFERENCES `t_business` (`c_id`) ON UPDATE CASCADE
)comment='用户信息';

CREATE TABLE `t_function` (
`c_id`  varchar(128) NOT NULL COMMENT '编号' ,
`c_name`  varchar(255) NULL COMMENT '名称' ,
`c_display_name`  varchar(128) NULL COMMENT '显示名称' ,
`c_status`  tinyint(1) NULL COMMENT '状态' ,
`c_modify_user`  varchar(128) NULL COMMENT '修改用户' ,
`c_create_user`  varchar(128) NULL COMMENT '创建用户' ,
`c_create_time`  datetime NULL COMMENT '创建时间' ,
`c_modify_time`  datetime NULL COMMENT '修改时间' ,
`c_parent`  varchar(128) NULL COMMENT '上级菜单' ,
`c_icon`  varchar(255) NULL COMMENT '图标' ,
`c_url`  varchar(255) NULL COMMENT '地址' ,
`c_code`  varchar(128) NULL COMMENT '字符串' ,
`c_index`  int(255) NULL COMMENT '排序' ,
`c_is_custom`  tinyint(1) NULL COMMENT '是否自定义' ,
`c_memo`  varchar(255) NULL COMMENT '备注',
PRIMARY KEY (`c_id`),
UNIQUE KEY `uk_function_code` (`c_code`)
)comment='菜单表';

CREATE TABLE `t_role` (
`c_id`  varchar(128) NOT NULL COMMENT '编号' ,
`c_name`  varchar(255) NULL COMMENT '名称' ,
`c_display_name`  varchar(128) NULL COMMENT '显示名称' ,
`c_status`  tinyint(1) NULL COMMENT '状态' ,
`c_modify_user`  varchar(128) NULL COMMENT '修改用户' ,
`c_create_user`  varchar(128) NULL COMMENT '创建用户' ,
`c_create_time`  datetime NULL COMMENT '创建时间' ,
`c_modify_time`  datetime NULL COMMENT '修改时间' ,
`c_is_custom`  tinyint(1) NULL COMMENT '是否自定义' ,
`c_memo`  varchar(255) NULL COMMENT '备注' ,
PRIMARY KEY (`c_id`)
)comment='角色表';

CREATE TABLE `t_role_function_rel` (
`c_id`  varchar(128) NOT NULL COMMENT '编号' ,
`c_role_id`  varchar(128) NOT NULL COMMENT '角色编号' ,
`c_function_id`  varchar(128) NOT NULL COMMENT '菜单编号' ,
`c_permissions`  varchar(128) NOT NULL COMMENT '授权功能' ,
PRIMARY KEY (`c_id`),
CONSTRAINT `fk_role_function_rel_fid` FOREIGN KEY (`c_function_id`) REFERENCES `t_function` (`c_id`) ON UPDATE CASCADE
)comment='角色与菜单';

CREATE TABLE `t_role_user_rel` (
`c_id`  varchar(128) NOT NULL COMMENT '编号' ,
`c_role_id`  varchar(128) NOT NULL COMMENT '角色编号' ,
`c_user_id`  varchar(128) NOT NULL COMMENT '用户编号' ,
`c_business_id`  varchar(128) NULL COMMENT '企业编号' ,
PRIMARY KEY (`c_id`),
CONSTRAINT `fk_role_user_rel_rid` FOREIGN KEY (`c_role_id`) REFERENCES `t_role` (`c_id`) ON UPDATE CASCADE,
CONSTRAINT `fk_role_user_rel_uid` FOREIGN KEY (`c_user_id`) REFERENCES `t_user` (`c_id`) ON UPDATE CASCADE,
CONSTRAINT `fk_role_user_rel_bid` FOREIGN KEY (`c_business_id`) REFERENCES `t_business` (`c_id`) ON UPDATE CASCADE
)comment='角色与用户';

CREATE TABLE `t_wx_app` (
`c_id`  varchar(128) NOT NULL COMMENT '编号' ,
`c_app_type`  varchar(128) NOT NULL COMMENT '应用类型' ,
`c_web_url`  varchar(128) NOT NULL COMMENT 'web地址' ,
`c_data_url`  varchar(128) NULL COMMENT '数据地址' ,
`c_wx_type`  varchar(128) NULL COMMENT '微信类型' ,
`c_app_id`  int(255) NULL COMMENT '微信应用编号' ,
`c_corpid_appid`  varchar(128) NULL COMMENT '企业号的corpid,服务号appid' ,
`c_secret`  varchar(128) NULL COMMENT '微信密钥' ,
`c_business_id`  varchar(128) NULL COMMENT '企业编号' ,
PRIMARY KEY (`c_id`),
CONSTRAINT `fk_wx_app_bid` FOREIGN KEY (`c_business_id`) REFERENCES `t_business` (`c_id`) ON UPDATE CASCADE
)comment='微信app';

CREATE TABLE `t_wx_message` (
`c_id`  varchar(128) NOT NULL COMMENT '编号' ,
`c_app_type`  varchar(128) NOT NULL COMMENT '应用类型' ,
`c_create_time`  datetime NULL COMMENT '创建时间' ,
`c_message`  varchar(5000) NOT NULL COMMENT '消息内容' ,
`c_receive_time`  datetime NULL COMMENT '消息收到时间' ,
`c_send_time`  datetime NULL COMMENT '发送时间' ,
`c_wx_error_code`  int(10) NULL COMMENT '微信状态码' ,
`c_wx_error_msg`  varchar(256) NULL COMMENT '微信消息结果' ,
`c_wx_msg_id`  bigint(10) NULL COMMENT '微信消息编号' ,
`c_app_id`  varchar(128) NULL COMMENT '应用编号' ,
`c_business_id`  varchar(128) NULL COMMENT '企业编号' ,
PRIMARY KEY (`c_id`),
CONSTRAINT `fk_wx_message_aid` FOREIGN KEY (`c_app_id`) REFERENCES `t_wx_app` (`c_id`) ON UPDATE CASCADE,
CONSTRAINT `fk_wx_message_bid` FOREIGN KEY (`c_business_id`) REFERENCES `t_business` (`c_id`) ON UPDATE CASCADE
)comment='微信消息';

CREATE TABLE `t_wx_msg_template` (
`c_id`  varchar(128) NOT NULL COMMENT '编号',
`c_template_id`  varchar(128) NOT NULL COMMENT '模板编号',
`c_msg_type`  varchar(128) NULL COMMENT '消息类型',
`c_modify_user`  varchar(128) NULL COMMENT '修改用户' ,
`c_create_user`  varchar(128) NULL COMMENT '创建用户' ,
`c_create_time`  datetime NULL COMMENT '创建时间' ,
`c_modify_time`  datetime NULL COMMENT '修改时间' ,
`c_app_id`  varchar(128) NULL COMMENT '应用编号' ,
`c_business_id`  varchar(128) NULL COMMENT '企业编号' ,
PRIMARY KEY (`c_id`),
CONSTRAINT `t_wx_msg_template_aid` FOREIGN KEY (`c_app_id`) REFERENCES `t_wx_app` (`c_id`) ON UPDATE CASCADE,
CONSTRAINT `t_wx_msg_template_bid` FOREIGN KEY (`c_business_id`) REFERENCES `t_business` (`c_id`) ON UPDATE CASCADE
)comment='微信消息模板';

CREATE TABLE `t_wx_rmc_message` (
	`c_id` VARCHAR (128) NOT NULL COMMENT '编号',
	`c_unique_message` VARCHAR (128) NULL COMMENT '消息唯一计算方法',
	`c_status`  VARCHAR (128)  NULL COMMENT '状态' ,
	`c_rmc_id` INT (10) NULL COMMENT 'RMC消息编号',
	`c_requ_no` VARCHAR (128) NULL COMMENT '工单编号',
	`c_mobile_no` VARCHAR (20) NULL COMMENT '电话号码',
	`c_opend_id` VARCHAR (128) NULL COMMENT 'openID',
	`c_user_id` VARCHAR (128) NULL COMMENT '用户编号',
	`c_seconds` INT (10) NULL COMMENT 'RMC消息产生时间',
	`c_message` VARCHAR (500) NULL COMMENT 'RMC消息',
	`c_create_time` datetime NULL COMMENT '创建时间',
	`c_modify_time` datetime NULL COMMENT '修改时间',
	`c_app_id` VARCHAR (128) NULL COMMENT '应用编号',
	`c_business_id` VARCHAR (128) NULL COMMENT '企业编号',
	PRIMARY KEY (`c_id`),
	CONSTRAINT `t_wx_rmc_message_aid` FOREIGN KEY (`c_app_id`) REFERENCES `t_wx_app` (`c_id`) ON UPDATE CASCADE,
	CONSTRAINT `t_wx_rmc_message_bid` FOREIGN KEY (`c_business_id`) REFERENCES `t_business` (`c_id`) ON UPDATE CASCADE
) COMMENT = 'RMC消息采集';

CREATE TABLE `t_wx_department` (
	`c_id` VARCHAR (128) NOT NULL COMMENT '编号',
	`c_department_id` INT (10) NULL COMMENT '微信部门编号',
	`c_name`  VARCHAR (256)  NULL COMMENT '部门名称' ,
	`c_parentid` INT (10) NULL COMMENT '微信父部门编号',
	`c_order` INT (16) NULL COMMENT '排序编号',
	`c_version` INT (16) NULL COMMENT '版本号',
	`c_create_time` datetime NULL COMMENT '创建时间',
	`c_modify_time` datetime NULL COMMENT '修改时间',
	`c_app_id` VARCHAR (128) NULL COMMENT '应用编号',
	`c_business_id` VARCHAR (128) NULL COMMENT '企业编号',
	PRIMARY KEY (`c_id`),
	CONSTRAINT `t_wx_department_aid` FOREIGN KEY (`c_app_id`) REFERENCES `t_wx_app` (`c_id`) ON UPDATE CASCADE,
	CONSTRAINT `t_wx_department_bid` FOREIGN KEY (`c_business_id`) REFERENCES `t_business` (`c_id`) ON UPDATE CASCADE
) COMMENT = '微信部门';

CREATE TABLE `t_wx_user` (
	`c_id` VARCHAR (128) NOT NULL COMMENT '编号',
	`c_userid` VARCHAR (256) NULL COMMENT '成员UserID。对应管理端的帐号',
	`c_name`  VARCHAR (256)  NULL COMMENT '成员名称' ,
	`c_mobile`  VARCHAR (256)  NULL COMMENT '手机号码' ,
	`c_department`  VARCHAR (256)  NULL COMMENT '成员所属部门id列表' ,
	`c_order`  VARCHAR (256)  NULL COMMENT '部门内的排序值，默认为0。数量必须和department一致，数值越大排序越前面。值范围是[0, 2^32)' ,
	`c_position`  VARCHAR (256)  NULL COMMENT '职位信息' ,
	`c_gender`  VARCHAR (10)  NULL COMMENT '性别。0表示未定义，1表示男性，2表示女性' ,
	`c_email`  VARCHAR (256)  NULL COMMENT '邮箱，第三方仅通讯录套件可获取' ,
	`c_isleader` INT (10) NULL COMMENT '标示是否为上级',
	`c_avatar`  VARCHAR (256)  NULL COMMENT '头像url。注：如果要获取小图将url最后的”/0”改成”/100”即可' ,
	`c_telephone`  VARCHAR (20)  NULL COMMENT '座机。第三方仅通讯录套件可获取' ,
	`c_english_name`  VARCHAR (256)  NULL COMMENT '英文名' ,
	`c_status`  INT (10)  NULL COMMENT '激活状态: 1=已激活，2=已禁用，4=未激活 已激活代表已激活企业微信或已关注微信插件。未激活代表既未激活企业微信又未关注微信插件。' ,
	`c_extattr`  VARCHAR (256)  NULL COMMENT '扩展属性，第三方仅通讯录套件可获取' ,
	`c_version` INT (16) NULL COMMENT '版本号',
	`c_create_time` datetime NULL COMMENT '创建时间',
	`c_modify_time` datetime NULL COMMENT '修改时间',
	`c_app_id` VARCHAR (128) NULL COMMENT '应用编号',
	`c_business_id` VARCHAR (128) NULL COMMENT '企业编号',
	PRIMARY KEY (`c_id`),
	CONSTRAINT `t_wx_user_aid` FOREIGN KEY (`c_app_id`) REFERENCES `t_wx_app` (`c_id`) ON UPDATE CASCADE,
	CONSTRAINT `t_wx_user_bid` FOREIGN KEY (`c_business_id`) REFERENCES `t_business` (`c_id`) ON UPDATE CASCADE
) COMMENT = '微信用户信息';

CREATE TABLE `t_dictionary` (
	`c_id`  varchar(128) NOT NULL COMMENT '编号',
	`c_key`  varchar(128) NULL COMMENT '名称' ,
	`c_value`  varchar(255) NULL COMMENT '值' ,
	`c_type`  varchar(128) NULL COMMENT '字典分类' ,
	`c_create_user`  varchar(128) NULL COMMENT '创建用户' ,
	`c_create_time`  datetime NULL COMMENT '创建时间' ,
	`c_modify_user`  varchar(128) NULL COMMENT '修改用户' ,
	`c_modify_time`  datetime NULL COMMENT '修改时间' ,
	`c_index`  int(255) NULL COMMENT '排序' ,
	PRIMARY KEY (`c_id`)
)comment='数据字典表';

CREATE TABLE `t_wx_bmc_account` (
	`c_id` VARCHAR (128) NOT NULL COMMENT '编号',
	`c_openid`  VARCHAR (256)  NULL DEFAULT '' COMMENT '微信账号' ,
	`c_account`  VARCHAR (256)  NULL  DEFAULT '' COMMENT 'BMC账号',
	`c_password`  VARCHAR (256)  NULL DEFAULT '' COMMENT 'BMC密码',
	`c_create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
	`c_modify_time` datetime NOT NULL DEFAULT NOW() COMMENT '修改时间',
	`c_app_id` VARCHAR (128) NOT NULL COMMENT '应用编号',
	`c_business_id` VARCHAR (128) NOT NULL COMMENT '企业编号',
	PRIMARY KEY (`c_id`),
	CONSTRAINT ` t_wx_bmc_account_aid` FOREIGN KEY (`c_app_id`) REFERENCES `t_wx_app` (`c_id`) ON UPDATE CASCADE,
	CONSTRAINT ` t_wx_bmc_account_bid` FOREIGN KEY (`c_business_id`) REFERENCES `t_business` (`c_id`) ON UPDATE CASCADE
) COMMENT = 'BMC账号信息';

CREATE TABLE `t_wx_bmc_relation` (
	`c_id` VARCHAR (128) NOT NULL COMMENT '编号',
	`c_openid`  VARCHAR (256)  NULL DEFAULT '' COMMENT '微信账号' ,
	`c_account`  VARCHAR (256)  NULL DEFAULT '' COMMENT 'BMC APP 账号',
	`c_create_time` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
	`c_modify_time` datetime NOT NULL DEFAULT NOW() COMMENT '修改时间',
	`c_app_id` VARCHAR (128) NOT NULL COMMENT '应用编号',
	`c_business_id` VARCHAR (128)  NOT NULL COMMENT '企业编号',
	PRIMARY KEY (`c_id`),
	CONSTRAINT ` t_wx_bmc_ relation_aid` FOREIGN KEY (`c_app_id`) REFERENCES `t_wx_app` (`c_id`) ON UPDATE CASCADE,
	CONSTRAINT ` t_wx_bmc_relation_bid` FOREIGN KEY (`c_business_id`) REFERENCES `t_business` (`c_id`) ON UPDATE CASCADE
) COMMENT = 'BMC用户关系';
