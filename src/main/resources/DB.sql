

drop table `detection`.`t_score`
CREATE TABLE  `detection`.`t_score`(
   id int(11)  not null primary key  COMMENT '自增id',
	 user_id int(11)  not null COMMENT '用户id',
	 sum_score decimal  COMMENT '总积分',
	 gain_score decimal  COMMENT '获得积分',
	 use_score decimal  COMMENT '使用积分',
	 create_time datetime  COMMENT '创建时间',
	 gain_time datetime  COMMENT '获得积分时间',
	 use_time datetime  COMMENT '使用积分时间',
	 remark varchar(200)  COMMENT '备注'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table `detection`.`t_template`
CREATE TABLE  `detection`.`t_template`(
   id int(11)  not null primary key  COMMENT '自增id',
	 user_id int(11)  not null COMMENT '用户id',
	 status int(2)  COMMENT '状态',
	 remark varchar(200)  COMMENT '备注',
	 template_file_name varchar(50)  COMMENT '模板文件名',
	 norm_file_name varchar(50)  COMMENT '规范文件名',
	 audio_time datetime  COMMENT '检查时间',
	 submit_time datetime  COMMENT '提交时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table `detection`.`t_mail`
CREATE TABLE  `detection`.`t_mail`(
   id int(11)  not null primary key  COMMENT '自增id',
	 user_id int(11)  not null COMMENT '用户id',
	 receiver_account varchar(50)  COMMENT '备注',
	 theme varchar(100)  COMMENT '主题',
	 message text  COMMENT '内容',
	 create_time datetime  COMMENT '创建时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table `detection`.`t_paper_set`
CREATE TABLE  `detection`.`t_paper_set`(
   id int(11)  not null primary key  COMMENT '自增id',
	 user_id int(11)  not null COMMENT '用户id',
	 school varchar(20)  COMMENT '学校',
	 major varchar(20)  COMMENT '专业',
	 classes varchar(20)  COMMENT '班级',
	 topic int(20)  COMMENT '题目',
	 author varchar(10)  COMMENT '作者',
	 one_tutor varchar(10)  COMMENT '一导师',
	 two_tutor varchar(10)  COMMENT '二导师',
	 create_time datetime  COMMENT '创建时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table `detection`.`t_history_record`
CREATE TABLE  `detection`.`t_history_record`(
   id int(11)  not null primary key  COMMENT '自增id',
	 user_id int(11)  not null COMMENT '用户id',
	 inspect_code varchar(20)  COMMENT '编号',
	 file_name varchar(20)  COMMENT '专业',
	 status int(2)  COMMENT '状态',
	 errorCount int(100)  COMMENT '错误数',
	 mistake decimal  COMMENT '差错率',
	 result int(2) COMMENT '1-合格 2-不合格',
	 submit_time datetime  COMMENT '提交时间',
	 pageCount int(100)  COMMENT '页数',
	 robot varchar(20)  COMMENT '创建时间',
	 type int(2) comment '1-咨询 2-检测'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table `detection`.`t_college`
create table `detection`.`t_college`(
	id int(11) not null COMMENT '自增id',
	school_name varchar(10) not null COMMENT '学校名称',
	school_code int(10) not null COMMENT '学校唯一编码',
	department varchar(20) not null COMMENT '省份/主管部门',
	city varchar(10) not null COMMENT '市区',
	school_level varchar(2) not null COMMENT '办学层次',
	template_id int(11) COMMENT '论文模板id',
	remark varchar(50) COMMENT '备注',
	province_code varchar(10) COMMENT '省份code',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table `detection`.`t_user`
CREATE TABLE `detection`.`t_user`  (
  `id` int(0) NOT NULL  COMMENT '用户id',
  `account` varchar(50)  NOT NULL COMMENT '账号',
  `password` varchar(60)  NOT NULL COMMENT '密码',
  `phone` varchar(50)  NOT NULL COMMENT '手机号',
  `email` varchar(50)  NULL  COMMENT '邮箱',
  `tencent_account` varchar(50)  NULL  COMMENT 'QQ/微信账号',
  `tencent_name` varchar(100)  NULL  COMMENT 'QQ/微信网名',
  `tencent_type` int(0) NULL  COMMENT '1-QQ  2-微信',
  `account_name` varchar(100)  NULL ,
  `sex` char(1) NULL  COMMENT '性别 1-男 2-女',
  `birthday` datetime(0) NULL  COMMENT '生日',
  `address` varchar(60)  NULL  COMMENT '地址',
  `province` varchar(60)  NULL  COMMENT '省',
  `town` varchar(60)  NULL  COMMENT '市',
  `county` varchar(60)  NULL  COMMENT '县',
  `img_url` varchar(50)  NULL  COMMENT '图片地址',
  `status` int(0) NULL DEFAULT 0 COMMENT '状态 0-启用 1-禁用 2-删除',
  `types` int(0) NULL  COMMENT '类型 0-管理员 1-普通用户',
  `create_time` datetime(0) NULL  COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



drop table `detection`.`sys_dict`
create table `detection`.`sys_dict`(
	dict_id int(11) not null primary key comment '自增Id',
	dict_name varchar(20) not null comment '字典名',
	dict_code varchar(50) not null  comment '字典唯一标识',
	dict_value varchar(10) not null comment '字典值',
	dict_type varchar(10) not null comment '字典类型',
	state char(1) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;




drop table `detection`.`t_db_log`
create table `detection`.`t_db_log`(
	id int(11) not null primary key comment '自增Id',
	oper_person varchar(20) not null comment '操作人',
	oper_account varchar(20) not null comment '操作人账号',
	file_path varchar(50) not null comment '原文件路径',
	oper_time datetime(0) not null comment '操作时间',
	remark varchar(50) comment '备注'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;