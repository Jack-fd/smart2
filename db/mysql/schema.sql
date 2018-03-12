-- 系统企业信息
CREATE TABLE sys_business (
  id  varchar(128) NOT NULL DEFAULT '' COMMENT '编号' ,
  create_user  varchar(128) NULL DEFAULT '' COMMENT '创建用户' ,
  create_time  datetime NULL DEFAULT NOW() COMMENT '创建时间' ,
  modify_user  varchar(128) NULL DEFAULT '' COMMENT '修改用户' ,
  modify_time  datetime NULL DEFAULT NOW() COMMENT '修改时间' ,
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  name  varchar(255) NULL DEFAULT '' COMMENT '名称' ,
  display_name  varchar(128) NULL DEFAULT '' COMMENT '显示名称' ,
  is_sys  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否系统数据' ,
  memo  varchar(255) NULL DEFAULT '' COMMENT '备注' ,
  PRIMARY KEY (id),
  UNIQUE KEY uk_sys_business_name (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统企业信息';

-- 系统用户信息
CREATE TABLE sys_user (
  id  varchar(128) NOT NULL DEFAULT '' COMMENT '编号' ,
  create_user  varchar(128) NULL DEFAULT '' COMMENT '创建用户' ,
  create_time  datetime NULL DEFAULT NOW() COMMENT '创建时间' ,
  modify_user  varchar(128) NULL DEFAULT '' COMMENT '修改用户' ,
  modify_time  datetime NULL DEFAULT NOW() COMMENT '修改时间' ,
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  name  varchar(255) NULL DEFAULT '' COMMENT '名称' ,
  display_name  varchar(128) NULL DEFAULT '' COMMENT '显示名称' ,
  is_sys  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否系统数据' ,
  memo  varchar(255) NULL DEFAULT '' COMMENT '备注' ,
  account  varchar(255) NULL COMMENT '账号' ,
  password  varchar(255) NULL COMMENT '密码' ,
  salt  varchar(50) NULL COMMENT '盐' ,
  sex  varchar(16) NULL COMMENT '性别' ,
  icon  varchar(255) NULL COMMENT '头像' ,
  phone  varchar(16) NULL COMMENT '电话' ,
  email  varchar(255) NULL COMMENT '邮箱' ,
  status  tinyint(1) NULL COMMENT '状态' ,
  business_id  varchar(128) NULL COMMENT '企业编号' ,
  PRIMARY KEY (id) ,
  UNIQUE KEY uk_sys_user_account (account),
  CONSTRAINT fk_sys_user_bid FOREIGN KEY (business_id) REFERENCES sys_business (id) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='系统用户信息';

-- 数据字典表
CREATE TABLE sys_dictionary (
  id  varchar(128) NOT NULL DEFAULT '' COMMENT '编号' ,
  create_user  varchar(128) NULL DEFAULT '' COMMENT '创建用户' ,
  create_time  datetime NULL DEFAULT NOW() COMMENT '创建时间' ,
  modify_user  varchar(128) NULL DEFAULT '' COMMENT '修改用户' ,
  modify_time  datetime NULL DEFAULT NOW() COMMENT '修改时间' ,
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  name  varchar(255) NULL DEFAULT '' COMMENT '名称' ,
  display_name  varchar(128) NULL DEFAULT '' COMMENT '显示名称' ,
  is_sys  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否系统数据' ,
  memo  varchar(255) NULL DEFAULT '' COMMENT '备注' ,
  value  varchar(255) NULL COMMENT '值' ,
  type  varchar(128) NULL COMMENT '字典分类' ,
  order_number  int(255) NULL COMMENT '排序' ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- 系统菜单表
CREATE TABLE sys_menu (
  id  varchar(128) NOT NULL DEFAULT '' COMMENT '编号' ,
  create_user  varchar(128) NULL DEFAULT '' COMMENT '创建用户' ,
  create_time  datetime NULL DEFAULT NOW() COMMENT '创建时间' ,
  modify_user  varchar(128) NULL DEFAULT '' COMMENT '修改用户' ,
  modify_time  datetime NULL DEFAULT NOW() COMMENT '修改时间' ,
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  name  varchar(255) NULL DEFAULT '' COMMENT '名称' ,
  display_name  varchar(128) NULL DEFAULT '' COMMENT '显示名称' ,
  is_sys  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否系统数据' ,
  memo  varchar(255) NULL DEFAULT '' COMMENT '备注' ,
  status  tinyint(1) NULL COMMENT '状态' ,
  parent_id bigint COMMENT '父菜单ID，一级菜单为0',
  url varchar(200) COMMENT '菜单URL',
  permissions varchar(500) COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  type int COMMENT '类型   0：目录   1：菜单   2：按钮',
  icon varchar(50) COMMENT '菜单图标',
  order_number int COMMENT '排序',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- 系统角色表
CREATE TABLE sys_role (
  id  varchar(128) NOT NULL DEFAULT '' COMMENT '编号' ,
  create_user  varchar(128) NULL DEFAULT '' COMMENT '创建用户' ,
  create_time  datetime NULL DEFAULT NOW() COMMENT '创建时间' ,
  modify_user  varchar(128) NULL DEFAULT '' COMMENT '修改用户' ,
  modify_time  datetime NULL DEFAULT NOW() COMMENT '修改时间' ,
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  name  varchar(255) NULL DEFAULT '' COMMENT '名称' ,
  display_name  varchar(128) NULL DEFAULT '' COMMENT '显示名称' ,
  is_sys  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否系统数据' ,
  memo  varchar(255) NULL DEFAULT '' COMMENT '备注' ,
  status  tinyint(1) NULL COMMENT '状态' ,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- 系统角色与菜单
CREATE TABLE sys_role_menu_rel (
  id  varchar(128) NOT NULL COMMENT '编号' ,
  role_id  varchar(128) NOT NULL COMMENT '角色编号' ,
  menu_id  varchar(128) NOT NULL COMMENT '菜单编号' ,
  permissions  varchar(128) NOT NULL COMMENT '授权功能' ,
  is_sys  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否系统数据' ,
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  PRIMARY KEY (id),
  CONSTRAINT fk_sys_role_menu_rel_fid FOREIGN KEY (menu_id) REFERENCES sys_menu (id) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色与菜单';

-- 角色与用户
CREATE TABLE sys_role_user_rel (
  id  varchar(128) NOT NULL COMMENT '编号' ,
  role_id  varchar(128) NOT NULL COMMENT '角色编号' ,
  user_id  varchar(128) NOT NULL COMMENT '用户编号' ,
  is_sys  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否系统数据' ,
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  PRIMARY KEY (id),
  CONSTRAINT fk_sys_role_user_rel_rid FOREIGN KEY (role_id) REFERENCES sys_role (id) ON UPDATE CASCADE,
  CONSTRAINT fk_sys_role_user_rel_uid FOREIGN KEY (user_id) REFERENCES sys_user (id) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与用户';

-- 系统应用管理
CREATE TABLE sys_applicaion (
  id  varchar(128) NOT NULL DEFAULT '' COMMENT '编号' ,
  create_user  varchar(128) NULL DEFAULT '' COMMENT '创建用户' ,
  create_time  datetime NULL DEFAULT NOW() COMMENT '创建时间' ,
  modify_user  varchar(128) NULL DEFAULT '' COMMENT '修改用户' ,
  modify_time  datetime NULL DEFAULT NOW() COMMENT '修改时间' ,
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  name  varchar(255) NULL DEFAULT '' COMMENT '名称' ,
  display_name  varchar(128) NULL DEFAULT '' COMMENT '显示名称' ,
  memo  varchar(255) NULL DEFAULT '' COMMENT '备注' ,
  is_test_project  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试项目' ,
  test_close_time  datetime NULL DEFAULT NOW() COMMENT '测试到期时间' ,
  system_type  varchar(128) NOT NULL COMMENT '系统类型，relax、rmc、bmc' ,
  business_id  varchar(128) NULL COMMENT '企业编号' ,
  PRIMARY KEY (id),
  CONSTRAINT fk_sys_applicaion_bid FOREIGN KEY (business_id) REFERENCES sys_business (id) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统应用管理';

-- 微信消息
CREATE TABLE wechat_message (
  id  varchar(128) NOT NULL COMMENT '编号' ,
  system_type  varchar(128) NOT NULL COMMENT '应用类型' ,
  create_time  datetime NULL COMMENT '创建时间' ,
  message  varchar(5000) NOT NULL COMMENT '消息内容' ,
  receive_time  datetime NULL COMMENT '消息收到时间' ,
  send_time  datetime NULL COMMENT '发送时间' ,
  wechat_error_code  bigint(10) NULL COMMENT '微信状态码' ,
  wechat_error_msg  varchar(256) NULL COMMENT '微信消息结果' ,
  wechat_msg_id  bigint(10) NULL COMMENT '微信消息编号' ,
  applicaion_id  varchar(128) NULL COMMENT '应用编号' ,
  business_id  varchar(128) NULL COMMENT '企业编号' ,
  PRIMARY KEY (id),
  CONSTRAINT fk_wechat_message_aid FOREIGN KEY (applicaion_id) REFERENCES sys_applicaion (id) ON UPDATE CASCADE,
  CONSTRAINT fk_wechat_message_bid FOREIGN KEY (business_id) REFERENCES sys_business (id) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信消息';

-- 微信消息模板
CREATE TABLE wechat_message_template (
  id  varchar(128) NOT NULL DEFAULT '' COMMENT '编号' ,
  create_user  varchar(128) NULL DEFAULT '' COMMENT '创建用户' ,
  create_time  datetime NULL DEFAULT NOW() COMMENT '创建时间' ,
  modify_user  varchar(128) NULL DEFAULT '' COMMENT '修改用户' ,
  modify_time  datetime NULL DEFAULT NOW() COMMENT '修改时间' ,
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  name  varchar(255) NULL DEFAULT '' COMMENT '名称' ,
  display_name  varchar(128) NULL DEFAULT '' COMMENT '显示名称' ,
  memo  varchar(255) NULL DEFAULT '' COMMENT '备注' ,
  template_id  varchar(128) NOT NULL COMMENT '模板编号',
  applicaion_message_type  varchar(128) NULL COMMENT '应用消息类型',
  applicaion_id  varchar(128) NULL COMMENT '应用编号' ,
  business_id  varchar(128) NULL COMMENT '企业编号' ,
  PRIMARY KEY (id),
  CONSTRAINT t_wechat_message_template_aid FOREIGN KEY (applicaion_id) REFERENCES sys_applicaion (id) ON UPDATE CASCADE,
  CONSTRAINT t_wechat_message_template_bid FOREIGN KEY (business_id) REFERENCES sys_business (id) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信消息模板';

-- relax微信用用配置
CREATE TABLE wechat_cofnig (
  id  varchar(128) NOT NULL DEFAULT '' COMMENT '编号' ,
  create_user  varchar(128) NULL DEFAULT '' COMMENT '创建用户' ,
  create_time  datetime NULL DEFAULT NOW() COMMENT '创建时间' ,
  modify_user  varchar(128) NULL DEFAULT '' COMMENT '修改用户' ,
  modify_time  datetime NULL DEFAULT NOW() COMMENT '修改时间' ,
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  name  varchar(255) NULL DEFAULT '' COMMENT '名称' ,
  display_name  varchar(128) NULL DEFAULT '' COMMENT '显示名称' ,
  memo  varchar(255) NULL DEFAULT '' COMMENT '备注' ,
  web_url  varchar(128) NOT NULL COMMENT 'web地址' ,
  data_url  varchar(128) NULL COMMENT '数据地址' ,
  wechat_type  varchar(128) NULL COMMENT '微信类型' ,
  corpid_appid  varchar(128) NULL COMMENT '企业号的corpid,服务号appid' ,
  secret  varchar(128) NULL COMMENT '微信密钥' ,
  wechat_appid  int(255) NULL COMMENT '微信应用编号' ,
  applicaion_account  VARCHAR (256)  NULL  DEFAULT '' COMMENT '应用系统账号',
  applicaion_password  VARCHAR (256)  NULL DEFAULT '' COMMENT '应用系统密码',
  applicaion_id  varchar(128) NULL COMMENT '应用编号' ,
  business_id  varchar(128) NULL COMMENT '企业编号' ,
  PRIMARY KEY (id),
  CONSTRAINT fk_wechat_cofnig_aid FOREIGN KEY (applicaion_id) REFERENCES sys_applicaion (id) ON UPDATE CASCADE,
  CONSTRAINT fk_wechat_cofnig_bid FOREIGN KEY (business_id) REFERENCES sys_business (id) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信用用配置';

-- RMC消息采集
CREATE TABLE rmc_wechat_message (
  id VARCHAR (128) NOT NULL COMMENT '编号',
  unique_message VARCHAR (128) NULL COMMENT '消息唯一计算方法',
  status  VARCHAR (128)  NULL DEFAULT '' COMMENT '状态' ,
  rmcid INT (10) NULL COMMENT 'RMC消息编号',
  requ_no VARCHAR (128) NULL DEFAULT '' COMMENT '工单编号',
  mobile_no VARCHAR (20) NULL DEFAULT '' COMMENT '电话号码',
  opend_id VARCHAR (128) NULL DEFAULT '' COMMENT 'openID',
  user_id VARCHAR (128) NULL DEFAULT '' COMMENT '用户编号',
  seconds INT (10) NULL COMMENT 'RMC消息产生时间',
  message VARCHAR (500) NULL COMMENT 'RMC消息',
  create_time datetime NULL DEFAULT NOW() COMMENT '创建时间',
  modify_time datetime NULL DEFAULT NOW() COMMENT '修改时间',
  applicaion_id VARCHAR (128) NULL DEFAULT '' COMMENT '应用编号',
  business_id VARCHAR (128) NULL COMMENT '企业编号',
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  PRIMARY KEY (id),
  CONSTRAINT fk_rmc_wechat_message_aid FOREIGN KEY (applicaion_id) REFERENCES sys_applicaion (id) ON UPDATE CASCADE,
  CONSTRAINT fk_rmc_wechat_message_bid FOREIGN KEY (business_id) REFERENCES sys_business (id) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT = 'RMC消息采集';

-- BMC账号信息
CREATE TABLE bmc_wechat_account (
  id VARCHAR (128) NOT NULL COMMENT '编号',
  openid  VARCHAR (256)  NULL DEFAULT '' COMMENT '微信账号' ,
  account  VARCHAR (256)  NULL  DEFAULT '' COMMENT 'BMC账号',
  password  VARCHAR (256)  NULL DEFAULT '' COMMENT 'BMC密码',
  create_time datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  modify_time datetime NOT NULL DEFAULT NOW() COMMENT '修改时间',
  applicaion_id VARCHAR (128) NOT NULL COMMENT '应用编号',
  business_id VARCHAR (128) NOT NULL COMMENT '企业编号',
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  PRIMARY KEY (id),
  CONSTRAINT fk_bmc_awechat_bmc_account_aid FOREIGN KEY (applicaion_id) REFERENCES sys_applicaion (id) ON UPDATE CASCADE,
  CONSTRAINT fk_bmc_awechat_bmc_account_bid FOREIGN KEY (business_id) REFERENCES sys_business (id) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT = 'BMC账号信息';

-- BMC用户关系
CREATE TABLE bmc_wechat_relation (
  id VARCHAR (128) NOT NULL COMMENT '编号',
  openid  VARCHAR (256)  NULL DEFAULT '' COMMENT '微信账号' ,
  account  VARCHAR (256)  NULL DEFAULT '' COMMENT 'BMC APP 账号',
  create_time datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
  modify_time datetime NOT NULL DEFAULT NOW() COMMENT '修改时间',
  applicaion_id VARCHAR (128) NOT NULL COMMENT '应用编号',
  business_id VARCHAR (128)  NOT NULL COMMENT '企业编号',
  is_test  tinyint(1) NOT NULL DEFAULT FALSE COMMENT '是否测试数据' ,
  PRIMARY KEY (id),
  CONSTRAINT fk_wechat_bmc_relation_aid FOREIGN KEY (applicaion_id) REFERENCES sys_applicaion (id) ON UPDATE CASCADE,
  CONSTRAINT fk_wechat_bmc_relation_bid FOREIGN KEY (business_id) REFERENCES sys_business (id) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT = 'BMC用户关系';

-- 系统日志
CREATE TABLE sys_log (
  id VARCHAR (128) NOT NULL COMMENT '编号',
  user_name varchar(50) COMMENT '用户名',
  operation varchar(50) COMMENT '用户操作',
  method varchar(200) COMMENT '请求方法',
  params varchar(5000) COMMENT '请求参数',
  time bigint NOT NULL COMMENT '执行时长(毫秒)',
  ip varchar(64) COMMENT 'IP地址',
  create_date datetime COMMENT '创建时间',
  PRIMARY KEY (id)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';